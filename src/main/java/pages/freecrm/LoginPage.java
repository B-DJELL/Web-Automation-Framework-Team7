package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends CommonAPI {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	Logger log = LogManager.getLogger(HomePage.class.getName());

	@FindBy(name="email")
	WebElement emailAddress;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	WebElement forgotPassword;

	@FindBy(xpath = "//div[@class='header']")
	WebElement errorMessage;
	
	//Actions:

	public void logIn (String email, String password){
		type(emailAddress,email);
		type(passWord,password);

		clickOn(loginBtn);
		log.info("Email and Password typed successfully, log in button clicked");
	}

	public void signUp(){
		clickOn(signUpBtn);
		log.info("click on sign up button success");
	}

	public void forgetPassword(){
		clickOn(forgotPassword);
		log.info("click on forget password button success");
	}

	public String getErrorMessage(){
		return errorMessage.getText();
	}

}
