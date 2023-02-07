package pages.freecrm;

import base.CommonAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage  extends CommonAPI {
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(SignUpPage.class.getName());

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(name="terms")
    WebElement termsAgree;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement notRobot;


    public void typeEmail(String email){
        type(emailAddress,email);
    }

    public void agreeTerms(){
        clickOn(termsAgree);
        log.info("click On terms agree success");
    }

    public void notRobotCheckBox(){
       // driver.switchTo().frame(0);
        clickOn(notRobot);
        log.info("click On not Robot success");
    }

}
