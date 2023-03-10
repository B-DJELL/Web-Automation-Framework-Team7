package tests.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.MyAccount;
import pages.magento.SignInPage;
import pages.magento.SignOutPage;

public class SignOut extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());
//    Faker fakeData = new Faker();
//    String emailAddress = fakeData.internet().emailAddress();
//    String password = fakeData.internet().password();
    @Test
    public void signOut() throws InterruptedException {
        HomePage homePage=new HomePage(getDriver());
        homePage.clickOnSignInButton();
        SignInPage signInPage=new SignInPage(getDriver());
        String emailAddress="leghzali@gmail.com";
        signInPage.typeEmailAddress(emailAddress);
        String password="@ISMAIL@leghzali@";
        signInPage.password(password);
        signInPage.SignInButton2();

        MyAccount myAccount=new MyAccount(getDriver());
        myAccount.arrow();

        SignOutPage signOutPage=new SignOutPage(getDriver());
        signOutPage.signOut();

        String signOutMessage="You are signed out";
        Assert.assertEquals(signOutMessage,"You are signed out");
        LOG.info("sign out success");


    }

    }
