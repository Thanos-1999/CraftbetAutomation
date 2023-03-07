package Main_Test.VirtualGames;

import Main_Test.BaseClass;
import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Keno_Page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Keno extends BaseClass {

    @BeforeMethod()
    public void LoginSystem_Open_Keno() throws InterruptedException {


        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Keno Game
            login.Keno();
        } catch (Exception err) {
            System.out.println("Unable to Login");
        }
    }


    @Test(description = "Verify Keno Game is Displayed", retryAnalyzer = Retry.class)
    public void Verify_Keno_Game_is_Displayed() {
        test = extent.createTest("Verify Keno Game is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        if (Keno.Verify_Keno_is_Displayed()) {
            test.pass("Keno Game is Displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Keno Game is not Displayed");
            Assert.fail();
        }
    }



    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Game_numbers() {
        test = extent.createTest("Verify Keno Balls Displayed and Balls Count is 80").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        String Keno_Balls = String.valueOf(Keno.Balls_Count());
        if (Keno_Balls.equalsIgnoreCase("80")) {
            test.pass("Balls count is " + " --> " + Keno_Balls);
            Assert.assertTrue(true);
        } else {
            test.fail("Balls count is not 80 " + " --> " + Keno_Balls);
            Assert.fail();
        }
    }




    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"})
    public void Error_up_to_10_numbers_message() {
        test = extent.createTest("Error up 1 to 10 numbers message").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        Keno.Choose_10_more_Numbers();
        test.info("Choose 10+ numbers");
        String You_can_choose_10 = Keno.error_msg();
        test.info("Capture error message");
        String exp_You_can_choose_10 = "You can choose only up to 10 numbers";
        if (You_can_choose_10.equalsIgnoreCase(exp_You_can_choose_10)) {
            test.pass("You can choose only up to 10 numbers: is Displayed" + " ---> " + exp_You_can_choose_10);
            Assert.assertTrue(true);
        } else {
            test.fail("Error message is displayed incorrect ---> " + You_can_choose_10 + " ---> " + "||" + "Should be" + " ---> " + exp_You_can_choose_10);
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"})
    public void Error_Low_balance_message() {
        test = extent.createTest("Error Low balance message").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        Keno.Choose_5_Numbers();
        test.info("Choose Random 5 numbers");
        Keno.Type_Amount("999999");
        test.info("Type the amount of Money");
        Keno.Click_Bet_btn();
        test.info("Click Bet btn");
        String Low_balance = Keno.error_msg();
        test.info("Capture error message");
        String exp_Low_balance = "Low balance. Please, make deposit and try again.";
        if (Low_balance.equalsIgnoreCase("Low balance. Please, make deposit and try again.")) {
            test.pass("Low balance. Please, make deposit and try again.: is Displayed " + " ---> " + exp_Low_balance);
            Assert.assertTrue(true);
        } else {
            test.fail("Error message is displayed incorrect --->" + Low_balance + " || " + "Should be" + " ---> " + exp_Low_balance);
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"})
    public void Success_Bet_placed_message() {
        test = extent.createTest("Success Bet placed message").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        Keno.Choose_5_Numbers();
        test.info("Choose Random 5 numbers");
        try {
            Keno.Type_Amount("1");
            test.info("Type the amount of Money");

        } catch (Exception E) {

            test.fail("Low Balance");
        }
        test.info("Type the amount of Money");
        Keno.Click_Bet_btn();
        test.info("Click Bet btn");
        String Success_Bet = Keno.success_msg();
        test.info("Capture message");
        String exp_Success_Bet = "Congratulations! Your bet is successfully placed.";
        if (Success_Bet.equalsIgnoreCase(exp_Success_Bet)) {
            test.pass("Congratulations! Your bet is successfully placed.: is Displayed" + " ---> " + exp_Success_Bet);
            Assert.assertTrue(true);
        } else {
            test.fail("Error message is displayed incorrect ---> " + Success_Bet + " || " + "Should be" + "  " + " ---> " + exp_Success_Bet);
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void VerifyExtraMarkets_is_Present() throws InterruptedException {
        test = extent.createTest("Verify Extra Markets section 'Markets' is present").assignCategory("Functional Test").assignDevice("Windows");
        SoftAssert softAssert = new SoftAssert();
        Keno_Page Keno = new Keno_Page();
        Keno.ExtraMarkets_Section();
        for (int i = 0; i < Keno.ExtraMarkets_all_markets.size(); i++) {
            String Markets_Name = Keno.ExtraMarkets_all_markets.get(i).getText();

            String[] expected = {
                    "More even/odd numbers",
                    "First Ball will be Even/Odd",
                    "Last Ball will be Even/Odd",
                    "Summery will be lower/higher than 810",
                    "Last Ball be Lower/HigherThan40.5",
                    "First Ball will be Lower/Higher Than40.5",

            };
            if (Markets_Name.equalsIgnoreCase(expected[i])) {
                test.pass(Markets_Name + " " + "btn is present");
                softAssert.assertTrue(true);

            } else {
                test.fail(Markets_Name + " " + "btn is not present");
                softAssert.assertEquals(expected[i], Markets_Name);
                softAssert.fail();
            }
        }

        softAssert.assertAll();
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Verify_rounds_is_present() {
        test = extent.createTest("Verify Rounds section works").assignCategory("Functional Test").assignDevice("Windows");
        SoftAssert softAssert = new SoftAssert();
        Keno_Page Keno = new Keno_Page();
        Keno.Open_Rounds();
        test.info("Open Rounds section");

        if (driver.getPageSource().contains("Draw ID:")) {
            test.pass("Draw ID: is displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Draw ID: is not  displayed");
            Assert.fail();
        }

        for (int i = 0; i < Keno.Rounds.size(); i++) {
            String Rounds_Name = Keno.Rounds.get(i).getText();
            String[] expected = {
                    "Playing now",
                    "Starting after 3 mins",
                    "Starting after 5 mins",
                    "Starting after 7 mins",
                    "Starting after 9 mins",
            };
            if (Rounds_Name.equalsIgnoreCase(expected[i])) {
                test.pass(Rounds_Name + " " + "time is present");
                softAssert.assertTrue(true);

            } else {
                test.fail(Rounds_Name + " " + " time is not present");
                softAssert.assertEquals(expected[i], Rounds_Name);
                softAssert.fail();

             }
         }
        softAssert.assertAll();
    }



    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Header_items() {
        test = extent.createTest("Verify header items are present").assignCategory("Functional Test").assignDevice("Windows");
        SoftAssert softAssert = new SoftAssert();
        Keno_Page Keno = new Keno_Page();
        softAssert.assertTrue(Keno.Keno_round());
        softAssert.assertTrue(Keno.Keno_jackpot());
        softAssert.assertTrue(Keno.Keno_UserID());
        softAssert.assertTrue(Keno.Keno_Balance());

        if (driver.getPageSource().contains("Jackpot")) {
            test.pass("Jackpot is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("Jackpot is  not  displayed");
            softAssert.fail();
        }
        if (driver.getPageSource().contains("Round ID")) {
            test.pass("Round ID is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("Round ID is not  displayed");
            softAssert.fail();
        }
        if (driver.getPageSource().contains("User ID")) {
            test.pass("User ID is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("User ID is not  displayed");
            softAssert.fail();
        }
        if (driver.getPageSource().contains("Balance")) {
            test.pass("Balance is displayed");
            softAssert.assertTrue(true);
        } else {
            test.fail("Balance is not  displayed");
            softAssert.fail();
        }
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Statistics_Winnings() {
        test = extent.createTest("Verify Winnings and Statistics sections are present").assignCategory("Functional Test").assignDevice("Windows");
        SoftAssert softAssert = new SoftAssert();
        Keno_Page Keno = new Keno_Page();

        test.info("Open Winnings section");
        if (Keno.Winnings_section()) {
            test.pass("Winnings section present");
            softAssert.assertTrue(true);
        } else {
            test.fail("Winnings section is not present");
            softAssert.fail();
        }
        test.info("Open Statistics section");
        if (Keno.Statistics_section()) {
            test.pass("Statistics section present");
            softAssert.assertTrue(true);
        } else {
            test.fail("Statistics section is not present");
            softAssert.fail();
        }
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Current_Bets_section() {
        test = extent.createTest("Verify Current Bets section is present").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        Keno.Choose_5_Numbers();
        test.info("Choose Random 5 numbers");
        Keno.Type_Amount("1");
        test.info("Type Bet Amount");
        Keno.Click_Bet_btn();
        test.info("Click Bet btn");
        Keno.Current_Bets_Section();
        test.info("Open Current Bets section");

        if (Keno.is_Current_Bets_section_displayed()) {
            test.pass("Current Bets  displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Current Bets not displayed");
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Last_20_Draws() {
        test = extent.createTest("Verify Last 20 Draws section is present ").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        test.info("Open Last 20 Draws section");
        Keno.Last_20_Draws();
        test.info("Verify balls  displayed ");

        if (Keno.Last_20_Draws()) {
            test.pass("Balls  displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Balls  not displayed");
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"})
    public void Verify_balance_is_change_after_bet() throws InterruptedException {
        test = extent.createTest("Verify Balance  change after bet").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        String accountbalancebeforeBet = Keno.Account_balance();
        test.info("Capture Account balance before Bet" + "--->" + " " + accountbalancebeforeBet);
        Keno.Choose_5_Numbers();
        test.info("Choose Random 5 numbers");
        Keno.Type_Amount("1");
        test.info("Type Bet Amount");
        Keno.Click_Bet_btn();
        test.info("Click Bet btn");
        Keno.Game_animation_is_visible();
        test.info("Wait Game start");

        String accountbalanceafterBet = Keno.Account_balance();
        test.info("Capture Account balance after Bet" + "--->" + " " + accountbalanceafterBet);
        if (Objects.equals(accountbalancebeforeBet, accountbalanceafterBet)) {
            test.fail("Balance Before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet);
            Assert.fail();

        } else {
            test.pass("Balance before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet + "--->" + " -1");Assert.assertTrue(true);
        }
    }


    @Test(dependsOnMethods = {"Verify_Keno_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Game_Logic() throws InterruptedException {
        test = extent.createTest("Verify Game Logic work without problem").assignCategory("Functional Test").assignDevice("Windows");
        Keno_Page Keno = new Keno_Page();
        Keno.Choose_5_Numbers();
        test.info("Choose Random 5 numbers");
        Keno.Type_Amount("1");
        test.info("Type Bet Amount");
        Keno.Click_Bet_btn();
        test.info("Click Bet btn");
        Keno.Keno_Game();
        test.info("Wait Game to Start");
        test.fatal("WIN/LOS POP UP IS ABSENT");
    }
}

