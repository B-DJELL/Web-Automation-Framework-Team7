package tests.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.PurchasePage;
import pages.magento.SearchPage;
import pages.magento.SignInPage;

public class PurchaseTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(PurchaseTest.class.getName());

  @Test // purchase item
    public void purchaseHoodie() throws InterruptedException {
    String item="hoodie";
    HomePage homePage=new HomePage(getDriver());
    SearchPage searchPage=new SearchPage(getDriver());
    homePage.typeAndClickItemToSearch(item);

    String title= getCurrentTitle();
    Assert.assertEquals(title,"Search results for: 'hoodie' Magento Commerce - website to practice selenium |" +
            " demo website for automation testing | selenium practice sites");
    LOG.info("land to search hoodie page");

    searchPage.clickOnHoodiePicture();
    String hoodieTitle= getCurrentTitle();
    Assert.assertEquals(hoodieTitle,"Bruno Compete Hoodie Magento Commerce - website to practice selenium | " +
            "demo website for automation testing | selenium practice sites");

    PurchasePage purchasePage = new PurchasePage(getDriver());
    purchasePage.clickOnSize();

    purchasePage.ChooseColor();
    purchasePage.typeOnQuantity();

    purchasePage.addItemToCart2();
    homePage.clickOnCartLink();
    String aadToCart="You added Bruno Compete Hoodie to your shopping cart.";
    Assert.assertEquals(aadToCart,"You added Bruno Compete Hoodie to your shopping cart.");
    }
    @Test //wish list
  public void wishList() throws InterruptedException {
    HomePage homePage=new HomePage(getDriver());
    String itemE="Cronus Yoga Pant";
    homePage.typeAndClickItemToSearch(itemE);
    PurchasePage purchasePage=new PurchasePage(getDriver());
    purchasePage.yogaClothes();
    purchasePage.clickOnWish();
    String message="You must login or register to add items to your wishlist.";
    Assert.assertEquals(message,"You must login or register to add items to your wishlist.");
        LOG.info("message as expected");
      SignInPage signInPage=new SignInPage(getDriver());
      String email="leghzali@gmail.com";
      Thread.sleep(3000);
      signInPage.typeEmailAddress(email);
      String password="@ISMAIL@leghzali@";
      signInPage.password(password);
      signInPage.SignInButton2();

    }
    @Test //Add to compare
  public void addToCompare() throws InterruptedException {
      HomePage homePage=new HomePage(getDriver());
      String itemE="Cronus Yoga Pant";

      homePage.typeAndClickItemToSearch(itemE);
      PurchasePage purchasePage=new PurchasePage(getDriver());
      purchasePage.yogaClothes();
      purchasePage.clickOnCompare();
        String message="Harmony Lumaflex™ Strength Band Kit has been added to your Wish List. Click here to continue shopping.";
        Assert.assertEquals(message,"Harmony Lumaflex™ Strength Band Kit has been added to your Wish List. Click here to continue shopping.");
        LOG.info("land compare page as expected");
    }
  @Test
  public void reviewItems() throws InterruptedException {
    String item="hoodie";
    HomePage homePage=new HomePage(getDriver());
    SearchPage searchPage=new SearchPage(getDriver());
    homePage.typeAndClickItemToSearch(item);
    searchPage.clickOnHoodiePicture();
    PurchasePage purchasePage=new PurchasePage(getDriver());
    purchasePage.reviewItem();

//    purchasePage.rating();
    purchasePage.reviewerName();
    purchasePage.reviewerSumm();
    purchasePage.review();
    purchasePage.submitReview();
    String message="You submitted your review for moderation.";
    Assert.assertEquals(message,"You submitted your review for moderation.");
    LOG.info("review submitted");
  }
}
