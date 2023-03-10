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
    String InvalidPassword = fakeData.internet().password();
    @Test
    public void RegistrationValidCred()  {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title"+ actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnRegister();
        RegistrationPage registerPage= new RegistrationPage(getDriver());
        registerPage.chooseGender();
        registerPage.typeFirstName();
        registerPage.typeLastName();
        registerPage.signUpForNewsLetter();
        registerPage.typeEmailAddress(emailAddress);
        registerPage.typePassword(Password);
        registerPage.confirmpassword(confirmPassword);
        registerPage.RegisterAccount();
        registerPage.ClickContinueButtonAfterRegistrationSuccess();
        String homePageTitle = getCurrentTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");
    }

    @Test
    public void RegistrationwithInvaliCredentials() {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title"+ actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnRegister();
        RegistrationPage registerPage= new RegistrationPage(getDriver());
        registerPage.chooseGender();
        registerPage.typeFirstName();
        registerPage.typeLastName();
        registerPage.signUpForNewsLetter();
        registerPage.typeEmailAddress(emailAddress);
        registerPage.typePassword(Password);
        registerPage.InvalidPasswordConfirmation(InvalidPassword );
        registerPage.RegisterAccount();
        String registreationError = registerPage.getPasswordDoNotMatchMessage();
        Assert.assertEquals( registreationError, "The password and confirmation password do not match.");
        LOG.info("Confirmation password Do not match validation success");

    }



}