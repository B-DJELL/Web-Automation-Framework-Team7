package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.LoginPage;
import pages.nopcommerce.LogoutPage;
import pages.nopcommerce.RegistrationPage;

import java.time.Duration;

public class TestLogout extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestLogout.class.getName());
    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();
    @Test
    public void Logout ()  {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginPage.clickOnLOGINButton();
        LogoutPage logout = new LogoutPage(getDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        logout.ClickOnLogoutButton();
        String loginPageTitle = getCurrentTitle();
        Assert.assertEquals(loginPageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");

    }

}
