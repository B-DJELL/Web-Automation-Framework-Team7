package tests.nopcommerce;

import base.CommonAPI;
import pages.nopcommerce.FollowUsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFollowUs extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestFollowUs.class.getName());

    @Test

    public void SubscribetoNopCommerceYoutubeChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnYoutubeLogo();
        LOG.info("land to nopcommerce Youtube Channel Signin To Your Youtube Account To Subscribe ");

    }

    @Test

    public void SubscribetoNopCommerceTwitterChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnTwitterLogo();
        LOG.info("land to nopcommerce Twitter Page Signin To Your Twitter Account To Subscribe ");

    }

    @Test

    public void SubscribetoNopCommerceFacebookChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnFacebookLogo();
        LOG.info("land to nopcommerce Facebook page Signin To Your Facebook Account To Subscribe ");

    }



}
