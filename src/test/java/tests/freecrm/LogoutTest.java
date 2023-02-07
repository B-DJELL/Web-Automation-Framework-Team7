package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.HomePage;
import pages.freecrm.LoginPage;
import pages.freecrm.MainPage;
import utility.ReadFromExcel;

import java.io.File;

public class LogoutTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;

    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    @Test
    public void logoutTest(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

//        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnLogoutButton();
    }
}
