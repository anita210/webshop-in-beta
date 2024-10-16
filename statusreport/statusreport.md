# Status Report: Webshop Beta Testing

### Project: Webshop in Beta
### Date: 2024.09.19.
### Confidentiality Level: 91 %

## Overview
The testing of the [Swag Labs](https://www.saucedemo.com/) webshop (beta version) has been completed successfully, with a total of 21 test cases executed. Out of these, 20 passed and 1 failed, resulting in an overall success rate of 95.23%. The tests covered critical functionalities, including product handling, user login, and checkout processes.

## Key Results

### Total Tests Executed: 21
- **Passed:** 20
- **Failed:** 1

### Detailed Breakdown:

1. **Product Handling Tests (Total: 7)**
    - **Passed:** 7
    - **Tests included:**
        - Adding a single item to the cart from the product details page
        - Adding multiple items to the cart from both the shop and product details pages
        - Testing cart behavior after adding and removing items
        - Checking all products’ individual pages with detailed information

2. **Login Page Tests (Total: 6)**
    - **Passed:** 6
    - **Tests included:**
        - Successful logins with various user types, including standard, locked-out, problem, and error users
        - Performance-related tests with specific user conditions

3. **Checkout Tests (Total: 3)**
    - **Passed:** 2
    - **Failed:** 1
    - **Failed Test: `checkoutWithEmptyCartTest`**
        - **Reason:** The test expected the checkout process to fail when the cart was empty, but the checkout was still completed successfully.
        - **Assertion failed:** "Checkout Complete - process should not be successful, because the cart is empty!"
4. **Logout Tests (Total: 1)**
- **Passed:** 1
- **Tests included:**
   - Successful login with standard_user and logout process
### 5. **Ordered List Tests (Total: 4)**
- **Passed:** 4
- **Tests included:**
   - Sorting items by **Price (High to Low)** and verifying the first item listed is correct (`Sauce Labs Fleece Jacket`)
   - Sorting items by **Price (Low to High)** and verifying the first item listed is correct (`Sauce Labs Onesie`)
   - Sorting items by **Name (A to Z)** and confirming the first item is correct (`Sauce Labs Backpack`)
   - Sorting items by **Name (Z to A)** and verifying the first item listed is correct (`Test.allTheThings() T-Shirt (Red)`)
All four tests passed, confirming the sorting functionality in the shop page works as expected for both price and alphabetical order.
   
## Conclusion
The testing process was largely successful, with a 93.75% pass rate. However, the failed test in the checkout process with an empty cart highlights a critical bug that needs to be addressed. Further investigation is recommended to fix this issue before moving forward with the production release.


