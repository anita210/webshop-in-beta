package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class yourCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(css = "div[class='cart_list']")
    private WebElement cartList;

    private WebElement removeFromCart(int location){
        return driver.findElement(By.cssSelector(String.format
                ("html > body > div > div > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(%s) > div:nth-of-type(2) > div:nth-of-type(2) > button", location+2)));
    }

    public yourCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(cartList));
        checkoutButton.click();

    }
    public void goToContinueShopping(){
        wait.until(ExpectedConditions.visibilityOf(cartList));
        continueShoppingButton.click();
    }

    public void removeYourFromCart(int location){
        wait.until(ExpectedConditions.visibilityOf(cartList));
        removeFromCart(location).click();
    }
    
}
