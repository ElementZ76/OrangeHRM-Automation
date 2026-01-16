# 🍊 OrangeHRM Data-Driven Automation Framework

![Java](https://img.shields.io/badge/Java-22-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.x-green) ![Cucumber](https://img.shields.io/badge/Cucumber-BDD-blue) ![Jackson](https://img.shields.io/badge/Data-JSON%20(Jackson)-lightgrey)

## 📄 Overview
This repository hosts a **Hybrid Test Automation Framework** designed for the **OrangeHRM** HR Management System.

The framework has been re-architected to use **JSON-based Data Driven Testing**. It leverages the **Jackson** library to deserialize complex test data (User Roles, Employee Profiles) directly into Java POJOs, ensuring type safety and maintainability. It is designed to handle dynamic enterprise UI elements, including asynchronous loading spinners and disappearing toast messages.

## 🚀 Key Features
* **JSON Data Pipeline:** Replaced legacy Excel handling with `JsonUtils`. Reads `.json` files and maps them to strictly typed Java Objects (`UserData`, `EmployeeData`).
* **Robust Synchronization:** Implemented a **"Smart Wait"** strategy in `TestBase`.
    * `waitForVisibility`: Handles standard page loads.
    * `waitForInvisibility`: Specifically handles blocking UI elements like the **`oxd-form-loader`** spinner to prevent `ElementClickInterceptedException`.
* **Page Object Model (POM):** Strict separation of Page Objects (Locators) and Test Scripts (Steps) using Selenium's `PageFactory`.
* **BDD Architecture:** Business logic is written in plain English using **Cucumber Gherkin**, bridging the gap between QA and stakeholders.
* **Failure Analysis:** Automated screenshot capture on scenario failure via `ApplicationHooks`.

## 🛠️ Tech Stack
| Component | Tool / Library |
| :--- | :--- |
| **Language** | Java (JDK 22) |
| **Web Automation** | Selenium WebDriver |
| **BDD Framework** | Cucumber (Gherkin) |
| **Data Serialization** | Jackson Databind (JSON) |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |

## 🧪 The "Data-Driven" Logic (JSON)
The framework iterates through JSON arrays to execute bulk scenarios.

**1. The Feature File:**
```gherkin
@JsonDriven
Scenario: Bulk create employees from JSON
  When I add new employees from json file "employees.json"

```

**2. The Data Source (`employees.json`):**

```json
[
  {
    "firstName": "Bruce",
    "lastName": "Wayne",
    "photoFile": "profile.jpg"
  },
  {
    "firstName": "Clark",
    "lastName": "Kent",
    "photoFile": "profile.jpg"
  }
]

```

**3. The Execution:**
The `JsonUtils` class deserializes this data into a `List<EmployeeData>`, allowing the test script to interact with strongly-typed objects (e.g., `employee.getFirstName()`) rather than loosely typed Maps.

## ⚙️ How to Run Locally

### Prerequisites

* **Java JDK 11** or higher installed.
* **Maven** installed and configured in system variables.

### Steps

1. **Clone the repository:**
```bash
git clone [https://github.com/ElementZ76/OrangeHRM-Automation.git](https://github.com/ElementZ76/OrangeHRM-Automation.git)

```


2. **Navigate to the project directory:**
```bash
cd OrangeHRM-Automation

```


3. **Run the tests using Maven:**
```bash
mvn clean test

```


*This will execute the default test suite configured in `testng.xml` (or the Runner class).*

## 👤 Author

**Praveen PR**
*SDET Aspirant*

```

```
