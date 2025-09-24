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

package uk.gov.hmrc.perftests.tre.steps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}

import uk.gov.hmrc.perftests.tre.requests.Helper_Requests.generateRandEORI
import uk.gov.hmrc.perftests.tre.requests._

trait ReportSteps extends PerformanceTestRunner {

  val randEORI = generateRandEORI()

  val loginDashboard   = LoginDashboard_Requests
  val requestNewReport = RequestNewReport_Requests
  val viewRequested    = ViewRequested_Requests
  val viewDownloadable = ViewDownloadable_Requests

  def LogInAndRequestNewReport(id: String, description: String): JourneyPart =
    setup(id, description).withRequests(
      loginDashboard.getLoginPage,
      loginDashboard.postAuthWizLogin(randEORI),
      loginDashboard.getDashboardPage,
      requestNewReport.getRequestReportStartPage,
      requestNewReport.getRequestTypePage,
      requestNewReport.postRequestTypePage,
      requestNewReport.getWhichEoriPage,
      requestNewReport.postWhichEoripage,
      requestNewReport.getReportRolePage,
      requestNewReport.postReportRolePage,
      requestNewReport.getReportSubtypeSelectionPage,
      requestNewReport.postReportSubtypeSelectionPage,
      requestNewReport.getDateRangePage,
      requestNewReport.postDateRangePage,
      requestNewReport.getReportNamePage,
      requestNewReport.postReportNamePage,
      requestNewReport.getChooseToAddAnotherEmailPage,
      requestNewReport.postChooseToAddAnotherEmailPage,
      requestNewReport.getCheckYourAnswerPage,
      requestNewReport.postCheckYourAnswerPage,
      requestNewReport.getSubmissionPage
    )

  def LogInAndCheckRequestedReports(id: String, description: String): JourneyPart =
    setup(id, description).withRequests(
      loginDashboard.getLoginPage,
      loginDashboard.postAuthWizLogin(randEORI),
      loginDashboard.getDashboardPage,
      viewRequested.getViewRequestedReportsPage
    )

  def LogInAndCheckDownloadableReports(id: String, description: String): JourneyPart =
    setup(id, description).withRequests(
      loginDashboard.getLoginPage,
      loginDashboard.postAuthWizLogin(randEORI),
      loginDashboard.getDashboardPage,
      viewDownloadable.getViewDownloadableReportsPage
    )
}
