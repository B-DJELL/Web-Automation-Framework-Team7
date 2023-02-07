package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.LoginPage;
import pages.nopcommerce.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.io.File;
import java.time.Duration;

public class TestLogin extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String InvalidemailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();


    @Test
    public void LoginWithValidCredentials() {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnRegister();
        RegistrationPage registerPage = new RegistrationPage(getDriver());
        registerPage.chooseGender();
        registerPage.typeFirstName();
        registerPage.typeLastName();
        registerPage.signUpForNewsLetter();
        registerPage.typeEmailAddress(emailAddress);
        registerPage.typePassword(Password);
        registerPage.confirmpassword(confirmPassword);
        registerPage.RegisterAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.typeEmailAddress(emailAddress);
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        loginPage.clickOnLOGINButton();
        String loginPageTitle = getCurrentTitle();
        Assert.assertEquals(loginPageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");


    }

    @Test
    public void LoginWithInvalidValidEmailAdress() {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLogin();
        loginPage.typeEmailAddress(InvalidemailAddress);
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        loginPage.clickOnLOGINButton();
        String LoginError = loginPage.unsuccessfulLogin();
        Assert.assertEquals(LoginError, "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
        LOG.info("Failed Login message validation success");

    }

    @Test

    public void LoginReadingDataFromExcel() {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLogin();


        // Read from Excel File sheet

        String path = System.getProperty("user.dir") + File.separator + "data" + File.separator +"nopcommerce" + File.separator + "titles.xlsx";
        ReadFromExcel readFromExcel = new ReadFromExcel(path,"Bhd");
        String Email = readFromExcel.getCellValueForGivenHeaderAndKey("key","email");
        loginPage.typeEmailAddress(Email);
        String Password = readFromExcel.getCellValueForGivenHeaderAndKey("key","password");
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        loginPage.clickOnLOGINButton();
        String LoginError = loginPage.unsuccessfulLogin();
        Assert.assertEquals(LoginError, "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
        LOG.info("Failed Login message validation success");


    }

    @Test

    public void LoginReadingDataFromDataBase() {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLogin();
        // Read from MYSQL Data Base

        String email = ConnectDB.getTableColumnData("select * from user","email").get(0);
        String Password = ConnectDB.getTableColumnData("select * from user","Password").get(0);
        loginPage.typeEmailAddress(email);
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        loginPage.clickOnLOGINButton();
        String LoginError = loginPage.unsuccessfulLogin();
        Assert.assertEquals(LoginError, "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
        LOG.info("Failed Login message validation success");


    }




}




