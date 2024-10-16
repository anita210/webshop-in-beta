package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class loginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public loginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    private WebElement getSwagLabsTitle() {
        return driver.findElement(By.xpath("//a[text()='Swag Labs']"));
    }
    
    private WebElement getUsernameInput() {
        return driver.findElement(By.id("user-name"));
    }
    
    private WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }
    
    private WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }
    
    private WebElement getUsernameList() {
        return driver.findElement(By.id("login_credentials"));
    }
    
    private WebElement getPasswordList() {
        return driver.findElement(By.cssSelector("div.login_password"));
    }

    // Method to login process
    public void loginProcess(String username, String password) {
        
        getUsernameInput().clear();
        getPasswordInput().clear();
        
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }

    public boolean isLoginPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
        return getLoginButton().isDisplayed();
    }
}
