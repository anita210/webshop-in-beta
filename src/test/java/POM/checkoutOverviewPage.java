package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutOverviewPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    public checkoutOverviewPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebElement getSwagLabsTitle() {
        return driver.findElement(By.cssSelector(".app_logo"));
    }

    private WebElement getShoppingCartIcon() {
        return driver.findElement(By.cssSelector(".shopping_cart_link"));
    }

    private WebElement getCheckoutOverviewTitle() {
        return driver.findElement(By.cssSelector(".header_secondary_container .title"));
    }

    private WebElement getCartList() {
        return driver.findElement(By.cssSelector(".cart_list"));
    }

    private WebElement getCartQuantityLabel() {
        return driver.findElement(By.cssSelector(".cart_quantity_label"));
    }

    private WebElement getCartDescriptionLabel() {
        return driver.findElement(By.cssSelector(".cart_desc_label"));
    }

    private WebElement getPaymentInfoLabel() {
        return driver.findElement(By.cssSelector(".summary_info_label[data-test='payment-info-label']"));
    }

    private WebElement getPaymentInfoValue() {
        return driver.findElement(By.cssSelector(".summary_value_label[data-test='payment-info-value']"));
    }

    private WebElement getShippingInfoLabel() {
        return driver.findElement(By.cssSelector(".summary_info_label[data-test='shipping-info-label']"));
    }

    private WebElement getShippingInfoValue() {
        return driver.findElement(By.cssSelector(".summary_value_label[data-test='shipping-info-value']"));
    }

    private WebElement getTotalInfoLabel() {
        return driver.findElement(By.cssSelector(".summary_info_label[data-test='total-info-label']"));
    }

    private WebElement getSubtotalLabel() {
        return driver.findElement(By.cssSelector(".summary_subtotal_label[data-test='subtotal-label']"));
    }

    private WebElement getTaxLabel() {
        return driver.findElement(By.cssSelector(".summary_tax_label[data-test='tax-label']"));
    }

    private WebElement getTotalLabel() {
        return driver.findElement(By.cssSelector(".summary_total_label[data-test='total-label']"));
    }

    private WebElement getCancelButton() {
        return driver.findElement(By.cssSelector("button[data-test='cancel']"));
    }

    private WebElement getFinishButton() {
        return driver.findElement(By.cssSelector("button[data-test='finish']"));
    }
    

    public void clickFinishButton() {
        getFinishButton().click();
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    public void clickItemInList(String itemName) {
        WebElement itemLink = driver.findElement(By.xpath(String.format("//a[@data-test='item-3-title-link']//div[contains(text(), '%s')]", itemName)));
        itemLink.click();
    }
}
