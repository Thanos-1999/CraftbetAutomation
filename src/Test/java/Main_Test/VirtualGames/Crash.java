package Main_Test.VirtualGames;

import Main_Test.BaseClass;
import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Crash_page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Crash extends BaseClass {
    @BeforeMethod
    public void LoginSystem_Open_Crash() {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Crash Game
            login.Crash();
        } catch (Exception err) {
            System.out.println("Unable to Login");
        }
    }

    @Test(description = "Verify Crash Game is Displayed", retryAnalyzer = Retry.class)
    public void Verify_Crash_is_Displayed() throws InterruptedException {
        test = extent.createTest("Verify Crash Game is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        if (Crash.Verify_Crash_is_Displayed()) {
            test.pass("Crash Game is Displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Crash Game is not Displayed");
            Assert.fail();
        }
    }


    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Crash_Statistics() throws InterruptedException {
        test = extent.createTest("Crash Statistics").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        Assert.assertTrue(Crash.Last_Result_Top_Crashes());
        test.info("Verify Last Result & Top Crashes  displayed");

    }


    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Game_Bet() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        test = extent.createTest("Crash Bet").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        Crash.Crash_Bet("0.2");
        test.info("Type Bet amount and click Place Bet");
        String Betmessage = Crash.Bet_message();
        test.info("Capture Bet message --->" + Betmessage);
        softAssert.assertTrue(Betmessage.equalsIgnoreCase("Thank you for your bet"));
        test.info("Verify bet successfully placed");
        softAssert.assertTrue(Crash.is_Cashout_Displayed());
        test.info("Verify Cashout is displayed");

        try {
            Crash.Coef_to_be_visible();
            test.info("Wait coefficients to be visible");
            Thread.sleep(2000);
            Crash.click_Cashout();
            test.info("Click Cashout");
        } catch (Exception E) {
            test.fatal("Unable to click Cashout");
            Assert.fail();
        }


        if (driver.getPageSource().contains("success")) {
            test.pass("Successful Cashout --->" + Crash.Cashout_text() + " --->" + Crash.Coef_text());
            Assert.assertTrue(true);
        } else {
            test.fail("Cashout fail");
            Assert.fail();
        }
    }




    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Crash_Hash_Codes() throws InterruptedException {
        test = extent.createTest("Hash Codes section").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        Assert.assertTrue(Crash.Hash_Codes());
        test.info("Verify Hash Codes is displayed");
    }

    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Crash_My_Bets() throws InterruptedException {
        test = extent.createTest("Crash My Bets section").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        Assert.assertTrue(Crash.My_Bets());
        test.info("Verify History is displayed");
    }

    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Crash_Auto_Cashout() throws InterruptedException {
        test = extent.createTest("Crash Auto Cashout functional").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        Crash.Auto_Cashout();
        test.info("Switch Auto Cashout to active mode");
        Crash.Auto_Cashout_Sendkeys();
        test.info("Type Auto Cashout: 1.09x");
        Crash.Crash_Bet("1");
        test.info("Type bet amount: 1 USD and click Bet btn");
        Crash.Coef_to_be_visible();
        test.info("Wait Game to start");
        Crash.CashedOut_txt();
        test.info("Get Auto AutoCashout (x)");
        String Expected_Cof_txt = "1.09";
        String Crashed_Cof_txt = Crash.CashedOut_txt();
        Assert.assertEquals(Crashed_Cof_txt, Expected_Cof_txt);
        test.info("Cashout Coef. (1.09x x 1): Should be ---->" + Crashed_Cof_txt + "USD");
    }

    @Test(dependsOnMethods = {"Verify_Crash_is_Displayed"})
    public void Verify_balance_is_change_after_bet() throws InterruptedException {
        test = extent.createTest("Verify Balance  change after bet").assignCategory("Functional Test").assignDevice("Windows");
        Crash_page Crash = new Crash_page();
        String accountbalancebeforeBet = Crash.Account_balance();
        test.info("Capture Account balance before Bet" + "--->" + " " + accountbalancebeforeBet);
        Crash.Crash_Bet("1");
        test.info("Type Bet amount and click Place Bet");
        String Betmessage = Crash.Bet_message();
        test.info("Capture Bet message --->" + Betmessage);
        Assert.assertTrue(Betmessage.equalsIgnoreCase("Thank you for your bet"));
        test.info("Verify bet successfully placed");
        Thread.sleep(5000);
        String accountbalanceafterBet = Crash.Account_balance();
        test.info("Capture Account balance after Bet" + "--->" + " " + accountbalanceafterBet);

        
        if (Objects.equals(accountbalancebeforeBet, accountbalanceafterBet)) {
            test.fail("Balance Before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet);
            Assert.fail();

        } else {
            test.pass("Balance before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet + "--->" + " -1");
            Assert.assertTrue(true);
        }
    }
}


