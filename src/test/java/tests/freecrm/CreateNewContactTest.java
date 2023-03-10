package tests.freecrm;

import base.CommonAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import java.io.*;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.util.Properties;

public class CreateNewContactTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    CreateNewContactPage createNewContactPage;

    String expectedCreateContactPageTitle="Cogmento CRM";

    //Read from Excel sheet
//    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
//    ReadFromExcel read = new ReadFromExcel(path, "Yaser");
//    String email = read.getDataFromCell(1, 1);
//    String password = read.getDataFromCell(2, 1);

    String PageTitle = "Cogmento CRM";
    String ErrorMessage = "Something went wrong...";

    //Read from Data Base:
	Properties prop = new Properties();
    InputStream ism;
    {
        try {
            ism = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Create an account from the contacts page after clicking on contacts:
    @Test
    public void addContactFromContactsPage() throws InterruptedException {
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
        driver.navigate().refresh();
        createNewContactPage.createNewContact(ftName,ltName);
        createNewContactPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create an account from the contacts page after clicking on contacts failed");
    }

    //Create an account from Main Menu (after hovering over the menu logo) :
    @Test
    public void addContactFromMenu() throws InterruptedException {
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
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().refresh();
        createNewContactPage.createNewContact(ftName,ltName);
        createNewContactPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create an account from Main Menu (after hovering over the menu logo) failed");
    }
}
