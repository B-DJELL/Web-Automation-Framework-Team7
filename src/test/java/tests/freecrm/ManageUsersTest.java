package tests.freecrm;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import utility.ReadFromExcel;
import java.io.File;

public class ManageUsersTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountSettingsPage accountSettingsPage;
    UserManagerPage userManagerPage;
    NewUserManagerPage newUserManagerPage=new NewUserManagerPage(driver);
    Faker faker= new Faker();

    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    String expectedCreateContactPageTitle="Cogmento CRM";

    String ftName=newUserManagerPage.randomeString();
    String ltName=newUserManagerPage.randomeString();
    String RandomEmail=faker.internet().emailAddress();

    //Add User Test:
    @Test
    public void addUserTest() throws InterruptedException {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        userManagerPage=new UserManagerPage(driver);
        newUserManagerPage=new NewUserManagerPage(driver);

        String ftName=newUserManagerPage.randomeString();
        String ltName=newUserManagerPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email, password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnSubSettingIcon();
        accountSettingsPage.clickOnUserManagerButton();
        userManagerPage.clickOnAddUserButton();
        driver.navigate().refresh();
        driver.navigate().refresh();
        newUserManagerPage.createNewUser(ftName,ltName, RandomEmail,password);

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create a new user failed");

    }

    //Use the default group setup:
    @Test
    public void defaultGroupSetup()  {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        userManagerPage=new UserManagerPage(driver);
        newUserManagerPage=new NewUserManagerPage(driver);

//        mainPage.clickOnLogin();
        loginPage.logIn(email, password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnSubSettingIcon();
        accountSettingsPage.clickOnUserManagerButton();
        userManagerPage.clickOnAddUserButton();
        newUserManagerPage.clickOnGroupsButton();
        newUserManagerPage.clickOnDefaultSetupButton();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Create a new user failed");
    }

    //Select Permission Test:
    @Test
    public void selectPermission()  {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        userManagerPage=new UserManagerPage(driver);
        newUserManagerPage=new NewUserManagerPage(driver);

        String ftName=newUserManagerPage.randomeString();
        String ltName=newUserManagerPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email, password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnSubSettingIcon();
        accountSettingsPage.clickOnUserManagerButton();
        userManagerPage.clickOnAddUserButton();
        newUserManagerPage.clickOnPermissionButton();
        String PermissionTextMessage="Permissions marked with an * are implied by being assigned a group that contains them. You cannot modify those permissions while the group is selected.";
        Assert.assertEquals(newUserManagerPage.getTextFromPermissionPage(),PermissionTextMessage);
    }
}
