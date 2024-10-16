package tests;

import POM.shopPage;
import POM.loginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class orderedListTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private loginPage loginPage;
    private shopPage shopPage;


    @BeforeEach
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginPage = new loginPage(driver, wait);
        shopPage = new shopPage(driver, wait);

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void orderedListHighToLow(){
        loginPage.loginProcess(System.getenv("STANDARD_USER"), System.getenv("PW_FOR_ALL"));
        shopPage.selectPriceHighToLow();

        String expected = "Sauce Labs Fleece Jacket";
        String actual = shopPage.getFirstItemName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void orderedListLowToHigh(){
        loginPage.loginProcess(System.getenv("STANDARD_USER"), System.getenv("PW_FOR_ALL"));
        shopPage.selectPriceLowToHigh();

        String expected = "Sauce Labs Onesie";
        String actual = shopPage.getFirstItemName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void orderedListAToZ(){
        loginPage.loginProcess(System.getenv("STANDARD_USER"), System.getenv("PW_FOR_ALL"));
        shopPage.selectNameAToZ();

        String expected = "Sauce Labs Backpack";
        String actual = shopPage.getFirstItemName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void orderedListZToA(){
        loginPage.loginProcess(System.getenv("STANDARD_USER"), System.getenv("PW_FOR_ALL"));
        shopPage.selectNameZToA();

        String expected = "Test.allTheThings() T-Shirt (Red)";
        String actual = shopPage.getFirstItemName();

        Assertions.assertEquals(expected, actual);
    }




    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
