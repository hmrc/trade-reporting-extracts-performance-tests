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

import support.builders.UserCredentialsBuilder.anOrganisationUserWithKnownEnrolment
import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}

import uk.gov.hmrc.perftests.tre.requests.LoginRquests._
import uk.gov.hmrc.perftests.tre.requests.RequestNewRequests._

trait ReportSteps extends PerformanceTestRunner {

  def LoginAndRequestNewReport(id: String, description: String): JourneyPart = setup(id, description).withRequests(
    getGuidancePage,
    getLoginPage,
    postLoginPage(anOrganisationUserWithKnownEnrolment),
    getDashboardPage,
    getRequestReportStartPage,
    getRequestTypePage,
    postRequestTypePage,
    getWhichEoriPage,
    postWhichEoripage,
    getReportRolePage,
    postReportRolePage,
    getReportSubtypeSelectionPage,
    postReportSubtypeSelectionPage,
    getDateRangePage,
    postDateRangePage,
    getReportNamePage,
    postReportNamePage,
    getChooseToAddAnotherEmailPage,
    postChooseToAddAnotherEmailPage,
    getCheckYourAnswerPage,
    postCheckYourAnswerPage,
    getSubmissionPage
  )

  def LoginAndCheckAvailableReports(id: String, description: String): JourneyPart = setup(id, description).withRequests(
    getGuidancePage,
    getLoginPage,
    postLoginPage(anOrganisationUserWithKnownEnrolment),
    getDashboardPage
  )

  def LoginAndCheckDownloadableReports(id: String, description: String): JourneyPart =
    setup(id, description).withRequests(
      getGuidancePage,
      getLoginPage,
      postLoginPage(anOrganisationUserWithKnownEnrolment),
      getDashboardPage
    )
}
