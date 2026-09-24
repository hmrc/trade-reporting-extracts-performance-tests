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
import uk.gov.hmrc.perftests.tre.helper._

object YourAccount_Requests {

  def getYourAccountPage: HttpRequestBuilder =
    http("[DET-1] GET: Navigate to your account page.")
      .get(s"$serviceURL/contact-details")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getAddNewEmailPage: HttpRequestBuilder =
    http("[DET-2] GET: Navigate to add new email page.")
      .get(s"$serviceURL/add-new-email")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postAddNewEmailPage: HttpRequestBuilder =
    http("[DET-2] POST: Posting new email.")
      .post(s"$serviceURL/add-new-email")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "example@email.com")
      .check(status.is(303))

  def getCheckNewEmailPage: HttpRequestBuilder =
    http("[DET-3] GET: Navigate to check email page.")
      .get(s"$serviceURL/check-email-address")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckNewEmailPage: HttpRequestBuilder =
    http("[DET-3] POST: Posting check of new email")
      .post(s"$serviceURL/check-email-address")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getConfirmNewEmailAddedPage: HttpRequestBuilder =
    http("[DET-4] GET: Navigate to new email submission confirmation page.")
      .get(s"$serviceURL/email-added?emailAddress=example%40email.com")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getCheckRemoveEmailPage: HttpRequestBuilder =
    http("[DET-5] GET: Navigate to remove email page.")
      .get(s"$serviceURL/email-removed?emailAddress=example%40email.com")
      .header("Cookie", authCookie)
      .check(status.is(200))
      .check(saveCsrfToken)

  def postCheckRemoveEmailPage: HttpRequestBuilder =
    http("[DET-5] POST: Post removal of email")
      .post(s"$serviceURL/email-removed?emailAddress=example%40email.com")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getConfirmEmailRemovedPage: HttpRequestBuilder =
    http("[DET-6] GET: Navigate to email removal confirmation page.")
      .get(s"$serviceURL/email-removed-confirmation?emailAddress=example%40email.com")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getEmailDisableNotifPage: HttpRequestBuilder =
    http("[DET-7] GET: Navigate to disable email notifications page.")
      .get(s"$serviceURL/disable-email-notifications")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def postEmailDisableNotifPage: HttpRequestBuilder =
    http("[DET-8] POST: Navigate to disable email notifications page.")
      .post(s"$serviceURL/disable-email-notifications")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getEmailDisableNotifConfirmPage: HttpRequestBuilder =
    http("[DET-9] GET: Navigate to disable email notifications confirmation page.")
      .get(s"$serviceURL/email-notifications-disabled")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def getEmailEnableNotifPage: HttpRequestBuilder =
    http("[DET-10] GET: Navigate to enable email notifications page.")
      .get(s"$serviceURL/enable-email-notifications")
      .header("Cookie", authCookie)
      .check(status.is(200))

  def postEmailEnableNotifPage: HttpRequestBuilder =
    http("[DET-11] POST: Navigate to enable email notifications page.")
      .post(s"$serviceURL/enable-email-notifications")
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "true")
      .check(status.is(303))

  def getEmailEnableNotifConfirmPage: HttpRequestBuilder =
    http("[DET-12] GET: Navigate to enable email notifications confirmation page.")
      .get(s"$serviceURL/email-notifications-enabled")
      .header("Cookie", authCookie)
      .check(status.is(200))
}
