package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FollowUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(SubscribePage.class.getName());

    public FollowUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Facebook']")
    WebElement FacebookLogo;

    @FindBy(xpath = "//a[normalize-space()='Twitter']")
    WebElement TwitterLogo;

    @FindBy(xpath = "//a[normalize-space()='YouTube']")
    WebElement YoutubeLogo;

    @FindBy(css = "(//div[@class='yt-spec-touch-feedback-shape__fill'])[4]")
    WebElement SubscribeButtonOnYoutubeChannel;

    //Reusable steps

    public void ClickOnFacebookLogo() {
        clickOn(FacebookLogo);
        log.info("click on Facebook logo success");
    }

    public void ClickOnTwitterLogo() {
        clickOn(TwitterLogo);
        log.info("click on Twitter logo success");
    }

    public void ClickOnYoutubeLogo() {
        clickOn(YoutubeLogo);
        log.info("click on Youtube logo success");
    }

    public void ClickOnSubscribeButtonInYoutube() {
        clickOn(SubscribeButtonOnYoutubeChannel);
        log.info("click on Youtube logo success");
    }


}
