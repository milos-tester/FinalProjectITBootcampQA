package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteTests extends BaseTest {
    @BeforeMethod
    public void cartPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        confirmationPage = new ConfirmationPage();
        completePage = new CompletePage();
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
        cartPage.navigateToCheckOutPage();
    }
    @Test
    public void userCanCompletePurchase(){
        userAddBackpackToCart();
        checkoutPage.inputFirstName("Milos");
        checkoutPage.inputLastName("Tester");
        checkoutPage.inputZipPostalCode("12345");
        checkoutPage.navigateToConfirmationPage();
        Assert.assertTrue(confirmationPage.isInCart("Backpack"));
        confirmationPage.confirmOrder();
    }

    @Test
    public void userCanFinishOrder() throws InterruptedException {
        userCanCompletePurchase();
        Assert.assertTrue(completePage.isSuccessfull());
        Assert.assertTrue(cartPage.isCartEmpty());
        completePage.navigateToHomePage();
        Assert.assertTrue(inventoryPage.backPackAddToCartButton.isDisplayed());
        inventoryPage.clickOnBurgerMenu();
        Thread.sleep(500);
        Assert.assertTrue(inventoryPage.logoutButton.isDisplayed());
        inventoryPage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), siteURL);
    }
}