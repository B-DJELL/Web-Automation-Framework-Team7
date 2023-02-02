package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegistration extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestRegistration.class.getName());
    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();
    @Test
    public void RegistrationValidCred() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title"+ actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(3000);
        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnRegister();
        Thread.sleep(2000);
        RegistrationPage registerPage= new RegistrationPage(getDriver());
        registerPage.chooseGender();
        Thread.sleep(2000);
        registerPage.typeFirstName();
        Thread.sleep(2000);
        registerPage.typeLastName();
        Thread.sleep(2000);
        registerPage.signUpForNewsLetter();
        Thread.sleep(2000);
        registerPage.typeEmailAddress(emailAddress);
        Thread.sleep(2000);
        registerPage.typePassword(Password);
        Thread.sleep(2000);
        registerPage.confirmpassword(confirmPassword);
        Thread.sleep(2000);
        registerPage.RegisterAccount();
        Thread.sleep(3000);
        registerPage.ClickContinueButtonAfterRegistrationSuccess();
        Thread.sleep(3000);
        String homePageTitle = getCurrentTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");
    }
}