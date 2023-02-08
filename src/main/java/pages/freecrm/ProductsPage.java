package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends CommonAPI {
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(ProductsPage.class.getName());

    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement NewProductButton;

    public void clickOnNewProductButton(){
        clickOn(NewProductButton);
    }
}
