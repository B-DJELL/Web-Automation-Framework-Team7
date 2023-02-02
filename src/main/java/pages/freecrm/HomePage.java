package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;


    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    public WebElement loginButton;


    @FindBy(xpath = "//div[@class='ui negative message']/div")
    public WebElement invalidLogin;





    public void typeEmailAddress(String EmailAddress) {
        type(emailField, EmailAddress);
        LOG.info("");

    }


    public void typePassword(String Password) {
        type(passwordField, Password);
        LOG.info("");

    }


    public void clickOnLogin() {
        clickOn(loginButton);
    }


    public String getErrorLogin() {
        return getTextFromElement(invalidLogin);


    }



    }







