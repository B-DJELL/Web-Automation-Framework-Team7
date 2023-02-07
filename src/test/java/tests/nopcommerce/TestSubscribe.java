package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.SubscribePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class TestSubscribe extends CommonAPI {

        Logger LOG = LogManager.getLogger(TestSubscribe.class.getName());
        Faker fakeData = new Faker();
        String TypeEmail = fakeData.internet().emailAddress();
        @Test

        public void ValidateNewsLatterSubscreption() throws InterruptedException {
            String actualHomePageTitle = getCurrentTitle();
            String expectedHomePageTitle = "nopCommerce demo store";
            LOG.info("actual home page title" + actualHomePageTitle);
            Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
            LOG.info("land to nopcommerce home page success");
            HomePage homepage= new HomePage(getDriver());
            homepage.EnterYourEmail(TypeEmail);
            LOG.info("Email was entred Successfully");
            homepage.clickOnSubscribeButton();
            LOG.info("Click on Subscribe Button success");
            Thread.sleep(2000);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            SubscribePage subscribePage= new SubscribePage(getDriver());
            String SubscribeSuccess= subscribePage.getsubscribeToNewsLetterMessage();
            Assert.assertEquals(SubscribeSuccess, "Thank you for signing up! A verification email has been sent. We appreciate your interest.");
            LOG.info("Subscribe to NewsLetter message success");



        }



    }
