package Tests;

import Base.BaseTest;
import Pages.BackpackPage;
import Pages.BikeLightPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InventoryTests extends BaseTest {

    @BeforeMethod
    public void inventoryPageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(siteURL);
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        backpackPage = new BackpackPage();
        bikeLightPage = new BikeLightPage();
        loginPage.usernameFieldInput(standardUsername);
        loginPage.passwordFieldInput(password);
        loginPage.clickToLogin();
    }

    @Test
    public void userIsOnInventoryPage(){
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }

    @Test
    public void userCanNavigateToItem(){
        inventoryPage.navigateToItem("Red");
    }

    @Test
    public void userCanClickOnBackPackItem() {
        inventoryPage.selectBackPackItem();
        Assert.assertEquals(driver.getCurrentUrl(), backpackPage.backpackURL());
    }
    @Test
    public void userCanClickOnBikeLightItem() {
        inventoryPage.selectbikeLightItem();
        Assert.assertEquals(driver.getCurrentUrl(), bikeLightPage.bikeLightURL());
    }

    @Test
    public void userCanClickOnFleeceJacketItem() {
        inventoryPage.selectFleeceJacketItem();
    }
    @Test
    public void userCanClickOnOnesieItem() {
        inventoryPage.selectOnesieItem();
    }
    @Test
    public void userCanClickOnTShirtRedItem() {
        inventoryPage.selectTShirtRedItem();
    }
    @Test
    public void userCanUseSortFunction() throws InterruptedException {
        userIsOnInventoryPage();
        Thread.sleep(500);
        inventoryPage.sortByName();
        Thread.sleep(500);
        inventoryPage.sortByNameReverse();
        Thread.sleep(500);
        inventoryPage.sortByPrice();
        Thread.sleep(500);
        inventoryPage.sortByPriceReverse();
    }

    @Test
    public void isIncreasing() throws InterruptedException {
        userIsOnInventoryPage();
        inventoryPage.sortByPrice();
        Thread.sleep(500);
        inventoryPage.getPriceInList();
        Assert.assertTrue(inventoryPage.isIncreasing());
    }

    @Test
    public void isDecreasing() throws InterruptedException {
        userIsOnInventoryPage();
        inventoryPage.sortByPriceReverse();
        Thread.sleep(500);
        inventoryPage.getPriceInList();
        Assert.assertTrue(inventoryPage.isDecreasing());
    }

    @Test
    public void addItemToCart(){
        inventoryPage.addItemToCart("Onesie");
    }
}