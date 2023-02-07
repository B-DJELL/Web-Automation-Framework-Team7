package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import utility.ReadFromExcel;

import java.io.File;

public class AccountsTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountSettingsPage accountSettingsPage;
    AccountsPage accountsPage;

    String CompanyName="pnt";

    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    String expectedCreateContactPageTitle="Cogmento CRM";

    @Test
    public void accountManageTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        accountsPage=new AccountsPage(driver);

        //mainPage.clickOnLogin();
        loginPage.logIn(email, password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnSubSettingIcon();
        accountSettingsPage.clickOnAccountButton();
        accountsPage.fillUpCompanyNameField(CompanyName);
        accountsPage.clickOnSaveButton();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create account failed");
    }

}
