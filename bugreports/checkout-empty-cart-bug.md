# Bug Report: Checkout Successful with Empty Cart

## Summary:
The checkout process completes successfully even when the shopping cart is empty. The system should prevent the user from completing the checkout if no items are in the cart, and the alert message is missing.

## Steps to Reproduce:
1. Navigate to the SauceDemo website.
2. Log in with valid credentials.
3. Go to the cart page (without adding any items to the cart).
4. Proceed to checkout.
5. Fill in the required form fields (first name, last name, zip code).
6. Submit the form and complete the checkout process.

## Expected Result:
The checkout process should not be successful if the cart is empty. The user should see an error message indicating that they need to add items to the cart before proceeding.

## Actual Result:
The checkout process completes successfully, and the messages "Thank you for your order!" and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" are displayed, along with the "Back Home" button, which implies the checkout was processed, even though the cart was empty.

## Error Message:
org.opentest4j.AssertionFailedError: Checkout Complete - process should not be successful, because cart is empty! ==>
Expected :false
Actual   :true


## Environment:
- **Browser:** Chrome (latest version)
- **Selenium Version:** 4.24.0
- **JUnit Version:** 5.10.3
- **OS:** Windows 10
- **Java Version:** Corretto 21.0.4
- **User:** standard_user

## Attachments: Screenshots
![Screenshot 1](./images/checkout-empty-cart-bug_1.png)
![Screenshot 2](./images/checkout-empty-cart-bug_2.png)

## Priority:
**High**  
This bug allows users to complete purchases without any items in the cart, which can lead to incorrect orders, system abuse or bad user experience.