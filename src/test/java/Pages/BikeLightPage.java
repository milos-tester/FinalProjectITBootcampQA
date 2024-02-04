package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BikeLightPage extends BaseTest {
    public BikeLightPage(){
        PageFactory.initElements(driver, this);
    }

    public String bikeLightURL(){return "https://www.saucedemo.com/inventory-item.html?id=0";}
    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addToCartButton;
    public void addBikeLight(){
        addToCartButton.click();
    }
    @FindBy (id = "remove-sauce-labs-bike-light")
    public WebElement removeButton;
    public void removeBikeLight(){
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
}
