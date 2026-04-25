# 🛒 Swag Labs — End-to-End Test Automation

> Automation portfolio project using **Katalon Studio** with **Page Object Model (POM)** architecture, targeting the [Sauce Demo](https://www.saucedemo.com) web application.

---

## 📌 Project Overview

This project demonstrates a structured, maintainable test automation suite for an e-commerce web application. It covers authentication flows, inventory management, cart behavior, checkout processes, and full end-to-end user journeys — all built with real-world QA practices in mind.

| Item          | Detail                                                 |
| ------------- | ------------------------------------------------------ |
| **Tool**      | Katalon Studio                                         |
| **AUT**       | [https://www.saucedemo.com](https://www.saucedemo.com) |
| **Pattern**   | Page Object Model (POM)                                |
| **Test Data** | Data-driven via Data Files                             |
| **Scope**     | Functional, Regression, Smoke, E2E                     |

---

## 🗂️ Project Structure

```
📦 Project Root
├── 📁 Test Cases
│   ├── 📁 Common/              # Reusable modular test cases
│   └── 📁 E2E/                 # Full end-to-end user journey scenarios
│
├── 📁 Test Suites
│   ├── 📁 Regression/
│   │   ├── TS_Reg_Authentication
│   │   └── TS_Reg_InventoryManagement
│   └── 📁 Smoke/
│       └── TS_Smoke_CriticalFlow
│
├── 📁 Object Repository/       # UI elements organized by page/component
│   ├── Component_Navbar
│   ├── Component_Sidebar
│   ├── Page_Login
│   ├── Page_Inventory
│   ├── Page_Inventory_Item
│   ├── Page_Cart
│   ├── Page_Checkout_Step_One
│   ├── Page_Checkout_Step_Two
│   └── Page_Checkout_Complete
│
└── 📁 Data Files/
    └── DF_User_Accounts        # Test accounts & credentials
```

---

## 🧪 Test Cases

### Common (Reusable Building Blocks)

| Test Case                      | Description                                     |
| ------------------------------ | ----------------------------------------------- |
| `TC_Auth_Login`                | Login with valid credentials                    |
| `TC_Auth_Logout`               | Logout from the application                     |
| `TC_Cart_AddDirect`            | Add item to cart from inventory list            |
| `TC_Cart_AddViaDetail`         | Add item to cart via product detail page        |
| `TC_Cart_RemoveDirect`         | Remove item from cart via inventory list        |
| `TC_Cart_RemoveViaDetail`      | Remove item via product detail page             |
| `TC_Checkout`                  | Complete the checkout flow                      |
| `TC_Checkout_Information`      | Fill in checkout information form               |
| `TC_Checkout_VerifyPrice`      | Validate item price & total on checkout summary |
| `TC_Inventory_DisplayProducts` | Verify products are displayed correctly         |
| `TC_Nav_AllItems`              | Navigate to all items via sidebar               |
| `TC_Nav_DetailViaImage`        | Navigate to product detail by clicking image    |
| `TC_Nav_DetailViaTitle`        | Navigate to product detail by clicking title    |
| `TC_Sort_NameAsc`              | Sort products by Name (A → Z)                   |
| `TC_Sort_NameDesc`             | Sort products by Name (Z → A)                   |
| `TC_Sort_PriceHighLow`         | Sort products by Price (High → Low)             |
| `TC_Sort_PriceLowHigh`         | Sort products by Price (Low → High)             |
| `TC_Util_ResetAppState`        | Reset application state via sidebar menu        |

---

## 🔁 End-to-End Scenarios

### E2E_01 — The Standard Shopper _(Happy Path)_

> Simulates a typical user completing a purchase without any detours.

**Flow:**
Login → Browse Inventory → Add Item to Cart → Checkout → Fill Info → Verify Price → Complete Purchase → Logout

---

### E2E_02 — The Price-Conscious Buyer _(Filtering & Multi-Purchase)_

> Simulates a budget-aware user who sorts by price, adds multiple items, and checks out.

**Flow:**
Login → Sort by Price (Low → High) → Add Multiple Items → Review Cart → Checkout → Verify Total → Complete Purchase

---

### E2E_03 — The Detailed Explorer _(Product Research Before Checkout)_

> Simulates a user who reads product details before deciding to buy.

**Flow:**
Login → Click Product Image → Read Detail Page → Add to Cart from Detail → Navigate Back → Checkout

---

### E2E_04 — The Indecisive User _(State Management & Reset)_

> Simulates a user who changes their mind, resets the app, and logs out without completing a purchase.

**Flow:**
Login → Add Items → Remove Some Items → Reset App State → Verify Cart is Empty → Logout

---

## 🔬 Test Suites

### 🔵 Regression

#### `TS_Reg_Authentication`

Validates login behavior across multiple account types and credential combinations.

| Account           | Expected Result               |
| ----------------- | ----------------------------- |
| `standard_user`   | ✅ Login successful           |
| `locked_out_user` | ❌ Error: Account locked      |
| `wrong_username`  | ❌ Error: Invalid credentials |
| `wrong_password`  | ❌ Error: Invalid credentials |

#### `TS_Reg_InventoryManagement`

Validates all sorting options on the inventory page.

| Sort Option        | Verified |
| ------------------ | -------- |
| Name (A → Z)       | ✅       |
| Name (Z → A)       | ✅       |
| Price (Low → High) | ✅       |
| Price (High → Low) | ✅       |

---

### 🟢 Smoke

#### `TS_Smoke_CriticalFlow`

A fast, lightweight suite that verifies the core application flow is functional — ideal for post-deployment checks.

---

## 🧱 Architecture

This project follows the **Page Object Model (POM)** pattern:

- **Object Repository** is organized per page and component, keeping selectors centralized and maintainable.
- **Test Cases** are designed as reusable building blocks — small, focused, and composable into larger E2E flows.
- **Data Files** externalize test data (user credentials) to keep test logic clean and data-driven.
- **Test Suites** group related test cases for targeted execution (regression, smoke, or full E2E).

---

## 🚀 How to Run

1. Open the project in **Katalon Studio**
2. Select a Test Suite from the `Test Suites` folder
3. Choose your execution profile (default credentials are in `DF_User_Accounts`)
4. Click **Run** ▶️

---

## 👤 Author

Built as part of a QA automation portfolio.
Application under test: [Swag Labs by Sauce Labs](https://www.saucedemo.com)
