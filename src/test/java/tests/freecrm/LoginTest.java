//fix this code
package tests.freecrm;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.HomePage;
import pages.freecrm.LoginPage;
import pages.freecrm.MainPage;
import pages.freecrm.SignUpPage;
import utility.ReadFromExcel;

import java.io.File;
import java.time.Duration;

public class LoginTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    Faker faker;

    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    String PageTitle = "Cogmento CRM";
    String ErrorMessage = "Something went wrong...";


    //Log In test validation for valid credentials
    @Test(enabled = false)
    public void loginTest() {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);

//        mainPage.clickOnLogin();
//        Assert.assertEquals(getCurrentTitle(),PageTitle);
        loginPage.logIn(email, password);
        Assert.assertEquals(homePage.getUserName(),read.getDataFromCell(3,1));
    }

    //Log In test validation for Invalid credentials
    @Test(enabled = false)
    public void loginTestInvalid(){
        MainPage mainPage=new MainPage(driver);
        LoginPage loginPage=new LoginPage(driver);
        faker=new Faker();

        String InvalidEmail=faker.internet().emailAddress(), InvalidPassword = faker.internet().password();

//        mainPage.clickOnLogin();
//        Assert.assertEquals(getCurrentTitle(),PageTitle);
        loginPage.logIn(InvalidEmail,InvalidPassword);
        Assert.assertEquals(loginPage.getErrorMessage(),ErrorMessage);
    }
}
