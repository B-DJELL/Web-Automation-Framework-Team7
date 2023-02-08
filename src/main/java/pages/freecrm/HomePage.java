package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends CommonAPI {
	public HomePage(WebDriver driver) {PageFactory.initElements(driver, this);}
	Logger log = LogManager.getLogger(HomePage.class.getName());

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;

	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//i[@class='money icon']")
	WebElement dealsLink;

	@FindBy(xpath = "//i[@class='tasks icon']")
	WebElement tasksLink;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[3]/button[1]/i[1]")
	WebElement addContact;

	@FindBy(xpath = "//div[5]//button[1]//i[1]")
	WebElement addDeal;

	@FindBy(xpath = "//i[@class='settings icon']")
	WebElement settingsIcon;

	@FindBy(xpath ="//div[@class='ui buttons']//a[1]")
	WebElement subSettingsIcon;

	@FindBy(xpath = "//span[normalize-space()='Products']")
	WebElement productsButton;

	@FindBy(xpath = "//span[normalize-space()='Log Out']")
	WebElement logoutBtn;



	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName(){return userNameLabel.isDisplayed();}

//	public ContactsPage clickOnContactsLink(){
//		clickOn(contactsLink);
//		return new ContactsPage();
//	}

	public void clickOnContactsLink(WebDriver driver){
		hoverOver(driver,contactsLink);
		clickOn(contactsLink);
		log.info("click On Contacts Link Success");
	}

	public void clickOnDealsLink(WebDriver driver){
		hoverOver(driver,dealsLink);
		clickOn(dealsLink);
		log.info("click On Deals Link Success");
	}
	
	public TasksPage clickOnTasksLink(){
		clickOn(tasksLink);
		return new TasksPage(driver);
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

	public String getUserName(){
		return userNameLabel.getText();
	}

	public void addContactAfterHover(WebDriver driver){
		hoverOver(driver,contactsLink);
		clickOn(addContact);
	}

	public void addDealAfterHover(WebDriver driver){
		hoverOver(driver,dealsLink);
		clickOn(addDeal);
	}

	public void clickOnSettingsIcon(){
		clickOn(settingsIcon);
	}

	public void clickOnSubSettingIcon(){
		clickOn(subSettingsIcon);
	}

	public void clickOnProductsButton(){
		clickOn(productsButton);
	}

	public void clickOnLogoutButton(){
		clickOn(logoutBtn);
	}

}
