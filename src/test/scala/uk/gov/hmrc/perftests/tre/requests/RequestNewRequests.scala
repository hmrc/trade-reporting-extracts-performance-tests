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
      .check(status.is(200))

  def getRequestReportPage: HttpRequestBuilder =
    http("Navigate to request a report page")
      .get(s"$baseUrl$route/request-cds-report")
      .check(status.is(200))

  def getRequestTypePage: HttpRequestBuilder =
    http("Navigate to report type page")
      .get(s"$baseUrl$route/data-download")
      .check(status.is(200))

  def postRequestTypePage: HttpRequestBuilder =
    http("posting type of data to download")
      .post(s"$baseUrl$route/data-download")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "import")
      .check(status.is(303))
      .check(header("Location").is(s"$route/which-eori").saveAs("eoriNumber"))

  def getWhichEoriPage: HttpRequestBuilder =
    http("Navigate to which eori number page")
      .get(s"$baseUrl" + "${eoriNumber}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postEoriNumberpage: HttpRequestBuilder =
    http("posting Eori Number")
      .post(s"$baseUrl" + "${eoriNumber}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "myEori")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/eoriRole").saveAs("eoriRole"))

  def getReportOwnerTypePage: HttpRequestBuilder =
    http("Navigate to which eori number page")
      .get(s"$baseUrl" + "${eoriRole}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postEoriNumberOwnerRolePage: HttpRequestBuilder =
    http("posting owner of the Eori Number role")
      .post(s"$baseUrl" + "${eoriRole}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "declarant")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/report-type").saveAs("reportType"))

  def getReportSubtypeSelectionPage: HttpRequestBuilder =
    http("Navigate to report subtype selection page")
      .get(s"$baseUrl" + "${reportType}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTypeOfReportPage: HttpRequestBuilder =
    http("posting owner of the Eori Number role")
      .post(s"$baseUrl" + "${reportType}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "importHeader")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/date-rage").saveAs("dateRange"))

  def getDateRangePage: HttpRequestBuilder =
    http("Navigate to date range selection page")
      .get(s"$baseUrl" + "${dateRange}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postDateRangeToCoverReportPage: HttpRequestBuilder =
    http("posting date range to cover reports")
      .post(s"$baseUrl" + "${reportType}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "lastThirtyOneDays")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/report-name").saveAs("reportName"))

  def getReportNamePage: HttpRequestBuilder =
    http("Navigate to report name page")
      .get(s"$baseUrl" + "${reportName}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postNameofReportPage: HttpRequestBuilder =
    http("posting name to identify reports")
      .post(s"$baseUrl" + "${reportName}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "tre")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/choose-email-address").saveAs("chooseEmailAddress"))

  def getChooseToAddEmailAddressPage: HttpRequestBuilder =
    http("Navigate to choose to add email address page")
      .get(s"$baseUrl" + "${chooseEmailAddress}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWantToAddAnotherEmailPage: HttpRequestBuilder =
    http("posting add another email address")
      .post(s"$baseUrl" + "${reportName}")
      .formParam("csrfToken", "${csrfToken}")
      .formParam("value", "false")
      .check(status.is(303))
      .check(header("Location").is(s"$route/request-cds-report/check-your-answers"))

  def getCheckYourAnswerPage: HttpRequestBuilder =
    http("Navigate to choose to add email address page")
      .get(s"$baseUrl" + s"$route" + "/check-your-answers")
      .check(status.is(200))

}
