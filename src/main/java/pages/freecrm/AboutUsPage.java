package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage extends CommonAPI {
    public AboutUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(MainPage.class.getName());

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement SignUpBtn;

    public void SignUp(){
        clickOn(SignUpBtn);
        log.info("About button clicked success");
    }
}
