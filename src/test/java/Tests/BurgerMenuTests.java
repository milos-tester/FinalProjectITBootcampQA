package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.base.Ascii.ESC;

public class BurgerMenuTests extends BaseTest {
    @BeforeMethod
    public void inventoryPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.clickToLogin();
    }

    @Test
    public void userCanOpenBurgerMenu(){
        inventoryPage.clickOnBurgerMenu();
    }
    @Test
    public void userCanOpenAndCloseBurgerMenu() throws InterruptedException {
        inventoryPage.clickOnBurgerMenu();
        Thread.sleep(500);
        inventoryPage.clickOnCloseBurgerMenuButton();
    }

    @Test
    void escKeyborad() throws InterruptedException {
        inventoryPage.clickOnBurgerMenu();
        Thread.sleep(500);
        inventoryPage.burgerMenuButton.sendKeys(Keys.ESCAPE);
    }
}