package tests.nopcommerce;

import base.CommonAPI;
import com.github.javafaker.Faker;
import pages.nopcommerce.ContactUsPage;
import pages.nopcommerce.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestContactUs.class.getName());

    Faker fakeData = new Faker();
    String fullName = fakeData.name().fullName();
    String email = fakeData.internet().emailAddress();
    String msg = fakeData.letterify("I need some details about MacBook Minimum quantity .");

    @Test
    public void contactUsTestSucsess() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage contact = new HomePage(getDriver());
        contact.clickOnContactUsButton();
        LOG.info("Click on contact Us Button success");
        ContactUsPage contactUs = new ContactUsPage(getDriver());
        contactUs.contactUsSendEnquiryProcess(fullName, email, msg);
        LOG.info("Query was Sent  successfully");
        Assert.assertTrue(contactUs.enquirySent.getText().contains("successfully"));
        ContactUsPage enQuiry = new ContactUsPage(getDriver());
        String enquirySent = enQuiry.getQuerySentMessage();
        Assert.assertEquals(enquirySent, "Your enquiry has been successfully sent to the store owner.");
        LOG.info("enquiry message validation success");
    }

}
