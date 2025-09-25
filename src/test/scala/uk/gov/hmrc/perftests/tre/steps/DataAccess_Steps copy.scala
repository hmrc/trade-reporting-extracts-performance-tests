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
import uk.gov.hmrc.perftests.tre.requests.{AddThirdParty_Requests => addThirdParty, LoginDashboard_Requests => loginDashboard}

trait DataAccess_Steps extends PerformanceTestRunner {

  private val randEORI = generateRandEORI()

  setup("log-in-and-add-third-party", "DataAccess J1: Add a third party.").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin(randEORI),
    loginDashboard.getDashboardPage,
    addThirdParty.getAddThirdPartyStartPage,
    addThirdParty.getImporterOrExporterPage,
    addThirdParty.postImporterOrExporterPage,
    addThirdParty.getEORINumberPage
  )
}
