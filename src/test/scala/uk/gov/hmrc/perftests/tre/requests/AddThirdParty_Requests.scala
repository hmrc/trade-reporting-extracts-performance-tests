/*
 * Copyright 2025 HM Revenue & Customs
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
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.tre.helper._

object AddThirdParty_Requests extends ServicesConfiguration {

  def getAddThirdPartyStartPage: HttpRequestBuilder =
    http("[ADD-1] GET: Navigate to the starting page.")
      .get(s"$baseURL$baseRoute/add-a-third-party")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getImporterOrExporterPage: HttpRequestBuilder =
    http("[ADD-2] GET: Navigate to the 'Importer' or 'Exporter' page.")
      .get(s"$baseURL$baseRoute/importer-or-exporter")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postImporterOrExporterPage: HttpRequestBuilder =
    http("[ADD-2] POST: posting 'yes'.")
      .post(s"$baseURL$baseRoute/importer-or-exporter")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getEORINumberPage: HttpRequestBuilder =
    http("[ADD-3] GET: Navigate to the enter EORI number page.")
      .get(s"$baseURL$baseRoute/eori-number")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postEORINumberPage(eori: String): HttpRequestBuilder =
    http(s"[ADD-3] POST: posting EORI number '$eori'.")
      .post(s"$baseURL$baseRoute/eori-number")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", eori)
      .check(status.is(303))

  def getConfirmEORIPage: HttpRequestBuilder =
    http("[ADD-4] GET: Navigate to confirm EORI number page.")
      .get(s"$baseURL$baseRoute/confirm-eori")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postConfirmEORIPage: HttpRequestBuilder =
    http(s"[ADD-4] POST: posting 'yes' to confirm EORI.")
      .post(s"$baseURL$baseRoute/confirm-eori")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "yes")
      .check(status.is(303))

  // ADD-5: Reference name.

  def getAccessStartPage: HttpRequestBuilder =
    http("[ADD-6] GET: Navigate to access start page.")
      .get(s"$baseURL$baseRoute/access-start-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postAccessStartPage: HttpRequestBuilder =
    http(s"[ADD-6] POST: posting today's date.")
      .post(s"$baseURL$baseRoute/access-start-date")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value.day", "25")
      .formParam("value.month", "9")
      .formParam("value.year", "2025")
      .check(status.is(303))

  def getAccessEndPage: HttpRequestBuilder =
    http("[ADD-7] GET: Navigate to access end page.")
      .get(s"$baseURL$baseRoute/access-end-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postAccessEndPage: HttpRequestBuilder =
    http(s"[ADD-7] POST: continuing without entering an end date.")
      .post(s"$baseURL$baseRoute/access-end-date")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  def getTypeOfDataPage: HttpRequestBuilder =
    http("[ADD-8] GET: Navigate to type of data page.")
      .get(s"$baseURL$baseRoute/data-types")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postTypeOfDataPage: HttpRequestBuilder =
    http(s"[ADD-8] POST: posting 'import' and 'export' types.")
      .post(s"$baseURL$baseRoute/data-types")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "import")
      .formParam("value[1]", "export")
      .check(status.is(303))

  def getGiveDataAccess: HttpRequestBuilder =
    http("[ADD-9] GET: Navigate to give data access range page.")
      .get(s"$baseURL$baseRoute/data-access-range")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postGiveDataAccess: HttpRequestBuilder =
    http(s"[ADD-9] POST: posting 'no' to enter custom range'")
      .post(s"$baseURL$baseRoute/data-access-range")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "customDateRange")
      .check(status.is(303))

  def getDataAccessStart: HttpRequestBuilder =
    http("[ADD-10] GET: Navigate to data access start date page.")
      .get(s"$baseURL$baseRoute/data-start-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDataAccessStart: HttpRequestBuilder =
    http(s"[ADD-10] POST: posting a date four years ago from today")
      .post(s"$baseURL$baseRoute/data-start-date")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value.day", "25")
      .formParam("value.month", "9")
      .formParam("value.year", "2021")
      .check(status.is(303))

  def getDataAccessEnd: HttpRequestBuilder =
    http("[ADD-11] GET: Navigate to data access end date page.")
      .get(s"$baseURL$baseRoute/data-end-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDataAccessEnd: HttpRequestBuilder =
    http(s"[ADD-11] POST: continuing without entering an end date.")
      .post(s"$baseURL$baseRoute/data-end-date")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  // QA Note:
  // Pending a fix to add the CsrfToken to the confirmation page -- it is not currently present.

  def getCheckAnswersPage: HttpRequestBuilder =
    http("[ADD-12] GET: Navigate to check answers page.")
      .get(s"$baseURL$baseRoute/check-your-answers-third-party")
      .header("Cookie", authCookie)
      .check(status.is(200))
  // .check(saveCsrfToken)

  // def postCheckAnswersPage: HttpRequestBuilder =
  //   http(s"[ADD-12] POST: posting check answers page")
  //     .post(s"$baseURL$baseRoute/check-your-answers-third-party")
  //     .formParam("csrfToken", "#{csrfToken}")
  //     .check(status.is(303))

  // def getConfirmAnswersPage: HttpRequestBuilder =
  //   http("[ADD-13] GET: Navigate to confirmation page.")
  //     .get(s"$baseURL$baseRoute/third-party-added-confirmation")
  //     .header("Cookie", authCookie)
  //     .check(status.is(200))
}
