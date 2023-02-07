package tests.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.LeaveCommentNewsPage;

public class TestLeaveCommentNews extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestSearch.class.getName());


    @Test

    public void commentonNews() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        LeaveCommentNewsPage comment= new LeaveCommentNewsPage(getDriver());
        comment.cLickOnNewsButton();
        comment.cLickOnNewReleaseLink();
        comment.typeCommentTitle();
        comment.typeComment();
        comment.cLickOnNewCommentButton();
        String CommentAdd= comment.CommentAdded();
        Assert.assertEquals(CommentAdd, "News comment is successfully added.");
        LOG.info("News Comment successfully added validation success");

    }

}
