package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends CommonAPI {
	public ContactsPage(WebDriver driver) {PageFactory.initElements(driver, this);}
	Logger log = LogManager.getLogger(ContactsPage.class.getName());

	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement contactsLabel;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement createContactButton;

	@FindBy(xpath ="//tbody/tr[1]/td[8]/div[1]/button[1]/i[1]")
	WebElement DeleteContactButton;

	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}

	public void clickOnCreateContactButton(){
		clickOn(createContactButton);
		log.info("Click on Create Contacts Button Success");
	}

	public void clickOnDeleteContactButton(){
		clickOn(DeleteContactButton);
	}


	
//	public void selectContactsByName(String name){
//		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
//				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
//	}


}