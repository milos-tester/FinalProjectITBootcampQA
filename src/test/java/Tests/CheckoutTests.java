package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @BeforeMethod
    public void cartPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.clickToLogin();
    }

    @Test
    public void userCanAddBackpack(){
        inventoryPage.addBackpackItemToCart();
        Assert.assertTrue(inventoryPage.backPackRemoveButton.isDisplayed());
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isInCart("Backpack"));
        cartPage.navigateToCheckOutPage();
    }
    @Test
    public void userCanSendInputsInCheckoutFields(){
        userCanAddBackpack();
        checkoutPage.inputFirstName("Milos");
        checkoutPage.inputLastName("Tester");
        checkoutPage.inputZipPostalCode("12345");
        checkoutPage.navigateToConfirmationPage();
    }

//    @Test
//    public void userCannotLeaveBlankField() throws InterruptedException {
//        userCanAddBackpack();
//        checkoutPage.navigateToConfirmationPage();
//        Thread.sleep(500);
//        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
//    }
}