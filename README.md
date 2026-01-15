# 🍊 OrangeHRM Data-Driven Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.x-green) ![Cucumber](https://img.shields.io/badge/Cucumber-BDD-blue) ![Apache POI](https://img.shields.io/badge/Data-Apache%20POI-yellow)

## 📄 Overview
This repository hosts a **Hybrid Test Automation Framework** designed for the **OrangeHRM** HR Management System. 

The core highlight of this project is its **Data-Driven Testing** capability. It leverages **Apache POI** to read complex test data (User Roles, Employee Names, Passwords) from Excel spreadsheets, allowing for "Mass User Creation" scenarios without hardcoding data in Feature files.

## 🚀 Key Features
* **Data-Driven Engine:** Custom `ExcelUtils` class reads `.xlsx` files and converts rows into a `List<Map<String, String>>`, enabling dynamic test iteration.
* **Robust Synchronization:** Implemented custom **"Smart Waits"** in `TestBase` that automatically handle `StaleElementReferenceException` and dynamic AJAX loading.
* **Page Object Model (POM):** Strict separation of Page Objects (Locators) and Test Scripts (Steps) using Selenium's `PageFactory`.
* **BDD Architecture:** Business logic is written in plain English using **Cucumber Gherkin**, bridging the gap between QA and stakeholders.
* **Failure Analysis:** Automated screenshot capture on scenario failure via `ApplicationHooks`.

## 🛠️ Tech Stack
| Component | Tool / Library |
| :--- | :--- |
| **Language** | Java (JDK 22) |
| **Web Automation** | Selenium WebDriver |
| **BDD Framework** | Cucumber (Gherkin) |
| **Data Handling** | Apache POI (Excel) |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |

## 🧪 The "Data-Driven" Logic
This framework replaces hardcoded Cucumber Data Tables with external Excel files.

**1. The Feature File:**
```gherkin
When I add users from excel "UserData.xlsx" sheet "Sheet1"
