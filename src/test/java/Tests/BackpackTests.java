package Tests;

import Base.BaseTest;
import Pages.BackpackPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BackpackTests extends BaseTest {
    @BeforeMethod
    public void backpackPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        backpackPage = new BackpackPage();
    }
    @Test
    public void standardUserLogin(){
        loginPage.usernameFieldInput("standard_user");
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickToLogin();
    }
    @Test
    public void addBackpackToCart() {
        standardUserLogin();
        inventoryPage.selectBackPackItem();
        backpackPage.addBackpack();
        Assert.assertTrue(backpackPage.removeButton.isDisplayed());
        Assert.assertFalse(backpackPage.addedToCart().isEmpty());
    }
    @Test
    public void removeBackpackFromCart(){
        addBackpackToCart();
        backpackPage.removeBackpack();
        Assert.assertTrue(backpackPage.addToCartButton.isDisplayed());
        Assert.assertTrue(backpackPage.addedToCart().isEmpty());
    }
    @Test
    public void navigateToInventoryPage() throws InterruptedException {
        standardUserLogin();
        inventoryPage.selectBackPackItem();
        Thread.sleep(500);
        backpackPage.navigateToInventory();
    }
}