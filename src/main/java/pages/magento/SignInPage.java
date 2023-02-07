package pages.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchPage.class.getName());

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

//    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a/span")
//    WebElement createAnAccount;


    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    WebElement passwordField;

    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
    WebElement signInButton2;

    @FindBy(css = "a[class='action remind'] span")
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement resetMyPasswordBtn;
    @FindBy(xpath = "//*[@id=\"captcha_user_forgotpassword-error\"]")
    WebElement requiredField;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailToResetPassword;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement incorrectCred;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
    WebElement welcomeMessage;

    @FindBy(xpath = "//*[@id=\"captcha-container-user_login\"]/div/button")
    WebElement captchaBtn;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div")
    WebElement incorrectCredMsg;



    //REUSABLE STEPS
//    public void typeEmailAddress() throws InterruptedException {
//        clickOn(createAnAccount);
//        LOG.info("clicking on create an account success");


//    public void typeEmailAddress() throws InterruptedException {
//        type(emailAddress, "roni_cost@example.com");
//        LOG.info("typing email success");
//    }

    public void typeEmailAddress(String emailAddress) throws InterruptedException {
       type(emailField,emailAddress);
//        type(emailField,);
        LOG.info("typing email success");
    }
//    public void validEmailAddress() throws InterruptedException {
////       type(emailField,emailAddress);
//        type(emailField,"leghzali@gmail.com");
//        LOG.info("typing email success");
//    }

    public void wrongCredEmail() throws InterruptedException {
        type(emailField,"leghzal@gmail.com");
        LOG.info("typing email success");
    }
    public void fakeEmail() throws InterruptedException {
        type(emailField,"ismail@gmail.com");
        LOG.info("typing email success");
    }

    public void password(String password) throws InterruptedException {
//        type(passwordField,password);
        type(passwordField,"@ISMAIL@leghzali@");
        LOG.info("typing password success");
    }

    public void SignInButton2() throws InterruptedException {
        clickOn(signInButton2);
        LOG.info("click on sign in btn success");
    }

    public void forgotPassword() throws InterruptedException {
        clickOn(forgotPassword);
        LOG.info("click on forget your password btn success");
    }

    public void resetMyPasswordBtn() throws InterruptedException {
        clickOn(resetMyPasswordBtn);
        LOG.info("writing success");
    }

    public void typeEmail2() throws InterruptedException {
       type(emailToResetPassword,"roni_cost@example.com");
        LOG.info("writing email success");
    }
    public void captchaReload() throws InterruptedException {
        clickOn(captchaBtn);
        LOG.info("click captcha reload button success");
    }

    public String getRequiredField() {
        return getTextFromElement(requiredField);
    }

    public String incorrectCred() {
        return getTextFromElement(incorrectCred);
    }

    public String incorrectCredMsg() {
        return getTextFromElement(incorrectCredMsg);
    }

    public String welcomeMessage() {
        return getTextFromElement(welcomeMessage);
    }
}

