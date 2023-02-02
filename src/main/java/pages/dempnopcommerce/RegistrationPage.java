package pages.dempnopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(RegistrationPage.class.getName());

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement Gender;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Newsletter']")
    WebElement signUpForNewsLetter;

    @FindBy(xpath = "(//input[@id='Password'])[1]")
    WebElement passWord;

    @FindBy(xpath = "(//input[@id='ConfirmPassword'])[1]")
    WebElement passwordconfirmation;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement Register;

    @FindBy(xpath = "(//div[@class='result'])[1]")
    WebElement RegistrationCompleted;

    @FindBy(css = ".button-1.register-continue-button")
    WebElement ContinueButton;

//REUSABLE STEPS


    public void chooseGender(){
        clickOn(Gender);
        LOG.info("Gender selected successfully");
    }


    public void typeFirstName(){
        type(firstName,"mick");
        LOG.info("first name typed successfully");
    }

    public void typeLastName(){
        type(lastName,"jonson");
        LOG.info("last name typed successfully");
    }



    public void typeEmailAddress(String emailAddress){
        type(email, emailAddress);
        LOG.info("type email address success");
    }
//    public void email(){
//        type(email,"tester13@gmail.com");
//        LOG.info("writing email success");
//    }

    public void signUpForNewsLetter(){
        clickOn(signUpForNewsLetter);
        LOG.info("sign up for news letter successfully");
    }


    public void typePassword(String  Password){
        type(passWord, Password);
        LOG.info("type password success");
    }


//    public void typePassword(){
//        type(password,"141414");
//        LOG.info("password typed successfully");
//    }

    public void confirmpassword(String confipass){
        type(passwordconfirmation, confipass );
        LOG.info("password confirmation typed successfully");
    }
    public void RegisterAccount(){
        clickOn(Register);
        LOG.info("click on Register successfully");
    }
    public void ClickContinueButtonAfterRegistrationSuccess(){
        clickOn(ContinueButton);
        LOG.info("landing to home page success");
    }

}