package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.ApplyForVendorPage;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.LoginPage;
import pages.nopcommerce.RegistrationPage;

public class TestApplyForVendor extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestApplyForVendor.class.getName());

    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();


    @Test
    public void ApplyForVendorWithValidCredentials() throws InterruptedException {
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
        loginPage.typeEmailAddress(emailAddress);
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        loginPage.clickOnLOGINButton();
        String loginPageTitle = getCurrentTitle();
        Assert.assertEquals(loginPageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");
        ApplyForVendorPage apply = new ApplyForVendorPage(getDriver());
        Thread.sleep(2000);
        apply.clickOnVendorACCButton();
        Thread.sleep(2000);
        apply.typeVendorName();
        apply.typeVendorDescreption();
        apply.clickOnSubmitButton();
        Thread.sleep(2000);
        String Appsubmitted= apply.RequestSubmitted();
        Assert.assertEquals(Appsubmitted, "Your request has been submitted successfully. We'll contact you soon.");
        LOG.info("Your request has been submitted validation success");


    }


}
