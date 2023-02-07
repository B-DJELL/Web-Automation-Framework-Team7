package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LogoutPage.class.getName());

    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//objects

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement LogoutButton;



// Reusable methods
    public void ClickOnLogoutButton(){
    clickOn(LogoutButton);
    LOG.info("Click on Logout button success");
}



}