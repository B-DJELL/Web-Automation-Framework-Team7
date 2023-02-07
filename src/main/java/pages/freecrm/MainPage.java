package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends CommonAPI {

    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(MainPage.class.getName());

    @FindBy (xpath="//a[text()='Log In']")
    WebElement logInBtn;

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath = "//a[normalize-space()='Compare']")
    WebElement CompareBtn;

    @FindBy(xpath = "//a[normalize-space()='Pricing']")
    WebElement PricingBtn;

    @FindBy(xpath = "//a[normalize-space()='About']")
    WebElement AboutBtn;

    @FindBy(xpath = "//a[normalize-space()='CRM']")
    WebElement CrmMenu;

    @FindBy(xpath = "//a[normalize-space()='CRM for Any Business']")
    WebElement CrmForAnyBusiness;

    public void clickOnLogin(){
        clickOn(logInBtn);
        log.info("Click on Login Success");
    }

    public void clickOnSignUp(){
        clickOn(signUpBtn);
        log.info("Click on Sign Up Success");
    }

    public void clickOnCompareBtn(){
        clickOn(CompareBtn);
        log.info("Click on Compare Button Success");
    }

    public void clickOnPricingBtn(){
        clickOn(PricingBtn);
        log.info("Click on Sign Up Success");
    }

    public void hoverOverCrmAndSelectCrmForAnyBusiness(WebDriver driver){
        hoverOver(driver,CrmMenu);
        clickOn(CrmForAnyBusiness);
        log.info("Hover Over Crm And Select Crm For Any Business Success");
    }

    public void clickOnAboutBtn(){
        clickOn(AboutBtn);
        log.info("Click on About Button Success");
    }



}
