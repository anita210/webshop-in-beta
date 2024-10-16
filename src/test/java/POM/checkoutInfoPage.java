package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div[class='checkout_info']")
    private WebElement checkoutInfoContainer;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public checkoutInfoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOf(checkoutInfoContainer));
        firstNameInput.clear();
        lastNameInput.clear();
        postalCodeInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void submitFormContinue() {
        wait.until(ExpectedConditions.visibilityOf(checkoutInfoContainer));
        continueButton.click();
    }

    public void cancelForm() {
        wait.until(ExpectedConditions.visibilityOf(checkoutInfoContainer));
        cancelButton.click();
    }
}
