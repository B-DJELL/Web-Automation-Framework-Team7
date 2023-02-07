package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailSelectedItemToFriendPage extends CommonAPI {
    Logger log = LogManager.getLogger(EmailSelectedItemToFriendPage.class.getName());

    public EmailSelectedItemToFriendPage(WebDriver driver) {PageFactory.initElements(driver, this);}


    @FindBy(css = ".button-2.email-a-friend-button")
    WebElement EmailaFreindButton;
    @FindBy(css = "#FriendEmail")
    WebElement Freindemail;
    @FindBy(xpath = "//input[@id='YourEmailAddress']")
    WebElement Senderdemail;
    @FindBy(xpath = "(//button[normalize-space()='Send email'])[1]")
    WebElement SendEmail;
    @FindBy(xpath = "//li[contains(text(),'Only registered customers can use email a friend f')]")
    WebElement  sendError;


    public void cLickOnEmailFriend(){
        clickOn(EmailaFreindButton);
        log.info("Click on Email A Freind Button Success");
    }
    public void typeEmailFriendAddress(String emailAddress){
        type(Freindemail, emailAddress);
        log.info("type email address success");
    }
    public void typeYourEmailAddress(String yourEmailAddress){
        type(Senderdemail, yourEmailAddress);
        log.info("type email address success");
    }
    public void cLickOnSendEmail(){
        clickOn(SendEmail);
        log.info("Click on send email Button Success");
    }

    public String emailItemError (){
        return getTextFromElement(sendError);
    }


}
