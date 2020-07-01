## Test Execution
$ `mvn exec:exec`

$ `mvn clean test -DtestSuite="{test suit name}` to run a specific test suit 
* example:` _mvn clean test -DtestSuite="testng_CUCUMBER_CROSS_PARALLEL.xml"`_

$ `mvn clean test -Dcucumber.filters.tags='--tags "@ios"'` to run tagged tests

* example: _`mvn clean test -Dcucumber.filters.tags='--tags "@ios"'`_


