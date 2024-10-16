package tests;

import POM.loginPage;
import POM.shopPage;
import POM.yourCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductHandlingTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private loginPage loginPage;
    private shopPage shopPage;
    private yourCartPage yourCartPage;


    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        loginPage = new loginPage(driver, wait);
        
        shopPage = new shopPage(driver, wait);
        
        yourCartPage = new yourCartPage(driver, wait);
        
        String u = System.getenv("STANDARD_USER");
        
        String pw = System.getenv("PW_FOR_ALL");
        
        loginPage.loginProcess(u, pw);

    }
    
    @Test
    public void testCheckAllProductsOwnPageWithDetails() {

        int size = shopPage.getAllInventoryItems().size();

        for (int i = 1; i <= size; i++) {

            String itemName = shopPage.getItemNameByIndex(i);

            shopPage.viewItemDetailsByIndex(i);

            Assertions.assertTrue(itemName.equals(shopPage.getItemNameOnDetailsPage()));
            
            Assertions.assertTrue(shopPage.getItemDescriptionOnDetailsPage().isDisplayed());

            shopPage.clickBackToProductsButton();

        }

    }
    
    @Test 
    public void testPutOneItemIntoCartFromShopPage(){
        
        shopPage.addItemToCartByIndex(1);
        
        Assertions.assertTrue("1".equals(shopPage.getNumberOfItemsInCart()));
    }

    @Test
    public void testPutMultipleItemsIntoCartFromShopPage(){

        shopPage.addItemToCartByIndex(1);
        
        shopPage.addItemToCartByIndex(2);
        
        shopPage.addItemToCartByIndex(3);

        Assertions.assertTrue("3".equals(shopPage.getNumberOfItemsInCart()));
    }
    
    @Test
    public void testPutOneItemIntoCartFromProductDetailsPage(){
        
        shopPage.viewItemDetailsByIndex(1);
        
        shopPage.clickAddToCartButtonOnItemDetailsPage();
        
        Assertions.assertTrue("1".equals(shopPage.getNumberOfItemsInCart()));
    }

    @Test
    public void testPutMultipleItemsIntoCartFromProductDetailsPage(){

        shopPage.viewItemDetailsByIndex(1);
        
        shopPage.clickAddToCartButtonOnItemDetailsPage();
        
        shopPage.clickBackToProductsButton();
        
        shopPage.viewItemDetailsByIndex(2);
        
        shopPage.clickAddToCartButtonOnItemDetailsPage();
        
        Assertions.assertTrue("2".equals(shopPage.getNumberOfItemsInCart()));
    }
    
    @Test
    public void testShoppingCartAfterRemovingItems(){
        
        shopPage.addItemToCartByIndex(1);
        
        shopPage.addItemToCartByIndex(2);
        
        shopPage.removeItemFromCartByIndex(1);
        
        shopPage.addItemToCartByIndex(3);
        
        Assertions.assertTrue("2".equals(shopPage.getNumberOfItemsInCart()));
        
    }
    
    
    @Test
    public void testPutInCartButtonTextAfterAddAndRemove(){
        
        shopPage.addItemToCartByIndex(1);
        
        Assertions.assertTrue("Remove".equals(shopPage.getAddOrRemoveStateOfButtonByIndex(1)));
        
        shopPage.removeItemFromCartByIndex(1);
        
        Assertions.assertTrue("Add to cart".equals(shopPage.getAddOrRemoveStateOfButtonByIndex(1)));
    }

    
    @AfterEach
    public void tearDown() {
        
        driver.quit();
        
    }
}
