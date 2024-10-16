package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navbar {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement reactMenuButton;

    @FindBy(css = "nav[class='bm-item-list']")
    private WebElement navSideBarOpen;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement inventoryLink;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetLink;

    public navbar(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickReactMenuButton() {
        wait.until(ExpectedConditions.visibilityOf(reactMenuButton));
        reactMenuButton.click();
    }

    public void clickInventoryLink() {
        wait.until(ExpectedConditions.visibilityOf(navSideBarOpen));
        inventoryLink.click();
    }

    public void clickAboutLink() {
        wait.until(ExpectedConditions.visibilityOf(navSideBarOpen));
        aboutLink.click();
    }

    public void clickLogoutLink() {
        wait.until(ExpectedConditions.visibilityOf(navSideBarOpen));
        logoutLink.click();
    }

    public void clickResetLink() {
        wait.until(ExpectedConditions.visibilityOf(reactMenuButton));
        resetLink.click();
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        resetLink.click();
    }

}
