package tests.demonopcommerce;

import base.CommonAPI;
import pages.dempnopcommerce.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestHomePage extends CommonAPI {
    Logger log = LogManager.getLogger(TestHomePage.class.getName());

    @Test
    public void returnToHomePageClickingOnWebsiteLogoImageTest () throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(3000);
        homePage.clickOnRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, "nopCommerce demo store. Register");
        log.info("land on registration page validation success");
        Thread.sleep(3000);
        homePage.clickOnNopCommerceLogo();
        Thread.sleep(3000);
        String homePageTitle = getCurrentTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        log.info("Returning to homme page validation success");


    }


}