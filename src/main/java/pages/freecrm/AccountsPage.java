package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends CommonAPI {
    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//input[@name='company_name']")
    WebElement CompanyNameField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveButton;

    @FindBy(xpath = "//a[normalize-space()='Outgoing Mail']")
    WebElement OutgoingMailButton;

    @FindBy(xpath = "//a[normalize-space()='Incoming Mail']")
    WebElement IncomingMailButton;

    @FindBy(xpath = "//a[normalize-space()='Telephony Account']")
    WebElement TelephonyAccountButton;

    @FindBy(xpath ="//a[normalize-space()='Telephony Settings']")
    WebElement TelephonySettingsButton;

    @FindBy(xpath = "//a[normalize-space()='Google Account']")
    WebElement GoogleAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Facebook Account']")
    WebElement FacebookAccountButton;

    @FindBy(xpath = "//a[normalize-space()='QuickBooks']")
    WebElement QuickBooksButton;

    public void fillUpCompanyNameField(String CompanyName){
        CompanyNameField.sendKeys(CompanyName);
    }

    public void clickOnSaveButton(){
        clickOn(SaveButton);
    }

    public void clickOnOutgoingButton(){
        clickOn(OutgoingMailButton);
    }

    public void clickOnIncomingMail(){
        clickOn(IncomingMailButton);
    }

    public void clickOnTelephonyAccountButton(){
        clickOn(TelephonyAccountButton);
    }

    public void clickOnTelephonySettingsButton(){
        clickOn(TelephonySettingsButton);
    }

    public void clickOnQuickBooksButton(){
        clickOn(QuickBooksButton);
    }

    public void clickOnGoogleAccountButton(){
        clickOn(GoogleAccountButton);
    }
    public void clickOnFacebookAccountButton(){clickOn(FacebookAccountButton);}

}
