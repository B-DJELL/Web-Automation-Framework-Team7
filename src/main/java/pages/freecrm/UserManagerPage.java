package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagerPage extends CommonAPI {
    public UserManagerPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy (xpath = "//div[@class='ui button']")
    WebElement addUserButton;


    public void clickOnAddUserButton(){
        clickOn(addUserButton);
    }

}
