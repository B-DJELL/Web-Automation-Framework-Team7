package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(ReviewPage.class.getName());

    public ReviewPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(css = "#pollanswers-2")
    WebElement PollanswerGoodButton;

    @FindBy(css = "#vote-poll-1")
    WebElement VotePollButton;


// Reusable steps

    public void ClickOnPollAnswer(){
        clickOn(PollanswerGoodButton);
        LOG.info("Click on Good Button Success");
    }
    public void ClickOnVotePollButton(){
        clickOn(VotePollButton);
        LOG.info("Click on Vote Button Success");
    }





}
