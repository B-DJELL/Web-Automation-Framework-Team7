package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.LoginPage;
import pages.nopcommerce.PurchaseMacPage;
import pages.nopcommerce.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPurchaseMac extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestPurchaseMac.class.getName());
    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();
    @Test
    public void RegistrationValidCred() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(1000);
        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnRegister();
        Thread.sleep(2000);
        RegistrationPage registerPage = new RegistrationPage(getDriver());
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
        Thread.sleep(1000);
        registerPage.ClickContinueButtonAfterRegistrationSuccess();
        Thread.sleep(1000);
    }

    @Test   (dependsOnMethods = {"RegistrationValidCred"})
    public void LoginWithValidCredentials () throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(2000);
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.clickOnLogin();
        Thread.sleep(2000);
        loginPage.typeEmailAddress(emailAddress);
        Thread.sleep(1000);
        loginPage.typePassword(Password);
        Thread.sleep(1000);
        loginPage.checkRememberMeButton();
        Thread.sleep(2000);
        loginPage.clickOnLOGINButton();
        Thread.sleep(2000);
        String loginPageTitle = getCurrentTitle();
        Assert.assertEquals(loginPageTitle, "nopCommerce demo store");
        LOG.info("login title page validation success");
        Thread.sleep(2000);


    }

    @Test   (dependsOnMethods = {"LoginWithValidCredentials"})

    public void PurchaseMacBook () throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title"+ actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLogin();
        Thread.sleep(2000);
        loginPage.typeEmailAddress(emailAddress);
        Thread.sleep(2000);
        loginPage.typePassword(Password);
        Thread.sleep(2000);
        String item = "MacBook";
        HomePage homepage = new HomePage(getDriver());
        homepage.searchItem(item);
        Thread.sleep(3000);

        //add to cart
        PurchaseMacPage macpage= new PurchaseMacPage(getDriver());
        macpage.clickOnAddToCartButton();
        Thread.sleep(3000);

        //confirm minimum quantity
         macpage.AddMinimumtoCart();

        Thread.sleep(3000);
        //click on cart
        HomePage shoppingCart = new HomePage(getDriver());
        shoppingCart.clickOnShoppingCart();

        Thread.sleep(2000);
        //Agree with terms
        PurchaseMacPage agree = new PurchaseMacPage(getDriver());
        agree.clickOnIagreeButton();
        Thread.sleep(2000);

        //proceed to checkout
        PurchaseMacPage checkout = new PurchaseMacPage(getDriver());
        checkout.clickOnCheckoutButton();
        Thread.sleep(5000);
       ////////////////////////////////////

//        String loginPageTitle = getCurrentTitle();
//        Assert.assertEquals(loginPageTitle, "nopCommerce demo store. Login");
//        LOG.info("login title page validation success");
//        Thread.sleep(1000);
    }











}
