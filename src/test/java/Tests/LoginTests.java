package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void loginSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(siteURL);
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
    }
    @Test
    public void userCanLoginAsAStandardUserWithClick(){
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.clickToLogin();
    }
    @Test
    public void userCanLoginAsAStandardUserWithEnter(){
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.pressEnterToLogin();
    }
    @Test
    public void userCanLoginAsAStandardUserUsingKeyboard() throws InterruptedException {
        loginPage.usernameNavigateWithKeyboard(standardUsername);
        loginPage.passwordNavigateWithKeyboard(password);
        Assert.assertEquals(driver.getTitle(), siteTitle);
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }
}