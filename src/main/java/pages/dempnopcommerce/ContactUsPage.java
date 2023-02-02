package pages.dempnopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FullName")
    WebElement fullNameTxtBox;
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Enquiry")
    WebElement enquiryTxtBox;
    @FindBy(css = "button.button-1.contact-us-button")
    WebElement submitBtn;

    @FindBy(xpath = "(//div[@class='result'])[1]")
    WebElement displayedMessage;

    @FindBy(css = "div.result")

    public WebElement enquirySent;

    public void contactUsSendEnquiryProcess(String fullName , String email , String enquiry) {
        sendKeysTxt(fullNameTxtBox, fullName);
        sendKeysTxt(emailTxtBox, email);
        sendKeysTxt(enquiryTxtBox, enquiry);
        clickOn(submitBtn);
    }
    public String getQuerySentMessage(){
        return getTextFromElement(displayedMessage);
    }
}
