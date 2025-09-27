# Justlife QA Automation Case Study


This repository contains a test automation framework built to test the booking workflow on the Justlife website. The framework is developed using Java, Selenium, Cucumber, and TestNG, following the Page Object Model (POM) and Behavior-Driven Development (BDD) principles.

## Features

*   **End-to-End Test Scenario**: Automates a complete user journey from logging in to creating a booking and verifying it in the booking history.
*   **Behavior-Driven Development (BDD)**: Utilizes Cucumber with Gherkin syntax (`.feature` files) to create readable and maintainable test scenarios.
*   **Page Object Model (POM)**: Implements the POM design pattern to separate UI elements and business logic, enhancing code reusability and maintainability.
*   **Reporting**: Generates a JSON report of the test execution results.

## Test Scenario Covered

The primary test scenario automated in this project is defined in `Booking.feature` and covers the following steps:

1.  **Login**: Opens the Justlife checkout page and logs in using a phone number and OTP.
2.  **Service Configuration**:
    *   Selects the duration for the cleaning service.
    *   Specifies the number of cleaners required.
    *   Opts to include cleaning materials.
3.  **Booking Funnel**:
    *   Navigates through the add-on and date/time selection pages.
    *   Verifies that no extra add-ons are pre-selected.
    *   Changes the booking frequency to "One Time".
    *   Selects an available date and time slot.
4.  **Payment**:
    *   Proceeds to the payment step.
    *   Opens the payment method selection modal.
    *   Checks for the availability of the "Cash" payment option and logs the findings.
5.  **Completion & Verification**:
    *   Attempts to complete the booking and logs the resulting notification message.
    *   Navigates to the user's booking history page.
    *   Opens the most recent booking from the "Past" tab and prints its details for verification.

## Technologies Used

*   **Java**: Core programming language.
*   **Selenium WebDriver**: For browser automation and UI interactions.
*   **Cucumber**: For implementing BDD and writing tests in Gherkin.
*   **TestNG**: As the test runner for Cucumber scenarios.
*   **Maven**: For project build automation and dependency management.
*   **WebDriverManager**: To automate the management of browser drivers.

## Project Structure

The project follows a standard Maven structure for test automation:

```
├── pom.xml                   # Manages project dependencies and build configuration
└── src
    └── test
        ├── java
        │   ├── hooks         # WebDriver setup and teardown hooks for scenarios
        │   ├── pages         # Page Object classes for each page of the application
        │   ├── runners       # TestNG test runner for Cucumber
        │   └── stepDefinitions # Step definition classes linking Gherkin to Java code
        └── resources
            ├── features      # Gherkin .feature files describing test scenarios
            └── testResults   # Output directory for test reports
```

## Setup and Execution

### Prerequisites

*   **Java Development Kit (JDK)** 11 or higher.
*   **Apache Maven**.
*   **Google Chrome** browser installed.

### Steps to Run Tests

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/dhirajshelke247/dhiraj_justlife_qa_code_case.git
    cd dhiraj_justlife_qa_code_case
    ```

2.  **Run the tests:**
    Execute the following Maven command from the root directory of the project. This command will compile the code, download dependencies, and run the tests defined in the `TestRunner` class.
    ```sh
    mvn clean test
    ```

### Test Results

After the test execution is complete, a JSON report is generated at the following location:
`src/test/resources/testResults/result.json`
