package tests.demonopcommerce;

import base.CommonAPI;
import pages.dempnopcommerce.FollowUsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFollowUsPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestFollowUsPage.class.getName());

    @Test

    public void SubscribetoNopCommerceYoutubeChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(2000);
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnYoutubeLogo();
        Thread.sleep(3000);
        LOG.info("land to nopcommerce Youtube Channel Signin To Your Youtube Account To Subscribe ");
        Thread.sleep(3000);
//        follow.ClickOnSubscribeButtonInYoutube();
//        Thread.sleep(2000);
    }

    @Test

    public void SubscribetoNopCommerceTwitterChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(2000);
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnTwitterLogo();
        Thread.sleep(3000);
        LOG.info("land to nopcommerce Twitter Page Signin To Your Twitter Account To Subscribe ");
        Thread.sleep(3000);

    }

    @Test

    public void SubscribetoNopCommerceFacebookChannel() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        Thread.sleep(2000);
        FollowUsPage follow = new FollowUsPage(getDriver());
        follow.ClickOnFacebookLogo();
        Thread.sleep(3000);
        LOG.info("land to nopcommerce Facebook page Signin To Your Facebook Account To Subscribe ");
        Thread.sleep(3000);

    }



}
