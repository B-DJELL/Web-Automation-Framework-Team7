package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import utility.ReadFromExcel;

import java.io.File;

public class DeleteContactTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    ConfirmDeletionPage confirmDeletionPage;

    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    String expectedContactPageTitle = "Cogmento CRM";

    @Test
    public void deleteContactTest() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        confirmDeletionPage = new ConfirmDeletionPage(driver);

//        mainPage.clickOnLogin();
        loginPage.logIn(email, password);
        homePage.clickOnContactsLink(driver);
        driver.navigate().refresh();
        driver.navigate().refresh();
        contactsPage.clickOnDeleteContactButton();
        confirmDeletionPage.clickOnDeleteButton();


        String actualTitle = getCurrentTitle();
        Assert.assertTrue(contactsPage.verifyContactsLabel());

    }
}
