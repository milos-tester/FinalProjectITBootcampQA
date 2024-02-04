package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Items extends BaseTest {
    public Items(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "inventory_item")
    public List<WebElement> listAddRemoveButtons;

    public int numberOfAddedItemsFromHomePage(){
        int brojAdd = 0;
        for (WebElement element : listAddRemoveButtons){
            if (element.getText().contains("Remove")) brojAdd++;
        }
        return brojAdd;
    }

    @FindBy (className = "cart_item")
    public List<WebElement> listRemoveButtons;

}