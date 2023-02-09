package tests.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.SearchPage;

public class SearchBar extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());


//    @Test // testing the search bar
//    public void searchBar() throws InterruptedException {
//
//        String actualHomePageTitle = getCurrentTitle();
//        String expectedHomePageTitle = actualHomePageTitle;
//        LOG.info("actual home page title" + actualHomePageTitle);
//        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
//        LOG.info("land to luma home page success");
//
//        String item = "hoodie";
//        HomePage homePage = new HomePage(getDriver());
//        homePage.typeAndClickItemToSearch(item);
//
//        SearchPage searchPage = new SearchPage(getDriver());
//        searchPage.clickOnHoodiePicture();
//    }
//
//    @Test // testing the search button
//    public void searchIcon() throws InterruptedException {
//        SearchPage searchPage = new SearchPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        String itemB = "pants gym";
//        homePage.itemToSearch(itemB);
//        Thread.sleep(4000);
//        searchPage.searchBtn();
//        String title = getCurrentTitle();
//        Assert.assertEquals(title, "Search results for: 'pants gym' Magento Commerce - website to practice" +
//                " selenium | demo website for automation testing | selenium practice sites");
//        LOG.info("land to result page");
//    }
//
//    @Test // testing unfound items
//    public void unFoundItem() throws InterruptedException {
//        HomePage homePage = new HomePage(getDriver());
//        SearchPage searchPage = new SearchPage(getDriver());
//
//        String itemC = "Milk";
//        homePage.typeAndClickItemToSearch(itemC);
//        String resultErrorMessage = "Your search returned no results.";
//        Assert.assertEquals(resultErrorMessage, "Your search returned no results.");
//        LOG.info("error message show up");
//    }

    @Test // testing other search view
    public void searchView() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        String itemD = "bag";
        homePage.typeAndClickItemToSearch(itemD);
        searchPage.relevance();
        searchPage.relevancePrice(driver);
        searchPage.changeViewList();
        JavascriptExecutor jsa = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]/div[3]")));
        LOG.info("select element to click on success");
//        searchPage.showPages();
//        searchPage.numOfItemsOnPage();
//        Thread.sleep(5000);
    }
    @Test
    public void moveToNextPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        String itemD = "short";
        homePage.typeAndClickItemToSearch(itemD);
        SearchPage searchPage = new SearchPage(getDriver());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]/div[2]/ul")));
        searchPage.nextSearchPage();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]/div[2]/ul")));
        searchPage.arrowNextSearchPage();
        String title= getCurrentTitle();
        Assert.assertEquals(title,"Search results for: 'short' Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

    }

