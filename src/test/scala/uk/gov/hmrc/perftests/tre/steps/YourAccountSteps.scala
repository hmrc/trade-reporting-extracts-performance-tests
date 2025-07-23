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
// YourDetailsRequests._

trait YourAccount extends PerformanceTestRunner {

  def journeyNameHere(id: String, description: String): JourneyPart = setup(id, description).withRequests(
    getLoginPage,
    postLoginPage(anOrganisationUserWithKnownEnrolment),
    getDashboardPage
    // Open link...
    // Do more stuff... 
  )
}