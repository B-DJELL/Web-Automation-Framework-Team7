package tests.freecrm;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.freecrm.AboutUsPage;
import pages.freecrm.LoginPage;
import pages.freecrm.MainPage;
import pages.freecrm.SignUpPage;
import utility.ReadFromExcel;

import java.io.File;

public class SignUpTest extends CommonAPI {
    MainPage mainPage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    AboutUsPage aboutUsPage;
    Faker faker;

    //SignUpFromMainPage
    @Test(enabled = false)
    public void SignUp(){
        mainPage=new MainPage(driver);
        signUpPage=new SignUpPage(driver);
        faker=new Faker();
        String RandomEmail=faker.internet().emailAddress();


        mainPage.clickOnSignUp();
        signUpPage.typeEmail(RandomEmail);
        signUpPage.agreeTerms();
        driver.switchTo().frame(0);
        signUpPage.notRobotCheckBox();
    }

    //SignUp from login page
    @Test
    public void SignUpFromLoginPage() throws InterruptedException {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        signUpPage=new SignUpPage(driver);
        faker=new Faker();

        String RandomEmail=faker.internet().emailAddress();
//        mainPage.clickOnLogin();
        loginPage.signUp();
        signUpPage.typeEmail(RandomEmail);
        signUpPage.agreeTerms();
        driver.switchTo().frame(0);
        signUpPage.notRobotCheckBox();
    }

    //Sign Up from About Page
    @Test(enabled = false)
    public void SignUpFromAboutPage(){
        mainPage=new MainPage(driver);
        aboutUsPage=new AboutUsPage(driver);
        signUpPage=new SignUpPage(driver);
        faker=new Faker();

        String RandomEmail=faker.internet().emailAddress();
        mainPage.clickOnAboutBtn();
        aboutUsPage.SignUp();
        signUpPage.typeEmail(RandomEmail);
        signUpPage.agreeTerms();
        driver.switchTo().frame(0);
        signUpPage.notRobotCheckBox();
    }
}
