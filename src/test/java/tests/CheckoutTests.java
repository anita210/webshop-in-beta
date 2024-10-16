package tests;

import POM.checkoutInfoPage;
import POM.loginPage;
import POM.shopPage;
import POM.yourCartPage;
import POM.checkoutOverviewPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.io.IOException;

public class CheckoutTests {
    private String username;
    private String passwordForAll;
    private String firstName;
    private String lastName;
    private String zipCode;
    private WebDriver driver;
    private WebDriverWait wait;
    private loginPage _loginPage;
    private shopPage _shopPage;
    private yourCartPage _yourcartPage;
    private checkoutInfoPage _checkoutInfoPage;
    private checkoutOverviewPage _checkoutOverviewPage;
    private WebElement backHomeButton; 
      
    @BeforeEach
    public void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        
        _loginPage = new loginPage(driver, wait);
        _shopPage = new shopPage(driver, wait);
        _yourcartPage = new yourCartPage(driver, wait);
        _checkoutInfoPage = new checkoutInfoPage(driver, wait);
        _checkoutOverviewPage = new checkoutOverviewPage(driver, wait);
        
        username = System.getenv("STANDARD_USER");
        passwordForAll = System.getenv("PW_FOR_ALL");
        firstName = System.getenv("FIRST_NAME");
        lastName = System.getenv("LAST_NAME");
        zipCode = System.getenv("ZIP_CODE");

        driver.get("http://www.saucedemo.com/");
        _loginPage.loginProcess(username, passwordForAll);
    }
    
    @Test
    public void checkoutWithEmptyCartTest() throws IOException {

        _shopPage.clickShoppingCartButton();
        _yourcartPage.goToCheckout();
        _checkoutInfoPage.fillForm(firstName, lastName, zipCode);
        _checkoutInfoPage.submitFormContinue();
        _checkoutOverviewPage.clickFinishButton();
        
        backHomeButton = driver.findElement(By.id("back-to-products"));

        Assertions.assertFalse(backHomeButton.isDisplayed(), "Checkout Complete - process should not be successful, because cart is empty!");
    }

    @Test
    public void checkoutWithOneItemInCart() throws IOException {
       _shopPage.getAddToCartButtonByIndex(1);
        _shopPage.clickShoppingCartButton();
        _yourcartPage.goToCheckout();
        _checkoutInfoPage.fillForm(firstName, lastName, zipCode);
        _checkoutInfoPage.submitFormContinue();
        _checkoutOverviewPage.clickFinishButton();

        backHomeButton = driver.findElement(By.id("back-to-products"));

        Assertions.assertTrue(backHomeButton.isDisplayed(), "Checkout Complete - process should be successful with valid data and one item!");
    }
    @Test
    public void checkoutWithTwoItemInCart() throws IOException {
        _shopPage.getAddToCartButtonByIndex(1);
        _shopPage.getAddToCartButtonByIndex(2);
        _shopPage.clickShoppingCartButton();
        _yourcartPage.goToCheckout();
        _checkoutInfoPage.fillForm(firstName, lastName, zipCode);
        _checkoutInfoPage.submitFormContinue();
        _checkoutOverviewPage.clickFinishButton();

        backHomeButton = driver.findElement(By.id("back-to-products"));

        Assertions.assertTrue(backHomeButton.isDisplayed(), "Checkout Complete - process should be successful with valid data and two items!");
    }
   
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
