🧪 Automation Testing Framework for bstackdemo.com
📌 Project Overview

This project is an automation testing framework developed using Java and Selenium WebDriver to test the core functionalities of the bstackdemo.com e-commerce web application.
The framework follows the Page Object Model (POM) design pattern to ensure maintainability, reusability, and scalability.

🌐 Application Under Test (AUT)

Website: https://bstackdemo.com/

Domain: E-Commerce

Description:
bstackdemo.com is a demo e-commerce application provided by BrowserStack.
It includes features such as login, product listing, filtering, add to cart, and checkout.

🎯 Project Objectives

Automate critical user workflows of an e-commerce application

Implement a structured automation framework using POM

Execute tests using TestNG

Generate execution reports

Use Git/GitHub for version control

🛠️ Tools & Technologies

Java – Programming language

Selenium WebDriver – Browser automation

TestNG – Test execution and reporting

Maven – Build and dependency management

ExtentReports – HTML test reports

Git & GitHub – Version control

🏗️ Framework Architecture

Design Pattern: Page Object Model (POM)

Key Components:

BaseTest.java – WebDriver initialization and setup

Page Classes

LoginPage

ProductPage

CartPage

CheckoutPage

Utilities

ConfigReader

WebDriverFactory

WaitUtils

Test Classes

LoginTest

AddToCartTest

CheckoutTest

TestNG.xml – Test suite configuration

Reports – ExtentReports integration

📂 Project Structure
src
├── main
│   └── java
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── ProductPage.java
│       │   ├── CartPage.java
│       │   └── CheckoutPage.java
│       └── utils
│           ├── ConfigReader.java
│           ├── WebDriverFactory.java
│           └── WaitUtils.java
├── test
│   └── java
│       └── tests
│           ├── LoginTest.java
│           ├── AddToCartTest.java
│           └── CheckoutTest.java
└── testng.xml

✅ Test Scenarios Covered
🔐 Login Tests

TC_001: Login with valid credentials

TC_002: Login with invalid credentials

TC_003: Login with empty username and password

🛒 Cart Tests

TC_004: Add single item to cart

TC_005: Add multiple items and verify cart count

TC_006: Remove item from cart

💳 Checkout Tests

TC_007: Place order with valid details

TC_008: Checkout without adding items (negative test)

▶️ Test Execution
Run using Maven:
mvn clean test

Run using TestNG:

Execute testng.xml from IDE

Or via Maven Surefire plugin

📊 Reporting

ExtentReports generates detailed HTML reports

Default TestNG reports are available under the test-output folder

🔄 Version Control

This project uses Git and GitHub for version control:

Code changes are tracked using commits

Repository hosted on GitHub
