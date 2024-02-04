package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user-name")
    public WebElement usernameField;
    @FindBy (id = "password")
    public WebElement passwordField;
    @FindBy (id = "login-button")
    public WebElement loginButton;

    public void usernameFieldInput(String usernameInput){
        usernameField.clear();
        usernameField.sendKeys(usernameInput);
    }

    public void passwordFieldInput(String passwordInput){
        passwordField.clear();
        passwordField.sendKeys(passwordInput);
    }

    public void clickToLogin(){
        loginButton.click();
    }

    public void pressEnterToLogin(){
        passwordField.sendKeys(ENTER);
    }

    public void usernameNavigateWithKeyboard(String usernameInput){
        usernameField.clear();
        usernameField.sendKeys(usernameInput);
        usernameField.sendKeys(TAB);
    }

    public void passwordNavigateWithKeyboard(String passwordInput){
        passwordField.clear();
        passwordField.sendKeys(passwordInput);
        passwordField.sendKeys(ENTER);
    }
}