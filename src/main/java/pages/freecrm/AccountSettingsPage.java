package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage extends CommonAPI {
    public AccountSettingsPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(AccountSettingsPage.class.getName());

    @FindBy(xpath ="//a[normalize-space()='Accounts']")
    WebElement accountButton;

    @FindBy(xpath="//a[normalize-space()='User Manager']")
    WebElement userManagerButton;

    public void clickOnUserManagerButton(){
        clickOn(userManagerButton);
        log.info("Click On User Manager Button Success");
    }

    public void clickOnAccountButton(){
        clickOn(accountButton);
        log.info("Click on Account Button Success");
    }
}
