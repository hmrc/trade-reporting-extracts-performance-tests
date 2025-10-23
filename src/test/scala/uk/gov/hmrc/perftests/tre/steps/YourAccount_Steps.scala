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
import uk.gov.hmrc.perftests.tre.helper.{invalidEORI, validEORI}
import uk.gov.hmrc.perftests.tre.requests.{LoginDashboard_Requests => loginDashboard, YourAccount_Requests => yourAccount}

trait YourAccount_Steps extends PerformanceTestRunner {

  setup("your-account-with-valid-eori", "Your Account J1: Your account details for valid EORI").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin(validEORI),
    loginDashboard.getDashboardPage,
    yourAccount.getYourAccountPage
  )

  setup("your-account-with-invalid-eori", "Your Account J2: Your account details for invalid EORI").withRequests(
    loginDashboard.getLoginPage,
    loginDashboard.postAuthWizLogin(invalidEORI),
    loginDashboard.getDashboardPage,
    yourAccount.getYourAccountPage
  )
}
