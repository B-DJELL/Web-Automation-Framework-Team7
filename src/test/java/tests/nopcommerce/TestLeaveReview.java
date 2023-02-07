package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.RegistrationPage;
import pages.nopcommerce.ReviewPage;

public class TestLeaveReview extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestLeaveReview.class.getName());
    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();
    @Test
    public void WebsiteReview () throws InterruptedException{
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
        ReviewPage review= new ReviewPage(getDriver());
        review.ClickOnPollAnswer();
        review.ClickOnVotePollButton();
        String homePageTitle = getCurrentTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");



    }





































}
