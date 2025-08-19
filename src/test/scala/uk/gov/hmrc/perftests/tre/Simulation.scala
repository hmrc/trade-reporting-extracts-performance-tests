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

package uk.gov.hmrc.perftests.tre

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.tre.steps._

class Simulation extends PerformanceTestRunner with ReportSteps with YourAccount {

  // Reports
  LoginAndRequestNewReport(
    id = "login-and-request-new-report",
    description = "Journey 1: User requests a new report."
  )
  LoginAndCheckAvailableReports(
    id = "login-and-check-available-reports",
    description = "Journey 2: User checks their requested reports."
  )
  LoginAndCheckDownloadableReports(
    id = "login-and-check-downloadable-reports",
    description = "Journey 3: User checks reports available for download."
  )

  // Account
  // journeyNameHere()...

  runSimulation()
}
