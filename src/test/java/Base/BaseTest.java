package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static WebDriver driver;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public BackpackPage backpackPage;
    public BikeLightPage bikeLightPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;
    public CompletePage completePage;
    public ExcelReader excelReader;
    public Items items;

    public final static String siteURL = "https://www.saucedemo.com/";
    public final static String siteTitle = "Swag Labs";
    public final static String standardUsername = "standard_user";
    public final static String password = "secret_sauce";

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
    }

//    @AfterMethod
//    public void closeChrom() throws InterruptedException {
//        Thread.sleep(1000);
//        driver.close();
//    }
}