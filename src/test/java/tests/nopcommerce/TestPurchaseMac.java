package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPurchaseMac extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestPurchaseMac.class.getName());
    Faker fakeData = new Faker();
    String Password = fakeData.internet().password();
    String emailAddress = fakeData.internet().emailAddress();
    String confirmPassword = Password = fakeData.internet().password();
    String City = fakeData.address().city();
    String hommeAdress = fakeData.address().fullAddress();
    String ZipCode = fakeData.address().zipCode();
    String PhoneNumber = fakeData.phoneNumber().cellPhone();
    String Cardholdername = fakeData.name().fullName();
    String cardNumber = fakeData.finance().creditCard();
    String cardCode = fakeData.numerify("###");

    @Test

    public void PurchaseMacBook ()  {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title"+ actualHomePageTitle);
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
        LoginPage loginPage= new LoginPage(getDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.clickOnLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.typeEmailAddress(emailAddress);
        loginPage.typePassword(Password);
        loginPage.checkRememberMeButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.clickOnLOGINButton();
        String item = "MacBook";
        homepage.searchItem(item);
        PurchaseMacPage macpage= new PurchaseMacPage(getDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        macpage.clickOnAddToCartButton();
        macpage.AddMinimumtoCart();
        HomePage shoppingCart = new HomePage(getDriver());
        shoppingCart.clickOnShoppingCart();
        PurchaseMacPage agree = new PurchaseMacPage(getDriver());
        agree.clickOnIagreeButton();
        PurchaseMacPage checkout = new PurchaseMacPage(getDriver());
        checkout.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        CheckoutPage check= new CheckoutPage(getDriver());
        check.selectOptionFromMenuDropdown("");
        check.typeCity(City);
        check.typeAdress1(hommeAdress);
        check.typeZipCode(ZipCode);
        check.typePhoneNUmber(PhoneNumber);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        check.cLickOnContinueButton();
        check.checkNextDayAirButton();
        check.cLickOnShippingContinueButton();
        check.checkPayByCreditButton();
        check.clickPayContinueButton();
        check.selectCardTypeFromMenuDropdown("");
        check.typeCardHolderName(Cardholdername);
        check.typeCardNumber(cardNumber);
        check.typeExpMonth("");
        check.typeExpYear("");
        check.typeCardCode(cardCode);
        check.clickonContinueStepButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        check.cLickOnConFirmButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String orderplaced= check.OrdersuccessMessage();
        Assert.assertEquals(orderplaced, "Your order has been successfully processed!");
        LOG.info("order has been successfully processed validation success");

    }


}
