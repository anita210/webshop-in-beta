package tests;

import POM.loginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.io.IOException;

public class LoginPageTests {
    private String username;
    private WebDriver driver;
    private WebDriverWait wait;
    private loginPage _loginPage;
    private WebElement productTitle;
    WebElement errorMessage;
    private String passwordForAll;
     
    
    @BeforeEach
    public void setup() throws IOException {
        passwordForAll = System.getenv("PW_FOR_ALL");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        _loginPage = new loginPage(driver, wait);
        
        driver.get("http://www.saucedemo.com/");
    }

    @Test
    public void loginWithStandardUser() throws IOException {
        username = System.getenv("STANDARD_USER");
     
        _loginPage.loginProcess(username, passwordForAll);

        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='title' and text()='Products']")));
        Assertions.assertTrue(productTitle.isDisplayed(), "Products title is not displayed");
    }

    @Test
    public void loginWithLockedOutUser() throws IOException {
        username = System.getenv("LOCKED_OUT_USER");
        
        _loginPage.loginProcess(username, passwordForAll);

        errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assertions.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed (Epic sadface: Sorry, this user has been locked out.)");
    }

    @Test
    public void loginWithProblemUser() throws IOException {
        username = System.getenv("PROBLEM_USER");
        
        _loginPage.loginProcess(username, passwordForAll);

        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='title' and text()='Products']")));
        Assertions.assertTrue(productTitle.isDisplayed(), "Products title is not displayed");
    }

    @Test
    public void loginWithPerformanceGlitchUser() throws IOException {
        username = System.getenv("PERFORMANCE_GLITCH_USER");
        
        _loginPage.loginProcess(username, passwordForAll);
        
        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='title' and text()='Products']")));
        Assertions.assertTrue(productTitle.isDisplayed(), "Products title is not displayed");
    }

    @Test
    public void loginWithErrorUser() throws IOException {
        username = System.getenv("ERROR_USER");
        
        _loginPage.loginProcess(username, passwordForAll);

        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='title' and text()='Products']")));
        Assertions.assertTrue(productTitle.isDisplayed(), "Products title is not displayed");
    }

    @Test
    public void loginWithVisualUser() throws IOException {
        username = System.getenv("VISUAL_USER");
        
        _loginPage.loginProcess(username, passwordForAll);
        

        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='title' and text()='Products']")));
        Assertions.assertTrue(productTitle.isDisplayed(), "Products title is not displayed");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }  
}
