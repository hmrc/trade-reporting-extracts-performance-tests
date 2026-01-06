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
import uk.gov.hmrc.perftests.tre.helper._

object RequestNewReport_Requests {

  def getRequestReportStartPage: HttpRequestBuilder =
    http("[REQ-1] GET: Navigate to the starting page")
      .get(s"$baseURL$baseRoute/request-cds-report")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getWhichEoriPage: HttpRequestBuilder =
    http("[REQ-2] GET: Navigate to which eori number page")
      .get(s"$baseURL$baseRoute/which-eori")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postWhichEoripage: HttpRequestBuilder =
    http("[REQ-2] POST: posting Eori Number")
      .post(s"$baseURL$baseRoute/which-eori")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "myEori")
      .check(status.is(303))

  def getRequestTypePage: HttpRequestBuilder =
    http("[REQ-3] GET: Navigate to report type page")
      .get(s"$baseURL$baseRoute/data-download")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postRequestTypePage: HttpRequestBuilder =
    http("[REQ-3] POST: posting type of data to download")
      .post(s"$baseURL$baseRoute/data-download")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "import")
      .check(status.is(303))

  def getReportRolePage: HttpRequestBuilder =
    http("[REQ-4] GET: Navigate to the user role in report page")
      .get(s"$baseURL$baseRoute/your-role")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportRolePage: HttpRequestBuilder =
    http("[REQ-4] POST: posting user role in the report")
      .post(s"$baseURL$baseRoute/your-role")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "declarant")
      .formParam("value[1]", "importer")
      .check(status.is(303))

  def getReportSubtypeSelectionPage: HttpRequestBuilder =
    http("[REQ-5] GET: Navigate to report subtype selection page")
      .get(s"$baseURL$baseRoute/import-report-type")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportSubtypeSelectionPage: HttpRequestBuilder =
    http("[REQ-5] POST: posting owner of the Eori Number role")
      .post(s"$baseURL$baseRoute/import-report-type")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "importHeader")
      .formParam("value[1]", "importItem")
      .formParam("value[2]", "importTaxLine")
      .check(status.is(303))

  def getDateRangePage: HttpRequestBuilder =
    http("[REQ-7] GET: Navigate to date range selection page")
      .get(s"$baseURL$baseRoute/date-range")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDateRangePage: HttpRequestBuilder =
    http("[REQ-7] POST: posting date range to cover reports")
      .post(s"$baseURL$baseRoute/date-range")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "CustomDateRange")
      .check(status.is(303))

  def getDateRangeStartPage: HttpRequestBuilder =
    http("[REQ-8] GET: Navigate to custom date start page")
      .get(s"$baseURL$baseRoute/start-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDateRangeStartPage: HttpRequestBuilder =
    http("[REQ-8] POST: posting a start date 30 days ago from today")
      .post(s"$baseURL$baseRoute/start-date")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value.day", getDateMinusDays("dd", 30))
      .formParam("value.month", getDateMinusDays("MM", 30))
      .formParam("value.year", getDateMinusDays("YYYY", 30))
      .check(status.is(303))

  def getDateRangeEndPage: HttpRequestBuilder =
    http("[REQ-9] GET: Navigate to custom date end page")
      .get(s"$baseURL$baseRoute/end-date")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDateRangeEndPage: HttpRequestBuilder =
    http("[REQ-9] POST: posting an end date 3 days ago from today")
      .post(s"$baseURL$baseRoute/end-date")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value.day", getDateMinusDays("dd", 5))
      .formParam("value.month", getDateMinusDays("MM", 5))
      .formParam("value.year", getDateMinusDays("YYYY", 5))
      .check(status.is(303))

  def getReportNamePage: HttpRequestBuilder =
    http("[REQ-10] GET: Navigate to report name page")
      .get(s"$baseURL$baseRoute/report-name")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportNamePage: HttpRequestBuilder =
    http("[REQ-10] POST: posting name to identify reports")
      .post(s"$baseURL$baseRoute/report-name")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "tre")
      .check(status.is(303))

  def getChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("[REQ-11] GET: Navigate to choose to add email address page")
      .get(s"$baseURL$baseRoute/add-another-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("[REQ-11] POST: posting choose to add email address page")
      .post(s"$baseURL$baseRoute/add-another-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  // REQ-12: Choose email, if an additional email is already associated to the account.

  def getEnterEmailPage: HttpRequestBuilder =
    http("[REQ-13] GET: Navigate to enter new email page")
      .get(s"$baseURL$baseRoute/new-notification-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postEnterEmailPage: HttpRequestBuilder =
    http("[REQ-13] POST: posting to enter new email page")
      .post(s"$baseURL$baseRoute/new-notification-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "email@email.com")
      .check(status.is(303))

  def getCheckEmailPage: HttpRequestBuilder =
    http("[REQ-14] GET: Navigate to enter new email page")
      .get(s"$baseURL$baseRoute/check-new-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckEmailPage: HttpRequestBuilder =
    http("[REQ-14] POST: posting to enter new email page")
      .post(s"$baseURL$baseRoute/check-new-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getCheckYourAnswerPage: HttpRequestBuilder =
    http("[REQ-15] GET: Navigate to check answers page")
      .get(s"$baseURL$baseRoute/check-your-answers")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckYourAnswerPage: HttpRequestBuilder =
    http("[REQ-15] POST: posting to check answers page")
      .post(s"$baseURL$baseRoute/submit-report")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  def getSubmissionPage: HttpRequestBuilder =
    http("[REQ-16] GET: Navigate to submission page")
      .get(s"$baseURL$baseRoute/report-request-confirmation")
      .header("Cookie", authCookie)
      .check(status.is(200))
}
