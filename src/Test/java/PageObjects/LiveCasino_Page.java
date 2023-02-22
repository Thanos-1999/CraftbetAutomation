package PageObjects;

import org.openqa.selenium. WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveCasino_Page extends BasePage {

    @FindBy(partialLinkText = "PragmaticPlay")
    @CacheLookup
    private WebElement PragmaticPlay;

    @FindBy(partialLinkText = "Evolution")
    @CacheLookup
    private WebElement Evolution;

    @FindBy(partialLinkText = "Ezugi")
    @CacheLookup
    private WebElement Ezugi;

    @FindBy(partialLinkText = "TVBet")
    @CacheLookup
    private WebElement TVBet;

    @FindBy(partialLinkText = "SAGaming")
    @CacheLookup
    private WebElement SaGaming;

    @FindBy(partialLinkText = "VivoGaming")
    @CacheLookup
    private WebElement VivoGaming;

    @FindBy(partialLinkText = "VisionaryiGaming")
    @CacheLookup
    private WebElement VisionaryiGaming;

    @FindBy(partialLinkText = "Header.BetConstruct")
    @CacheLookup
    private WebElement Header_BetConstruct;

    @FindBy(id = "main-game-iframe")
    @CacheLookup
    private WebElement Live_Casino_Games_iframe;

    @FindBy(id = "lobby-tables-container")
    @CacheLookup
    private WebElement Pragmatic_Play_window;

    @FindBy(css = ".AspectRatioGridBox--5846b")
    @CacheLookup
    private WebElement Evoulution_window;

    @FindBy(css = "._container_nh58m_1")
    @CacheLookup
    private WebElement Ezugi_window;

    @FindBy(id = "tvbet-game")
    @CacheLookup
    private WebElement TVBet_window;

    @FindBy(id = "gameDiv")
    @CacheLookup
    private WebElement SaGaming_window;

    @FindBy(css = ".portrait-2-columns")
    @CacheLookup
    private WebElement VivoGaming_window;

    @FindBy(css = ".container.ng-scope")
    @CacheLookup
    private WebElement VisionaryiGaming_window;

    public LiveCasino_Page() {

        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);
    int waittime = 5000;

    public boolean is_PragmaticPlay_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(PragmaticPlay);
        basePage.clickOnElementIfClickable(PragmaticPlay);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return Pragmatic_Play_window.isDisplayed();
    }

    public boolean is_Evolution_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(Evolution);
        basePage.clickOnElementIfClickable(Evolution);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return Evoulution_window.isDisplayed();
    }

    public boolean is_Ezugi_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(Ezugi);
        basePage.clickOnElementIfClickable(Ezugi);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return Ezugi_window.isDisplayed();
    }

    public boolean is_TVBet_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(TVBet);
        basePage.clickOnElementIfClickable(TVBet);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return TVBet_window.isDisplayed();
    }

    public boolean is_SaGaming_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(SaGaming);
        basePage.clickOnElementIfClickable(SaGaming);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return SaGaming_window.isDisplayed();
    }


    public boolean is_VivoGaming_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(VivoGaming);
        basePage.clickOnElementIfClickable(VivoGaming);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        basePage.waitAction(5000);
        return VivoGaming_window.isDisplayed();
    }

    public boolean is_VisionaryiGaming_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(VisionaryiGaming);
        basePage.clickOnElementIfClickable(VisionaryiGaming);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        Thread.sleep(5000);
        return VisionaryiGaming_window.isDisplayed();
    }


    public boolean is_Betconstruct_Games_Displayed() throws InterruptedException {

        basePage.waitElementToBeVisible(Header_BetConstruct);
        basePage.clickOnElementIfClickable(Header_BetConstruct);
        basePage.waitFrameToBeAvailable(Live_Casino_Games_iframe);
        Thread.sleep(5000);
        return VisionaryiGaming_window.isDisplayed();
    }
}

