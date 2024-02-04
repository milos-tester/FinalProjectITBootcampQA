package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackpackPage extends BaseTest {
    public BackpackPage (){
        PageFactory.initElements(driver, this);
    }

    public String backpackURL(){
        return "https://www.saucedemo.com/inventory-item.html?id=4";
    }

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;
    public void addBackpack(){
        addToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement removeButton;
    public void removeBackpack(){
        removeButton.click();
    }
    @FindBy (id = "back-to-products")
    public WebElement backToProducts;
    public void navigateToInventory(){
        backToProducts.click();
    }
    @FindBy (className = "shopping_cart_link")
    public WebElement cartIcon;
    public String addedToCart(){
        return cartIcon.getText();
    }
    public boolean isEmpty(){
        return cartIcon.getText().isEmpty();
    }
}
