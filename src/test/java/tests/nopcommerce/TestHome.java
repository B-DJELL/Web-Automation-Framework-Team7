package tests.nopcommerce;

import base.CommonAPI;
import pages.nopcommerce.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestHome extends CommonAPI {
    Logger log = LogManager.getLogger(TestHome.class.getName());

    @Test
    public void returnToHomePageClickingOnWebsiteLogoImageTest () throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());

        homePage.clickOnRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, "nopCommerce demo store. Register");
        log.info("land on registration page validation success");
        homePage.clickOnNopCommerceLogo();
        String homePageTitle = getCurrentTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        log.info("Returning to homme page validation success");


    }


}