package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.EmailSelectedItemToFriendPage;
import pages.nopcommerce.HomePage;



public class TestEmailSelectedITemToFriend extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestEmailSelectedITemToFriend.class.getName());
    Faker fakeData = new Faker();
    String emailAddress = fakeData.internet().emailAddress();
    String yourEmailAddress = fakeData.internet().emailAddress();
    @Test
    public void EmailSelectedItemToFriend () throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage currency = new HomePage(getDriver());
        currency.selectCurrency("Euro");
        LOG.info("Currency Was Changed From USD To EURO Successfully");
        currency.hoverOverFloatingMenu(driver);
        currency.clickOnclothingButton();
        currency.clickOnLevisLinkButton();
        currency.TypeQts();
        String ActualPrice = currency.getactuelPrice();
        Assert.assertEquals(ActualPrice, "€37.41");
        LOG.info("Item price in Euro validation success");
        EmailSelectedItemToFriendPage send= new EmailSelectedItemToFriendPage(getDriver());
        send.cLickOnEmailFriend();
        send.typeEmailFriendAddress(emailAddress);
        send.typeYourEmailAddress(yourEmailAddress);
        send.cLickOnSendEmail();
        String EmailItemToFriendError = send.emailItemError();
        Assert.assertEquals( EmailItemToFriendError, "Only registered customers can use email a friend feature");
        LOG.info("Only registered customers can use email a friend feature validation success");



    }


}
