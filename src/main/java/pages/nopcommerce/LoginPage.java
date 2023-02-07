package pages.nopcommerce;


import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //objects
    @FindBy(xpath = "(//a[normalize-space()='Log in'])[1]")

    WebElement LoginButton;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement PasswordField;

    @FindBy(xpath = "//input[@id='RememberMe']")
    WebElement CheckRememberMe;

    @FindBy(xpath = "(//button[normalize-space()='Log in'])[1]")
    WebElement LOGIN;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement LoginErrorMessage;


    //reusable methods
    public void clickOnLogin(){
        clickOn(LoginButton);
        LOG.info("land on login page success");
    }

    public void typeEmailAddress(String emailAddress){
        type(emailField, emailAddress);
        LOG.info("type email address success");
    }
    public void typePassword(String  Password){
        type(PasswordField, Password);
        LOG.info("type password success");
    }


    public void checkRememberMeButton(){
        clickOn(CheckRememberMe);
        LOG.info("check button success");
    }
    public void clickOnLOGINButton(){
        clickOn(LOGIN);
        LOG.info("click on LOGIN button success");
    }

    public String  unsuccessfulLogin(){return getTextFromElement(LoginErrorMessage);}

}
