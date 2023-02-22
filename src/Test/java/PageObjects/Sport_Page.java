package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Sport_Page extends BasePage {

    @FindBy(css = ".container-header>.ng-pristine")

    @CacheLookup
    private WebElement SEARCH;
    @FindBy(xpath = "//*[text()='Real Madrid'] ")

    @CacheLookup
    private WebElement SEARCH_RESULT;
    @FindBy(css = ".user-bet")

    @CacheLookup
    private WebElement BetSlip_Panel;
    @FindBy(css = ".user-bet .ng-untouched")

    @CacheLookup
    private WebElement Stake;
    @FindBy(css = ".market-types-box>.match-selections>.selection-coefficient")
    @CacheLookup
    private List<WebElement> Cofficients;

    @FindBy(css = ".place-bet-button")

    @CacheLookup
    private WebElement Place_Bet;

    @FindBy(id = "board")

    @CacheLookup
    private WebElement Board;

    @FindBy(id = "main-game-iframe")

    @CacheLookup
    private WebElement Sport_Board_Iframe;

    @FindBy(id = "videoplayer_youtube_api")

    @CacheLookup
    private WebElement Sport_Board_Iframe2;
    @FindBy(css = ".main-content")

    @CacheLookup
    private WebElement Upcoming_Games;

    @FindBy(css = ".user-bet-msg")

    @CacheLookup
    private WebElement Bet_Message;

    @FindBy(xpath = "//div[@class='user-bet-info row1']//span[2]")

    @CacheLookup
    private WebElement bet_info;

    @FindBy(css = "[title='Tooltip TeaserBets']")

    @CacheLookup
    private WebElement Open_bets;

    @FindBy(css = ".open-bets-totals")

    @CacheLookup
    private WebElement Open_bets_totals;

    @FindBy(css = ".opened-bets-content > div:nth-of-type(1) > .place-bet-button")

    @CacheLookup
    private WebElement REBET;

    @FindBy(css = ".opened-bets-content > div:nth-of-type(1) > div:nth-of-type(4)")
    @CacheLookup
    private WebElement STAKE;

    @FindBy(css = "h3[title='Tooltip OpenBets']")
    @CacheLookup
    private WebElement Cash_Out_frame;


    @FindBy(css = ".opened-bet")
    @CacheLookup
    private WebElement Opened_bet_is_Displayed;


    @FindBy(css = ".sports-list > li > label > span")
    @CacheLookup
    public List<WebElement> Sports_names;


    public Sport_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);


    public void Sport_Search() throws InterruptedException {
        try {
            basePage.sendKeysIfElementVisible(SEARCH, "Real Madrid");
            basePage.waitAction(2000);
            basePage.clickOnElementIfVisible(SEARCH);
        } catch (Exception e) {
            System.out.println("Search is not working");
        }
    }

    public boolean is_Sport_Betslip_Displayed() throws InterruptedException, AWTException {

        basePage.waitAction(4000);
        Random random = new Random();
        int randomProduct = random.nextInt(10);
        basePage.javaScriptClick(Cofficients.get(randomProduct));
        return BetSlip_Panel.isDisplayed();
    }

    public void Sport_PlaceBet() throws InterruptedException, AWTException {
        try {
            basePage.waitAction(4000);
            basePage.scrollToSpecificElementOnCenter(Place_Bet);
            basePage.sendKeysIfElementVisible(Stake, "1");
            basePage.javaScriptClick(Place_Bet);
        } catch (Exception e) {
            System.out.println("Unable to place bet");
        }
    }

    public boolean isUpcomingGamesDisplayed() {
        try {
            basePage.waitElementToBeVisible(Upcoming_Games);
            return Upcoming_Games.isDisplayed();
        } catch (Exception e) {
            System.out.println("Upcoming games not displayed");

        }
        return false;
    }

    public boolean isBoardDisplayed() {
        try {
            basePage.waitAction(2000);
            return Board.isDisplayed();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            basePage.waitAction(2000);
            return Board.isDisplayed();
        }
    }


    public String SportBet_message() {
        try {
            basePage.waitAction(2000);
            return basePage.getText(Bet_Message);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            basePage.waitAction(2000);
            return basePage.getText(Bet_Message);
        }
    }


    public boolean isSportSearchDisplayed() {
        try {
            basePage.waitElementToBeVisible(SEARCH_RESULT);
            return SEARCH_RESULT.isDisplayed();
        } catch (Exception E) {
            System.out.println("Sport search is not displayed");
        }
        return false;
    }


    public String teams_name() throws InterruptedException {
        basePage.waitAction(4000);
        return basePage.getText(bet_info);
    }

    public void open_Cash_Out() {
        basePage.waitAction(2000);
        basePage.javaScriptClick(Cash_Out_frame);
    }


    public void Open_Bets() {
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(Open_bets);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Open_bets);
        basePage.waitElementToBeVisible(Opened_bet_is_Displayed);
    }


    public String teams_name_in_Open_Bets() throws InterruptedException {
        basePage.waitElementToBeVisible(Open_bets_totals);
        return basePage.getText(Open_bets_totals);
    }


    public boolean is_REBET_Displayed() {
        basePage.waitElementToBeVisible(REBET);
        return REBET.isDisplayed();
    }

    public String Stake() {
        basePage.waitElementToBeVisible(STAKE);
        return basePage.getText(STAKE);
    }


    public List<String> Sports() {

        List<String> All_Sports = new ArrayList<String>();

        for (WebElement Sport : Sports_names) {
            All_Sports.add(basePage.getText(Sport).replaceAll("\\P{L}", " "));
        }
//        System.out.println(All_Sports);
        return All_Sports;
    }
}











