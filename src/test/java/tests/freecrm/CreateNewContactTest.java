package tests.freecrm;

import base.CommonAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import java.io.*;
import utility.ConnectDB;
import java.util.Properties;

public class CreateNewContactTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    CreateNewContactPage createNewContactPage;

    String expectedCreateContactPageTitle="Cogmento CRM";

    //Read from Data Base:
	Properties prop = new Properties();
    InputStream ism;
    {
        try {
            ism = new FileInputStream("D:\\IdealProjects\\Web-Automation-Framework-Team7\\src\\test\\resources\\freecrmconfig.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Create an account from the contacts page after clicking on contacts:
    @Test
    public void addContactFromContactsPage() {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        contactsPage=new ContactsPage(driver);
        createNewContactPage=new CreateNewContactPage(driver);
        try {
            prop.load(ism);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Login Credentials retreived from db:
        String email = ConnectDB.getTableColumnData("select * from cred","v").get(0);
        String password = ConnectDB.getTableColumnData("select * from cred","v").get(1);

        //Adding contact with random name using Random String method:
        String ftName=createNewContactPage.randomeString();
        String ltName=createNewContactPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.clickOnContactsLink(driver);
        contactsPage.clickOnCreateContactButton();
        driver.navigate().refresh();
        driver.navigate().refresh();
        createNewContactPage.createNewContact(ftName,ltName);
        createNewContactPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create an account from the contacts page after clicking on contacts failed");
    }

    //Create an account from Main Menu (after hovering over the menu logo) :
    @Test(enabled = true)
    public void addContactFromMenu() {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        createNewContactPage=new CreateNewContactPage(driver);

        try {
            prop.load(ism);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String email = ConnectDB.getTableColumnData("select * from cred","v").get(0);
        String password = ConnectDB.getTableColumnData("select * from cred","v").get(1);

        String ftName=createNewContactPage.randomeString();
        String ltName=createNewContactPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.addContactAfterHover(driver);
        driver.navigate().refresh();
        createNewContactPage.createNewContact(ftName,ltName);
        createNewContactPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create an account from Main Menu (after hovering over the menu logo) failed");
    }
}
