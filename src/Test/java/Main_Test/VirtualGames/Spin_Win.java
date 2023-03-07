package Main_Test.VirtualGames;

import Main_Test.BaseClass;
import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Login_Pages;
import PageObjects.Spin_Win_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Spin_Win extends BaseClass {
    //incomplete
    @BeforeMethod()
    public void LoginSystem_Open_Spin_Win() throws InterruptedException {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Spin_Win Game
            login.Spin_Win();
        } catch (Exception err) {

            System.out.println("Unable to Login");
        }
    }

    @Test(description = "Verify Spin&Win Game is Displayed", retryAnalyzer = Retry.class)
    public void Verify_Spin_win_is_Displayed() {
        test = extent.createTest("Verify Spin&Win Game is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        if (spin_win.is_Spin_Win_isDisplayed()) {
            test.pass("Spin&Win Game is Displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Spin&Win Game is not Displayed");
            Assert.fail();
        }
    }

    @Test(description = "Spin Bet", retryAnalyzer = Retry.class, dependsOnMethods = {"Verify_Spin_win_is_Displayed"})
    public void Spin_win_bet() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        test = extent.createTest("Spin&Win bet").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        spin_win.Choose_random_5_number();
        test.info("Select random 5 numbers");
        softAssert.assertTrue(spin_win.is_Bet_Board_displayed());
        test.info("Verify Bet Board is displayed");
        softAssert.assertTrue(spin_win.is_Bet_Shape_displayed());
        test.info("Verify VOISINS DU ZERO/ORPHELINS/TIERS are displayed");
        spin_win.Wait_Success_message_to_display();
        test.info("Wait until pop up is displayed");
        if (spin_win.Success_message_txt().equalsIgnoreCase("Congratulations! Your bet is successfully placed text is displayed")) {
            test.pass("Congratulations! Your bet is successfully placed text is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("Congratulations! Your bet is successfully placed text is not displayed");
            softAssert.fail();
        }

        if (driver.getPageSource().contains("Low balance. Please, make deposit and try again")) {
            test.fail("Low balance");
            softAssert.fail();
        }

        spin_win.Wait_Result_time_to_display();
        test.info("Wait until Result time is displayed");
        softAssert.assertTrue(spin_win.Verify_Wheelrun_is_displayed());
        test.info("Verify Wheel run is displayed");

        spin_win.is_bet_displayed();
        test.info("Verify our bet is displayed");
    }



    @Test(description = "Statistics", dependsOnMethods = {"Verify_Spin_win_is_Displayed"})
    public void Verify_Statistics_is_Displayed() {
        test = extent.createTest("Verify Statistics  is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        Assert.assertTrue(spin_win.is_Statistics_displayed());
        test.info("Verify Statistics content is displayed");
    }



    @Test(description = "Bet Buttons", dependsOnMethods = {"Verify_Spin_win_is_Displayed"})
    public void Bet_buttons() {
        test = extent.createTest("Bet Buttons").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        Assert.assertTrue(spin_win.REBET());
        Assert.assertTrue(spin_win.UNDO());
        Assert.assertTrue(spin_win.COINS());
        Assert.assertTrue(spin_win.CLEAR());
        Assert.assertTrue(spin_win.DOUBLE());
        test.info("Verify Bet buttons are displayed");
    }


    @Test(dependsOnMethods = {"Verify_Spin_win_is_Displayed"})
    public void Verify_balance_is_change_after_bet() {
        test = extent.createTest("Verify Balance  change after bet").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        String accountbalancebeforeBet = spin_win.Account_balance();
        test.info("Capture Account balance before bet");
        spin_win.Choose_random_5_number();
        test.info("Select random 5 numbers");
        Assert.assertTrue(spin_win.is_Bet_Board_displayed());
        test.info("Verify Bet Board is displayed");
        Assert.assertTrue(spin_win.Verify_Wheelrun_is_displayed());
        test.info("Wait until game start");
        String accountbalanceafterBet = spin_win.Account_balance();
        test.info("Capture Account balance after Bet" + "--->" + " " + accountbalanceafterBet);

        if (Objects.equals(accountbalancebeforeBet, accountbalanceafterBet)) {
            test.fail("Balance Before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet);
            Assert.fail();
        } else {
            test.pass("Balance before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet + "--->" + "-1");
            Assert.assertTrue(true);
        }
    }


    @Test()
    public void Verify_header_items_are_working() {
        test = extent.createTest("Verify Game header items are displayed").assignCategory("Functional Test").assignDevice("Windows");
        Spin_Win_Page spin_win = new Spin_Win_Page();
        String actual_User_ID_txt = spin_win.User_ID();
        Assert.assertEquals(actual_User_ID_txt, "User ID\n" +
                "4203334");
        test.info("Verify User ID is displayed");
        Assert.assertTrue(spin_win.Balance());
        test.info("Verify Balance is displayed");
        Assert.assertTrue(spin_win.Jackpot());
        test.info("Verify Jackpot is displayed");
        String actual_odds_txt = spin_win.odds_section();
        String expected_odds_txt = "Combinations\n" +
                "MaxMin\n" +
                "Payoff";

        Assert.assertEquals(actual_odds_txt, expected_odds_txt);
        test.info("Verify odds is displayed");
        Assert.assertTrue(spin_win.is_light_dark_modes_works());
        test.info("Verify Game fon works");


        try {
            spin_win.Open_Help_section();
            if (driver.getPageSource().contains("SpinAndWin is a quick game. Action is 24 hours a day, 7 days a week. Betting round starts every few minutes. ")) {
                test.info("Help section works");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            test.info("Help section is not working");
            Assert.fail();
        }
    }
}