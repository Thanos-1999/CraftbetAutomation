package Main_Test;

import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Login_Pages;
import PageObjects.Sport_Page;
import cucumber.api.java.sk.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class Sport extends BaseClass {
    String SPORT_URL = "https://craftbet.com/sport/prematch#/prematch/home";

    @BeforeMethod()
    public void LoginSystem_Open_Sport() throws InterruptedException {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Sport Page
            login.Sport();
        } catch (Exception err) {
            test.info("Unable to Login");
            Assert.fail();
        }
    }


    @Test(description = "Check Sport Section availability", priority = 0)
    public void SportSection_availability() throws IOException, InterruptedException {
        test = extent.createTest("Sport Section availability").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, SPORT_URL);
        test.info("Compare Current URL to Sport Page URL");
    }

    @Test(retryAnalyzer = Retry.class, description = "Check Casino Search Functional")
    public void SportSearchFunctional() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Check Casino Search Functional").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();
        sportCraftBet.Sport_Search();
        test.info("Type in search input field: Real Madrid");

        try {
            if (sportCraftBet.isSportSearchDisplayed()) {
                test.pass("Search Functional works (Real Madrid displayed in result)");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            test.fail("Search Functional is not working");
            Assert.fail();
        }
    }

    @Test(retryAnalyzer = Retry.class, description = "Check Bet Slip availability")
    public void Betslip_functional() throws IOException, InterruptedException, AWTException, AWTException {
        test = extent.createTest("Betslip Functional").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();
        if (sportCraftBet.is_Sport_Betslip_Displayed()) {
            test.pass("Betslip is Displayed ");
            Assert.assertTrue(true);
        } else {
            test.fail("Betslip is not Displayed ");
            Assert.fail();
        }
    }


    @Test(description = "Check BetSlip Bet")
    public void Sport_Bet() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Place Bet in Betslip").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();
        sportCraftBet.is_Sport_Betslip_Displayed();
        test.info("Verify BetSlip is Displayed");
        sportCraftBet.Sport_PlaceBet();

        if (sportCraftBet.SportBet_message().equalsIgnoreCase("Bet placed")) {
            test.pass("Bet successfully placed");
            Assert.assertTrue(true);

        } else if (sportCraftBet.SportBet_message().equalsIgnoreCase("Low Balance")) {
            test.fail("insufficient amount");
            Assert.fail();

        } else if (sportCraftBet.SportBet_message().equalsIgnoreCase("Coefficient Has changed")) {
            test.fail("Coefficients is changed");
            Assert.fail();

        } else {
            test.fatal("Unexpected error");
            Assert.fail();
        }
    }


    @Test()
    public void UpcomingGames() throws InterruptedException, AWTException {
        test = extent.createTest("Upcoming Games").assignCategory("Functional Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();
        if (sportCraftBet.isUpcomingGamesDisplayed()) {
            Assert.assertTrue(true, test.pass("Upcoming Games is Displayed").toString());
        } else {
            test.fail("Upcoming Games is not displayed");
            Assert.fail();
        }
    }


    @Test(description = "Verify Sport is Present")
    public void Verify_Sport_is_Present() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Sport is Present").assignCategory("Functional Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();

        String[] expected_Sports = {
                "Soccer",
                "Basketball",
                "Tennis",
                "Formula ",
                "Ice Hockey",
                "Rugby League",
                "Rugby Union",
                "Volleyball",
                "Futsal",
                "Aussie Rules",
                "Cricket",
                "Cybersport",
                "Handball",
                "Kabaddi",
                "Athletics",
                "Golf",
                "Baseball",
                "Bandy",
                "Water Polo",
                "Boxing",
                "Darts",
                "Lottery",
                "Netball",
                "Politics",
                "E-Football",
                "E-Basketball",
                "Mortal Kombat",
                "Snooker",
                "Specials",
                "Floorball",
                "Field Hockey",
                "Chess"
        };

        for (String sport : expected_Sports) {
            System.out.println(sport);


            SoftAssert softAssert = new SoftAssert();

            if (sportCraftBet.Sports().toString().contains(sport)) {
                test.pass("Sport is present ---> " + sport);
                softAssert.assertTrue(true);
            } else {
                test.fail("Sport is not present ---> " + sport);
                softAssert.fail();
            }

            if (!sportCraftBet.Sports().toString().contains("Soccer")) {
                test.fatal("Soccer is not displayed");
                softAssert.fail();

            }
        }
    }


    @Test(description = "Check Sport History", enabled = true)
    public void Sport_Bet_History() throws InterruptedException, AWTException, AWTException {
        SoftAssert softAssert = new SoftAssert();
        test = extent.createTest("Check Sport Bet History").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Sport_Page sportCraftBet = new Sport_Page();
        sportCraftBet.is_Sport_Betslip_Displayed();
        test.info("Select Random Game");
        String match = sportCraftBet.teams_name();
        test.info("Get Match name ---" + sportCraftBet.teams_name());
        sportCraftBet.Sport_PlaceBet();
        test.info("Place Bet");
        sportCraftBet.open_Cash_Out();
        test.info("Open Cash Out");
        String Open_Bets_match = sportCraftBet.teams_name_in_Open_Bets();
        test.info("Verify Match displayed in History");


        if (match.equalsIgnoreCase(Open_Bets_match)) {
            test.pass("Selected Match is Displayed in History");
            softAssert.assertTrue(true);
        } else {
            test.fail("Selected Match is not Displayed in History");
            Assert.fail();
        }

        if (sportCraftBet.is_REBET_Displayed()) {
            test.pass("REBET btn is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("REBET btn is not active");
            Assert.fail();
        }
    }
}