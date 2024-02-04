package Tests;

import Base.BaseTest;
import Pages.BikeLightPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BikeLightTests extends BaseTest {
    @BeforeMethod
    public void bikeLightPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        bikeLightPage = new BikeLightPage();
    }
    @Test
    public void standardUserLogin(){
        loginPage.usernameFieldInput("standard_user");
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickToLogin();
    }
    @Test
    public void addBikeLightToCart(){
        standardUserLogin();
        inventoryPage.selectbikeLightItem();
        bikeLightPage.addBikeLight();
        Assert.assertTrue(bikeLightPage.removeButton.isDisplayed());
        Assert.assertFalse(bikeLightPage.addedToCart().isEmpty());
    }
    @Test
    public void removeBikeLightFromCart(){
        addBikeLightToCart();
        bikeLightPage.removeBikeLight();
        Assert.assertTrue(bikeLightPage.addToCartButton.isDisplayed());
        Assert.assertTrue(bikeLightPage.addedToCart().isEmpty());
    }
    @Test
    public void navigateToInventoryPage() throws InterruptedException {
        standardUserLogin();
        inventoryPage.selectbikeLightItem();
        Thread.sleep(500);
        bikeLightPage.navigateToInventory();
    }
}