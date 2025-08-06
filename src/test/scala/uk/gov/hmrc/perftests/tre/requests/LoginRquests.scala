/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.tre.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import support.models.UserCredentials
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object LoginRquests extends ServicesConfiguration {

  val authURL: String = baseUrlFor("auth-login-stub")
  val baseURL: String = baseUrlFor("trade-reporting-extracts")

  def getLoginPage: HttpRequestBuilder = http("Get AuthWiz Login Page")
    .get(authURL + s"/auth-login-stub/gg-sign-in")
    .check(status.is(200))

  def postLoginPage(userCredentials: UserCredentials): HttpRequestBuilder = {
    val builder = http("Sign in through AuthWiz")
      .post(s"$authURL/auth-login-stub/gg-sign-in")
      .formParam("redirectionUrl", s"$baseURL/request-customs-declaration-data/dashboard")
      .formParam("credentialStrength", "strong")
      .formParam("confidenceLevel", "50")
      .formParam("affinityGroup", userCredentials.affinityGroup.toString)
      .formParam("credentialRole", userCredentials.credentialRole.toString)
      .formParam("email", "user@test.com")
      .formParam("authorityId", "")

    userCredentials.enrolmentsData match {
      case Some(data) =>
        builder
          .formParam("enrolment[0].name", data.enrolmentKey)
          .formParam("enrolment[0].taxIdentifier[0].name", data.identifierName)
          .formParam("enrolment[0].taxIdentifier[0].value", data.identifierValue)
          .formParam("enrolment[0].state", "Activated")
          .check(status.is(303))
          .check(headerRegex("Set-Cookie", """mdtp=(.*)""").saveAs("mdtpCookie"))

      case None => builder.check(status.is(303))
    }
  }
}
