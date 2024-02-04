package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {
    public CartPage (){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;
    public void navigateToCart(){
        cartButton.click();
    }
    @FindBy(className = "inventory_item_name")
    public List<WebElement> listItemsInCart;

    public boolean isInCart(String itemName){
        for (WebElement element : listItemsInCart){
            if (element.getText().contains(itemName))
                return true;
        }
        return false;
    }
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpack;
    public void removeBackpackClick(){
        removeBackpack.click();
    }

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLight;
    public void removeBikeLightClick(){
        removeBikeLight.click();
    }

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeTShirt;
    public void removeTShirtClick(){
        removeTShirt.click();
    }

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    public WebElement removeFleeceJacket;
    public void removeFleeceJacketClick(){
        removeFleeceJacket.click();
    }

    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeOnesie;
    public void removeOnesieClick(){
        removeOnesie.click();
    }

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement removeTShirtRed;
    public void removeTShirtRedClick(){
        removeTShirtRed.click();
    }

    @FindBy(id = "checkout")
    public WebElement checkoutButton;
    public void navigateToCheckOutPage(){
        checkoutButton.click();
    }

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;
    public void navigateToInventoryPage(){
        continueShoppingButton.click();
    }

    public boolean isCartEmpty(){
        return cartButton.getText().isEmpty();
    }

    public int numberOfItemInCart(){
        return Integer.parseInt(cartButton.getText());
    }

    @FindBy(className = "cart_item")
    public List<WebElement> numberOfItems;
    public int numberOfItemsOnCartPage(){
        int brojac = 0;
        for (WebElement element: numberOfItems){
            if (element.getText().contains("Remove")) brojac++;
        }
        return brojac;
    }

    public void removeAll(){
        for (WebElement element : numberOfItems){
            driver.findElement(By.cssSelector("button[class='btn btn_secondary btn_small cart_button']")).click();
        }
    }
}