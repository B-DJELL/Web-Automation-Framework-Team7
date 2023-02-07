package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;

public class MainPageTest extends CommonAPI {
    MainPage mainPage;
    PricingPage pricingPage;
    ComparePage comparePage;
    CrmForAnyBusinessPage crmForAnyBusinessPage;

    String PricingLogoMessage="CRM Software Pricing";
    String CompareLogoMessage="Free CRM Comparison";
    String CrmCloudMessage="CRM Cloud";

    //Access to Pricing Page:
    @Test(enabled = false)
    public void AccessToPricingPageTest(){
        mainPage=new MainPage(driver);
        pricingPage=new PricingPage(driver);

        mainPage.clickOnPricingBtn();

        Assert.assertEquals(pricingPage.getPricingLogoMessage(),PricingLogoMessage);
    }

    //Access to Comparing Page:
    @Test(enabled = false)
    public void AccessToComparePageTest(){
        mainPage=new MainPage(driver);
        comparePage=new ComparePage(driver);

        mainPage.clickOnCompareBtn();

        Assert.assertEquals(comparePage.getCompareLogoMessage(),CompareLogoMessage );
    }

    //Test on Crm for any business Page from dropdown menu:
    @Test(enabled = false)
    public void CrmMenuTest(){
        mainPage=new MainPage(driver);
        crmForAnyBusinessPage=new CrmForAnyBusinessPage(driver);

        mainPage.hoverOverCrmAndSelectCrmForAnyBusiness(driver);

        Assert.assertEquals(crmForAnyBusinessPage.CrmCloudLogoMessage(), CrmCloudMessage);
    }
}
