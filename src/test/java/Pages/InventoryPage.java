package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BaseTest {
    public InventoryPage (){
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    public String inventoryURL(){
        return "https://www.saucedemo.com/inventory.html";
    }

    //Side menu elements
    @FindBy (id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;
    public void clickOnBurgerMenu(){
        burgerMenuButton.click();
    }
    @FindBy (id = "inventory_sidebar_link")
    public WebElement allItemsButton;
    public void clickOnAllItemsButton(){
        allItemsButton.click();
    }
    @FindBy (id = "about_sidebar_link")
    public WebElement aboutButton;
    public void clickOnAboutButton(){
        aboutButton.click();
    }
    @FindBy (id = "logout_sidebar_link")
    public WebElement logoutButton;
    public void clickOnLogoutButton(){
        logoutButton.click();
    }
    @FindBy (id = "reset_sidebar_link")
    public WebElement resetAppStateButton;
    public void clickOnResetAppStateButton(){
        resetAppStateButton.click();
    }
    @FindBy (id = "react-burger-cross-btn")
    public WebElement closeBurgerMenuButton;
    public void clickOnCloseBurgerMenuButton(){
        closeBurgerMenuButton.click();
    }
    //

    //Inventory items elemetns

    @FindBy (className = "inventory_item_img")
    public List<WebElement> inventoryItemImage;
    //!!!metoda za proveru slika!!!//


    @FindBy (className = "inventory_item_price")
    public List<WebElement> inventoryItemPrice;

    public List<Double> listPrice = new ArrayList<>();

    public void getPriceInList(){
        for (WebElement element : inventoryItemPrice){
            String priceAsString = element.getText().replaceAll("\\$", "");
            double price = Double.parseDouble(priceAsString);
            listPrice.add(price);
        }
        System.out.println(listPrice);
    }

    public boolean isIncreasing(){
        for (int i = 0; i < listPrice.size()-1; i++) {
            if (listPrice.get(i) > listPrice.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDecreasing(){
        for (int i = 0; i < listPrice.size()-1; i++) {
            if (listPrice.get(i) < listPrice.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    @FindBy (className = "inventory_item_desc")
    public List<WebElement> inventoryItemText;

    @FindBy (id = "shopping_cart_container")
    public WebElement cartIcon;
    public void clickOnCart(){
        cartIcon.click();
    }


    @FindBy (id = "item_4_title_link")
    public WebElement backPackItem;
    public void selectBackPackItem() {
        backPackItem.click();
    }
    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement backPackAddToCartButton;
    public void addBackpackItemToCart(){
        backPackAddToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement backPackRemoveButton;
    public void removeBackpackItemFromCart(){
        backPackRemoveButton.click();
    }


    //Items
    @FindBy (id = "item_0_title_link")
    public WebElement bikeLightItem;
    public void selectbikeLightItem() {
        bikeLightItem.click();
    }
    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLightAddToCartButton;
    public void addBikeLightItemToCart(){
        bikeLightAddToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-bike-light")
    public WebElement bikeLightRemoveButton;
    public void  removeBikeLightItemFromCart(){
        bikeLightRemoveButton.click();
    }

    @FindBy (id = "item_1_title_link")
    public WebElement tShirtItem;
    public void selectTShirtItem() {
        tShirtItem.click();
    }
    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement tShirtAddToCartButton;
    public void addTShirtItemToCart(){
        tShirtAddToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement tShirtRemoveButton;
    public void  removeTShirtItemFromCart(){
        tShirtRemoveButton.click();
    }


    @FindBy (id = "item_5_title_link")
    public WebElement fleeceJacketItem;
    public void selectFleeceJacketItem() {
        fleeceJacketItem.click();
    }
    @FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacketAddToCartButton;
    public void addFleeceJacketItemToCart(){
        fleeceJacketAddToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-fleece-jacket")
    public WebElement fleeceJacketRemoveButton;
    public void  removeFleeceJacketItemFromCart(){
        fleeceJacketRemoveButton.click();
    }


    @FindBy (id = "item_2_title_link")
    public WebElement onesieItem;
    public void selectOnesieItem() {
        onesieItem.click();
    }
    @FindBy (id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieAddToCartButton;
    public void addOnesieItemToCart(){
        onesieAddToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-onesie")
    public WebElement onesieRemoveButton;
    public void  removeOnesieItemFromCart(){
        onesieRemoveButton.click();
    }


    @FindBy (id = "item_3_title_link")
    public WebElement tShirtRedItem;
    public void selectTShirtRedItem() {
        tShirtRedItem.click();
    }
    @FindBy (id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement tShirtRedAddToCartButton;
    public void addTShirtRedItemToCart(){
       tShirtRedAddToCartButton.click();
    }
    @FindBy (id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement tShirtRedRemoveButton;
    public void  removeTShirtRedItemFromCart(){
        tShirtRedRemoveButton.click();
    }


    @FindBy (className = "product_sort_container")
    public WebElement selectButton;

    public void sortByName(){
        Select select = new Select(selectButton);
        select.selectByVisibleText("Name (A to Z)");
    }

    public void sortByNameReverse(){
        Select select = new Select(selectButton);
        select.selectByVisibleText("Name (Z to A)");
    }

    public void sortByPrice(){
        Select select = new Select(selectButton);
        select.selectByVisibleText("Price (low to high)");
    }

    public void sortByPriceReverse(){
        Select select = new Select(selectButton);
        select.selectByVisibleText("Price (high to low)");
    }

    @FindBy(className = "inventory_item")
    public List<WebElement> listItemsTitle;

    public void addItemToCart(String itemsName){
        for(WebElement element : listItemsTitle){
            if (element.getText().contains(itemsName)){
                element.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']")).click();
                break;
            }
        }
    }

    @FindBy (className = "inventory_item_name")
    public List<WebElement> itemByName;

    public void navigateToItem(String nameItem){
        for (WebElement element : itemByName){
            if (element.getText().contains(nameItem)){
                element.click();
                break;
            }
        }
    }

}