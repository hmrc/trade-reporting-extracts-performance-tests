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
import uk.gov.hmrc.perftests.tre.requests.RequestsHelper.{authCookie, saveCsrfToken}

object RequestNewRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("trade-reporting-extracts")
  val route: String   = "/request-customs-declaration-data"

  def getGuidancePage: HttpRequestBuilder =
    http("Navigate to guidance page")
      .get(s"$baseUrl$route/")
      .check(status.is(200))

  def getDashboardPage: HttpRequestBuilder =
    http("Navigate to dashboard page")
      .get(s"$baseUrl$route/dashboard")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getRequestReportStartPage: HttpRequestBuilder =
    http("Navigate to the starting page")
      .get(s"$baseUrl$route/request-cds-report")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getRequestTypePage: HttpRequestBuilder =
    http("Navigate to report type page")
      .get(s"$baseUrl$route/data-download")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postRequestTypePage: HttpRequestBuilder =
    http("posting type of data to download")
      .post(s"$baseUrl$route/data-download")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "import")
      .check(status.is(303))

  def getWhichEoriPage: HttpRequestBuilder =
    http("Navigate to which eori number page")
      .get(s"$baseUrl$route/which-eori")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postWhichEoripage: HttpRequestBuilder =
    http("posting Eori Number")
      .post(s"$baseUrl$route/which-eori")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "myEori")
      .check(status.is(303))

  def getReportRolePage: HttpRequestBuilder =
    http("Navigate to the user role in report page")
      .get(s"$baseUrl$route/your-role")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportRolePage: HttpRequestBuilder =
    http("posting user role in the report")
      .post(s"$baseUrl$route/your-role")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "declarant")
      .formParam("value[1]", "importer")
      .check(status.is(303))

  def getReportSubtypeSelectionPage: HttpRequestBuilder =
    http("Navigate to report subtype selection page")
      .get(s"$baseUrl$route/import-report-type")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportSubtypeSelectionPage: HttpRequestBuilder =
    http("posting owner of the Eori Number role")
      .post(s"$baseUrl$route/import-report-type")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value[0]", "importHeader")
      .formParam("value[1]", "importItem")
      .formParam("value[2]", "importTaxLine")
      .check(status.is(303))

  def getDateRangePage: HttpRequestBuilder =
    http("Navigate to date range selection page")
      .get(s"$baseUrl$route/date-range")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postDateRangePage: HttpRequestBuilder =
    http("posting date range to cover reports")
      .post(s"$baseUrl$route/date-range")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "lastFullCalendarMonth")
      .check(status.is(303))

  def getReportNamePage: HttpRequestBuilder =
    http("Navigate to report name page")
      .get(s"$baseUrl$route/report-name")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postReportNamePage: HttpRequestBuilder =
    http("posting name to identify reports")
      .post(s"$baseUrl$route/report-name")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "tre")
      .check(status.is(303))

  def getChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("Navigate to choose to add email address page")
      .get(s"$baseUrl$route/add-another-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postChooseToAddAnotherEmailPage: HttpRequestBuilder =
    http("posting choose to add email address page")
      .post(s"$baseUrl$route/add-another-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "false")
      .check(status.is(303))

  def getCheckYourAnswerPage: HttpRequestBuilder =
    http("Navigate to check answers page")
      .get(s"$baseUrl$route/check-your-answers")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckYourAnswerPage: HttpRequestBuilder =
    http("posting to check answers page")
      .post(s"$baseUrl$route/check-your-answers")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  def getSubmissionPage: HttpRequestBuilder =
    http("Navigate to submission page")
      .get(s"$baseUrl$route/report-request-confirmation")
      .header("Cookie", authCookie)
      .check(status.is(200))
}
