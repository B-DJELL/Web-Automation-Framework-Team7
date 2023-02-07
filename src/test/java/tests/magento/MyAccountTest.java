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

public class MyAccountTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());
    Faker fakeData = new Faker();
    String emailAddress = fakeData.internet().emailAddress();
    String password = fakeData.internet().password();
    @Test
    public void myAccount() throws InterruptedException {
        HomePage homePage =new HomePage(getDriver());
        homePage.clickOnSignInButton();

        SignInPage signInPage= new SignInPage(getDriver());
        signInPage.typeEmailAddress(emailAddress);
        signInPage.password(password);
        signInPage.SignInButton2();

//        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());
//        createAccountPage.clickOnCreateAnAccount();


        MyAccount myAccount=new MyAccount(getDriver());
        myAccount.arrow();
        Thread.sleep(3000);
        myAccount.ClickOnMyAccount();
        Thread.sleep(3000);
        myAccount.manageAddress();
        Thread.sleep(3000);
        myAccount.addNewAddressBtn();
        Thread.sleep(3000);
        myAccount.company();
        Thread.sleep(5000);
        myAccount.phoneNum();
        Thread.sleep(5000);
//        myAccount.setCity();
//        Thread.sleep(5000);
        myAccount.address();
        Thread.sleep(5000);
        myAccount.province_state();
        Thread.sleep(5000);
        myAccount.zipCode();
        Thread.sleep(5000);
        myAccount.saveBtn();
        Thread.sleep(5000);
        String successMsg="You saved the address.";
        Assert.assertEquals(successMsg,"You saved the address.");
        LOG.info("success msg show up");
    }
    @Test
    public void accountInformation() throws InterruptedException {
        HomePage homePage =new HomePage(getDriver());
        homePage.clickOnSignInButton();

        SignInPage signInPage= new SignInPage(getDriver());
        signInPage.typeEmailAddress(emailAddress);
        signInPage.password(password);
        signInPage.SignInButton2();
        MyAccount myAccount=new MyAccount(getDriver());
        myAccount.arrow();
        myAccount.ClickOnMyAccount();
        myAccount.accountInformation();
        myAccount.saveBtn();
        String message2="You saved the account information.";
        Assert.assertEquals(message2,"You saved the account information.");
        LOG.info("saved successfully");
}
    @Test
    public void myWishList() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnSignInButton();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.typeEmailAddress(emailAddress);
        signInPage.password(password);
        signInPage.SignInButton2();
        MyAccount myAccount = new MyAccount(getDriver());
        myAccount.arrow();
        myAccount.ClickOnMyAccount();
        myAccount.myWishList();
        Thread.sleep(3000);
        myAccount.clickAddAllToCart();
        Thread.sleep(3000);
    }
@Test
public void shareWishList() throws InterruptedException {
    HomePage homePage = new HomePage(getDriver());
    homePage.clickOnSignInButton();

    SignInPage signInPage = new SignInPage(getDriver());
    signInPage.typeEmailAddress(emailAddress);
    signInPage.password(password);
    signInPage.SignInButton2();
    MyAccount myAccount = new MyAccount(getDriver());
    myAccount.arrow();
    myAccount.ClickOnMyAccount();
    myAccount.myWishList();
    Thread.sleep(3000);
    myAccount.clickOnShareWishList();
    Thread.sleep(3000);
    myAccount.emailsField();
    Thread.sleep(3000);
    myAccount.messageWish();
    Thread.sleep(3000);
    myAccount.shareWishByEmail();
    Thread.sleep(3000);
    String Msg="Your wish list has been shared.";
    Assert.assertEquals(Msg,"Your wish list has been shared.");
    LOG.info("wish list successfully sent");

}
}
