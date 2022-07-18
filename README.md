## Musala Soft Automation Tasks

The project is built using Selenium WebDriver in Java. It supports cross browsing (Chrome and Firefox) , parallel execution, data driven testing from an Excel file and Allure Report

The used Tools : Selenium , Maven, TestNG, Apache POI, Allure Report

## Packages

**factory :** includes initialization of Webdriver

**pages:** includes all the webpage elements

**testcases**: includes the tests classes

**utils:** includes Property Manager

**Data :** includes ExcelReader , UserDate.xlsx , Pdf file

**base :** includes BasePage , BaseTest

**config :** includes The properties file wich contain the Base URL

Parallel Execution
is possible using TestNG XML file and it is also possible to set the number of threads.

## Usage

```maven
#excute test cases using CHROME"the default"

mvn clean test
#or
mvn clean test -Dbrowser=CHROME

#execute test cases using Firefox
mvn clean test -Dbrowser=FIREFOX

#to open the results report
allure serve allure-results

# returns a city'cityname'
selectLocationBy("Anywhere")
#or
selectLocationBy("Sofia")

# select a position'Automation QA Engineer'
choosePosition("Automation QA Engineer")

```


## Allure Report
I use the Allure Report and I add description for each test method/class used and for the test execution steps in the reports.
also you can check screenshot for each method inside Tear down Step

and this is some screenshots from the Allure report .
![](target/screenshots/allureresult1.png)

![](target/screenshots/allureresult2.png)

![](target/screenshots/allureresult3.png)




## License
Ibrahim Mohamed Shafik

