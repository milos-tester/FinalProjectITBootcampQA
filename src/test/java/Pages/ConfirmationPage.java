package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmationPage extends BaseTest {
    public ConfirmationPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;
    public void confirmOrder(){
        finishButton.click();
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
}