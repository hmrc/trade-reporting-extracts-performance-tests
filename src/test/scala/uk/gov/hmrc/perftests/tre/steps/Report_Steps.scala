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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner

import uk.gov.hmrc.perftests.tre.helper.generateRandEORI
import uk.gov.hmrc.perftests.tre.requests.{LoginDashboard_Requests => loginDashboard, RequestNewReport_Requests => requestNewReport, ViewDownloadable_Requests => viewDownloadable, ViewRequested_Requests => viewRequested}

trait Report_Steps extends PerformanceTestRunner {

  private val randEORI = generateRandEORI()

  setup("log-in-and-request-new-report", "Reports 1: Request new report.").withRequests(
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

  setup("log-in-and-check-requested-reports", "Reports 2: View reports requested.").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin(randEORI),
    loginDashboard.getDashboardPage,
    viewRequested.getViewRequestedReportsPage
  )

  setup("log-in-and-check-downloadable-reports", "Reports 3: View reports for download.").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin(randEORI),
    loginDashboard.getDashboardPage,
    viewDownloadable.getViewDownloadableReportsPage
  )
}
