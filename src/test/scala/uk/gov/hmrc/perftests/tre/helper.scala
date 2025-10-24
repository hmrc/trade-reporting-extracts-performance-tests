/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.tre

import scala.util.Random
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import uk.gov.hmrc.performance.conf.ServicesConfiguration

object helper extends ServicesConfiguration {

  // Randomisation of EORI per session, simulating multiple users.
  def generateRandEORI(): String = {
    val randID = (1 to 12).map(_ => new Random().nextInt(9)).mkString
    return s"GB$randID"
  }

  val validEORI: String   = "GB123456123456"
  val invalidEORI: String = "GB333333333331"

  // Tokens and Cookies
  val authCookie: String       = "mdtp=${mdtpCookie}"
  def saveCsrfToken: HttpCheck = css("input[name=csrfToken]", "value").saveAs("csrfToken")

  // URLs
  val authURL: String   = baseUrlFor("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  val baseURL: String   = baseUrlFor("trade-reporting-extracts")
  val baseRoute: String = "/request-customs-declaration-data"

  // Functions
  def getDateMinusDays(format: String = "dd-MM-yyyy", daysToReduce: Int = 0): String =
    LocalDateTime.now().minusDays(daysToReduce).format(DateTimeFormatter.ofPattern(format))
}
