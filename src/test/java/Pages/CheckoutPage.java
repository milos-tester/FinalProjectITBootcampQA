package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    public WebElement firstNameField;

    public void inputFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    @FindBy(id = "last-name")
    public WebElement lastNameField;
    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    @FindBy(id = "postal-code")
    public WebElement zipPostalCodeField;
    public void inputZipPostalCode(String zipPostalCode){
        zipPostalCodeField.clear();
        zipPostalCodeField.sendKeys(zipPostalCode);
    }

    @FindBy(id = "continue")
    public WebElement continueButton;
    public void navigateToConfirmationPage(){
        continueButton.click();
    }

    @FindBy(className = ".error-message-container.error")
    public WebElement errorMessage;

    //CANCEL button id = cancel

}