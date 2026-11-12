# trade-reporting-extracts-performance-tests

## About
Performance test suite for the trade reporting extracts - using [performance-test-runner](https://github.com/hmrc/performance-test-runner) under the hood.

- [trade-reporting-extracts](https://github.com/hmrc/trade-reporting-extracts)
- [trade-reporting-extracts-frontend](https://github.com/hmrc/trade-reporting-extracts-frontend)
- [trade-reporting-extracts-stub](https://github.com/hmrc/trade-reporting-extracts-stub)

The performance tests can be run both locally and on Jenkins.
## Key Information
Do **NOT** run a full performance test against staging from your local machine.

Instead, [set up a performance test job in Jenkins](https://docs.tax.service.gov.uk/mdtp-handbook/documentation/mdtp-test-approach/performance-testing/performance-test-a-microservice/index.html#set-up-a-build-on-jenkins-to-run-against-the-staging-environment) and run the job from the [Performance Jenkins dashboard](https://performance.tools.staging.tax.service.gov.uk/job/Borders%20and%20Trade%20Live%20Services/job/TRE/job/trade-reporting-extracts-performance-tests/).

Only run smoke tests locally. Full performance tests can place a significant load on your machine and may cause performance issues.

## How to Run the Tests
## Pre-requisites

Run the services for trade reporting extracts services:

```bash
sm2 --start TRE_ALL
```

## Testing Locally
Follow the steps below to run the performance tests locally.

### How to Run the Smoke Tests
It might be useful to try the journey with one user to check that everything works fine before running the full performance test:

```bash
sbt -Dperftest.runSmokeTest=true -DrunLocal=true gatling:test
```

Run full performance test (locally) as follows:

```bash
sbt -DrunLocal=true gatling:test
```

Run smoke test (in the staging environment)  as follows:

```bash
sbt -Dperftest.runSmokeTest=true -DrunLocal=false gatling:test
```

## Post-Merge Testing
>**Important:** The full performance tests run all journeys at a configurable percentage of load, where 100% simulates the expected SA peak load. Parameters such as the number of parallel runs, ramp-up time, constant rate time, and ramp-down time can also be configured.
## Jenkins Builds
[trade-reporting-extracts-performance-tests](https://performance.tools.staging.tax.service.gov.uk/job/Borders%20and%20Trade%20Live%20Services/job/TRE/job/trade-reporting-extracts-performance-tests/)

### Logging

The default log level for all HTTP requests is set to `WARN`. Configure [logback.xml](src/test/resources/logback.xml) to update this if required.

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
