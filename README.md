# ProiectFinalITSchool

Final project for ITSchool - Automated Testing Framework developed with Java, Selenium WebDriver and TestNG.

## Project Overview

This project contains automated UI tests created for:

https://webdriveruniversity.com/

The framework was built using Page Object Model and includes Data Driven Testing, logging, reporting, database validation, browser abstraction, parallel execution and CI/CD integration.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model
- Log4j2
- ChainTest Reports
- MySQL
- Git
- GitHub
- GitHub Actions

## Project Structure

Main packages:

- `Pages` - Page Object classes
- `Tests` - automated test classes
- `HelperMethods` - reusable helper methods
- `ObjectData` - test data objects
- `SharedData` - browser setup and common test configuration
- `Logger` - logging utilities
- `XmlDataLoader` - XML data loader
- `DataBase` - database connection and SQL queries
- `Suites` - TestNG suite files

## Automated Test Scenarios

The project contains automated tests for:

- Contact Us
- Login
- To Do List
- Dropdowns
- Checkboxes
- Radio Buttons
- Drag and Drop
- Double Click
- Hover
- Click and Hold

The project includes both positive and negative test scenarios.

## Page Object Model

The framework uses the Page Object Model design pattern.

Each tested page has its own class containing:

- WebElements
- page-specific actions
- validation methods

Examples:

- `HomePage`
- `LoginPage`
- `ContactUsPage`
- `ToDoListPage`
- `DropdownCheckboxRadioPage`
- `ActionsPage`

Common functionality is reused through `CommonPage`.

## OOP Principles

The project demonstrates the main Object-Oriented Programming principles.

### Inheritance

Page classes inherit common functionality from `CommonPage`.

Test classes use shared setup and teardown functionality from `TestBasePage`.

### Encapsulation

Page elements are kept private and are accessed through public methods.

Example:

```java
private WebElement findTodoByName(String taskName)
```

### Abstraction

Browser creation is abstracted through:

- `iBrowserService`
- `BrowserFactory`
- `ChromeServiceBrowser`
- `EdgeServiceBrowser`

Tests do not need to know the internal browser creation logic.

### Polymorphism

Different browser implementations can be used through the same browser abstraction.

### Method Overloading

The project also contains method overloading in `ElementsMethods`.

Example:

```java
enterText(WebElement element, String text)

enterText(WebElement element, String text, boolean clearBeforeTyping)
```

The overloaded method also demonstrates the use of `if / else`.

## Helper Methods

Reusable helper classes are used for common actions:

- `ElementsMethods`
- `WindowMethods`
- `AlertMethods`

These reduce code duplication and improve maintainability.

## Data Driven Testing

Data Driven Testing is implemented using XML files and ObjectData classes.

Test data files:

- `ContactUsData.xml`
- `LoginData.xml`
- `ToDoData.xml`

The XML data is loaded using a reusable generic `XmlDataLoader`.

Data Driven Testing is used in multiple test classes, including:

- Contact Us
- Login
- To Do List

## Waits

The framework uses explicit waits through:

```java
WebDriverWait
ExpectedConditions
```

Waits are used for:

- element visibility
- clickable elements
- alerts
- new browser tabs
- element state changes

## Logging

Logging is implemented using Log4j2.

`LoggerUtility` is used to log:

- test execution start
- test execution end
- browser actions
- page actions
- validation steps
- errors

## Reporting

ChainTest is used for reporting.

Reports are generated in:

```text
target/chaintest/
```

The main report file is:

```text
target/chaintest/Index.html
```

Screenshots are captured automatically when a test fails.

## Intentional Failure Test

The project contains an intentional failure test:

```text
ReportFailureTest
```

This test is used to demonstrate:

- failure reporting
- error logging
- screenshot capture

It is excluded from the CI suite.

## Test Suites

### CI Regression Suite

```text
Suites/testng.xml
```

This suite contains the real automated regression tests.

Expected result:

```text
22 tests passed
0 failed
```

### Full Regression Suite

```text
Suites/fullSuite.xml
```

This suite includes the functional tests and the intentional failure test.

It also demonstrates parallel test execution.

Configuration:

```xml
parallel="tests"
thread-count="3"
```

Expected result:

```text
23 tests total
22 passed
1 intentional failure
```

### Report Demo Suite

```text
Suites/reportDemo.xml
```

This suite contains only the intentional failure test and is used for reporting demonstration.

## Database Validation

The project includes MySQL integration.

Database classes:

- `DBConnection`
- `CommonTable`
- `ContactUsTable`

The Contact Us test stores and validates test data in a local MySQL database.

The local database is used for test data validation and is not the backend database of WebDriverUniversity.

Database credentials are provided through environment variables:

```text
DB_URL
DB_USER
DB_PASSWORD
```

Sensitive credentials are not stored directly in the source code.

## Browser Support

The framework supports:

- Google Chrome
- Microsoft Edge

Browser selection is implemented through browser abstraction and `BrowserFactory`.

The default browser is Chrome.

Example Maven command:

```bash
mvn clean test -Dbrowser=chrome
```

## Parallel Execution

Parallel execution is configured in:

```text
Suites/fullSuite.xml
```

using:

```xml
parallel="tests"
thread-count="3"
```

This allows multiple TestNG test groups to run in parallel.

## CI/CD

GitHub Actions is configured in:

```text
.github/workflows/ci.yml
```

The CI pipeline automatically:

1. Checks out the repository
2. Sets up Java
3. Starts a MySQL service
4. Creates the required database table
5. Runs the automated TestNG regression suite
6. Generates the ChainTest report
7. Uploads the report as a GitHub Actions artifact

The workflow runs automatically on:

- push to `main`
- pull request to `main`

## Running the Tests

Run the default suite:

```bash
mvn clean test
```

Run with Chrome:

```bash
mvn clean test -Dbrowser=chrome
```

Run the full regression suite:

```bash
mvn clean test -DsuiteXmlFile=Suites/fullSuite.xml
```

For local database validation, `DB_PASSWORD` must be configured as an environment variable.

## Current Test Results

CI Regression Suite:

```text
22 tests passed
0 failed
```

Full Regression Suite:

```text
23 tests total
22 passed
1 intentional failure
```

## Main Concepts Demonstrated

The project demonstrates:

- Page Object Model
- Object-Oriented Programming
- Inheritance
- Abstraction
- Encapsulation
- Polymorphism
- Method Overloading
- Data Driven Testing
- Positive Testing
- Negative Testing
- Reusable Helper Methods
- Explicit Waits
- Logging
- Reporting
- Screenshot Capture
- MySQL Integration
- Browser Abstraction
- Parallel Test Execution
- Git and GitHub
- CI/CD with GitHub Actions

## Repository

GitHub repository:

https://github.com/IonutBej/ProiectFinalITSchool