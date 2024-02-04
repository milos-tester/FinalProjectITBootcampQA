package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @BeforeMethod
    public void cartPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        items = new Items();
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.clickToLogin();
    }

    @Test
    public void userAddBackpackToCart(){
        inventoryPage.addBackpackItemToCart();
        Assert.assertTrue(inventoryPage.backPackRemoveButton.isDisplayed());
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isInCart("Backpack"));
        cartPage.removeBackpackClick();
        Assert.assertFalse(cartPage.isInCart("Backpack"));
    }

    @Test
    public void userAddAllItemsToCart(){
        inventoryPage.addBackpackItemToCart();
        inventoryPage.addBikeLightItemToCart();
        inventoryPage.addTShirtItemToCart();
        inventoryPage.addFleeceJacketItemToCart();
        inventoryPage.addOnesieItemToCart();
        inventoryPage.addTShirtRedItemToCart();
        System.out.println(items.numberOfAddedItemsFromHomePage());
        Assert.assertEquals(items.numberOfAddedItemsFromHomePage(), cartPage.numberOfItemInCart());
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isInCart("Onesie"));
    }

    @Test
    public void userCanRemoveItemFromCart(){
        userAddAllItemsToCart();
        cartPage.removeAll();
        Assert.assertTrue(cartPage.isCartEmpty());
        cartPage.navigateToInventoryPage();
    }
}