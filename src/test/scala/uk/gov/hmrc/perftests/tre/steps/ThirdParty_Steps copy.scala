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
import uk.gov.hmrc.perftests.tre.requests.{AddThirdParty_Requests => addThirdParty, LoginDashboard_Requests => loginDashboard, ManageThirdParty_Requests => manageThirdParty}

trait ThirdParty_Steps extends PerformanceTestRunner {

  setup("add-third-party", "Third Party J1: Add a third party.").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin,
    loginDashboard.getDashboardPage,
    addThirdParty.getAddThirdPartyStartPage,
    addThirdParty.getImporterOrExporterPage,
    addThirdParty.postImporterOrExporterPage,
    addThirdParty.getEORINumberPage,
    addThirdParty.postEORINumberPage,
    addThirdParty.getConfirmEORIPage,
    addThirdParty.postConfirmEORIPage,
    addThirdParty.getAccessStartPage,
    addThirdParty.postAccessStartPage,
    addThirdParty.getAccessEndPage,
    addThirdParty.postAccessEndPage,
    addThirdParty.getTypeOfDataPage,
    addThirdParty.postTypeOfDataPage,
    addThirdParty.getGiveDataAccess,
    addThirdParty.postGiveDataAccess,
    addThirdParty.getDataAccessStart,
    addThirdParty.postDataAccessStart,
    addThirdParty.getDataAccessEnd,
    addThirdParty.postDataAccessEnd,
    addThirdParty.getCheckAnswersPage,
    addThirdParty.postCheckAnswersPage,
    addThirdParty.getConfirmAnswersPage
  )

  setup("manage-third-party", "Third Party J2: Manage third parties.").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin,
    loginDashboard.getDashboardPage,
    manageThirdParty.getManageThirdPartiesPage,
    manageThirdParty.getManageAsThirdPartyPage
  )

}
