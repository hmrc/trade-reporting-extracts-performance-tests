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
import uk.gov.hmrc.perftests.tre.requests.Helper_Requests._

object RequestNewReport_Requests extends ServicesConfiguration {

  def getRequestReportStartPage: HttpRequestBuilder =
    http("[REQ-1] GET: Navigate to the starting page")
      .get(s"$baseURL$baseRoute/request-cds-report")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getRequestTypePage: HttpRequestBuilder =
    http("[REQ-2] GET: Navigate to report type page")
      .get(s"$baseURL$baseRoute/data-download")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postRequestTypePage: HttpRequestBuilder =
    http("[REQ-2] POST: posting type of data to download")
      .post(s"$baseURL$baseRoute/data-download")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "import")
      .check(status.is(303))

  def getWhichEoriPage: HttpRequestBuilder =
    http("[REQ-3] GET: Navigate to which eori number page")
      .get(s"$baseURL$baseRoute/which-eori")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postWhichEoripage: HttpRequestBuilder =
    http("[REQ-3] POST: posting Eori Number")
      .post(s"$baseURL$baseRoute/which-eori")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "myEori")
      .check(status.is(303))

  def getReportRolePage: HttpRequestBuilder =
    http("[REQ-5] GET: Navigate to the user role in report page")
      .get(s"$baseURL$baseRoute/your-role")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportRolePage: HttpRequestBuilder =
    http("[REQ-5] POST: posting user role in the report")
      .post(s"$baseURL$baseRoute/your-role")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "declarant")
      .formParam("value[1]", "importer")
      .check(status.is(303))

  def getReportSubtypeSelectionPage: HttpRequestBuilder =
    http("[REQ-6] GET: Navigate to report subtype selection page")
      .get(s"$baseURL$baseRoute/import-report-type")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportSubtypeSelectionPage: HttpRequestBuilder =
    http("[REQ-6] POST: posting owner of the Eori Number role")
      .post(s"$baseURL$baseRoute/import-report-type")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "importHeader")
      .formParam("value[1]", "importItem")
      .formParam("value[2]", "importTaxLine")
      .check(status.is(303))

  def getDateRangePage: HttpRequestBuilder =
    http("[REQ-8] GET: Navigate to date range selection page")
      .get(s"$baseURL$baseRoute/date-range")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDateRangePage: HttpRequestBuilder =
    http("[REQ-8] POST: posting date range to cover reports")
      .post(s"$baseURL$baseRoute/date-range")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "lastFullCalendarMonth")
      .check(status.is(303))

  def getReportNamePage: HttpRequestBuilder =
    http("[REQ-11] GET: Navigate to report name page")
      .get(s"$baseURL$baseRoute/report-name")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportNamePage: HttpRequestBuilder =
    http("[REQ-11] POST: posting name to identify reports")
      .post(s"$baseURL$baseRoute/report-name")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "tre")
      .check(status.is(303))

  def getChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("[REQ-12] GET: Navigate to choose to add email address page")
      .get(s"$baseURL$baseRoute/add-another-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("[REQ-13] POST: posting choose to add email address page")
      .post(s"$baseURL$baseRoute/add-another-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "false")
      .check(status.is(303))

  def getCheckYourAnswerPage: HttpRequestBuilder =
    http("[REQ-15] GET: Navigate to check answers page")
      .get(s"$baseURL$baseRoute/check-your-answers")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckYourAnswerPage: HttpRequestBuilder =
    http("[REQ-15] POST: posting to check answers page")
      .post(s"$baseURL$baseRoute/check-your-answers")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  def getSubmissionPage: HttpRequestBuilder =
    http("[REQ-16] GET: Navigate to submission page")
      .get(s"$baseURL$baseRoute/report-request-confirmation")
      .header("Cookie", authCookie)
      .check(status.is(200))
}
