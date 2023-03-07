package Main_Test.VirtualGames;

import Main_Test.BaseClass;
import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Login_Pages;
import PageObjects.Minesweeper_page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Minesweeper extends BaseClass {
    @BeforeMethod()
    public void LoginSystem_Open_Minesweeper() throws InterruptedException {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Minesweeper Game
            login.Minesweeper();
        } catch (Exception err) {
            System.out.println("Unable to Login");
        }
    }

    @Test(description = "Verify Minesweeper Game is Displayed", retryAnalyzer = Retry.class)
    public void Verify_Minesweeper_Game_is_Displayed() {
        test = extent.createTest("Verify Minesweeper Game is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        if (Minesweeper.Verify_Minesweeper_is_Displayed()) {
            test.info("Minesweeper Game is Displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Minesweeper Game is not Displayed");
        }
    }




    @Test(dependsOnMethods = {"Verify_Minesweeper_Game_is_Displayed"})
    public void Custom_section_functional_Minesweeper() throws InterruptedException {
        test = extent.createTest("Verify Minesweeper Custom section functional").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        Minesweeper.Custom_section();
        test.info("Open Custom section");
        Minesweeper.checkmark();
        test.info("Select any Checkbox");
        Minesweeper.columns(Integer.parseInt("5"));
        test.info("Type Columns size" + "---> 5");
        Minesweeper.Rows(Integer.parseInt("12"));
        test.info("Type Rows size" + "---> 12");
        Minesweeper.Mines(Integer.parseInt("1"));
        test.info("Type Mines size" + "---> 1");
        Minesweeper.TicketPrice(String.valueOf(Integer.parseInt("1")));
        test.info("Type Ticket Price" + "---> 1 USD");
        Minesweeper.Play_btn();
        test.info("Click Play Now btn");
        Minesweeper.Random_column_click();
        test.info("Select Random Column(s) and wait pop up to be visible");
        Minesweeper.is_Cashout_btn_displayed();
        test.info("Verify Cashout button is displayed");
        Thread.sleep(4000);

        if (driver.getPageSource().contains("Game over.")) {
            test.pass("We Lose");
            test.info("Capture pop up text--->" + Minesweeper.Lost_popup());
            Assert.assertTrue(true);

        } else if (driver.getPageSource().contains("Congratulations!")) {
            test.pass("We Win");
            test.info("Capture pop up text--->" + Minesweeper.Win_popup());
            Assert.assertTrue(true);

        } else {
            test.fatal("Unexpected error");
            Assert.fail();
        }
    }





    @Test(dependsOnMethods = {"Verify_Minesweeper_Game_is_Displayed"}, retryAnalyzer = Retry.class)
    public void Ticket_History() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        test = extent.createTest("Ticket History").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        Minesweeper.Ticket_history();
        test.info("Open Ticket History");
        softAssert.assertTrue(Minesweeper.web_date());
        test.info("Verify Web Date is present");
        softAssert.assertTrue(Minesweeper.calendar_icon());
        test.info("Verify calendar icon is present");
        softAssert.assertTrue(Minesweeper.history());
        test.info("Verify history is present");
        softAssert.assertAll();
    }




    @Test(dependsOnMethods = {"Verify_Minesweeper_Game_is_Displayed"})
    public void Verify_balance_is_change_after_bet() throws InterruptedException {
        test = extent.createTest("Verify Balance  change after bet").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        String accountbalancebeforeBet = Minesweeper.Account_balance();
        test.info("Capture account balance before bet");
        Minesweeper.Custom_section();
        test.info("Open Custom section");
        Minesweeper.checkmark();
        test.info("Select any Checkbox");
        Minesweeper.columns(Integer.parseInt("4"));
        test.info("Type Columns size" + "---> 4");
        Minesweeper.Rows(Integer.parseInt("4"));
        test.info("Type Rows size" + "---> 4");
        Minesweeper.Mines(Integer.parseInt("2"));
        test.info("Type Mines size" + "---> 2");
        Minesweeper.TicketPrice(String.valueOf(Integer.parseInt("1")));
        test.info("Type Ticket Price" + "---> 1 USD");
        Minesweeper.Play_btn();
        test.info("Click Play Now btn");
        Thread.sleep(5000);
        String accountbalanceafterBet = Minesweeper.Account_balance();
        test.info("Capture Account balance after Bet" + "--->" + " " + accountbalanceafterBet);
        if (Objects.equals(accountbalancebeforeBet, accountbalanceafterBet)) {
            test.fail("Balance Before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet);
            Assert.fail();

        } else {
            test.pass("Balance before Bet" + "--->" + accountbalancebeforeBet + "||" + "Balance after Bet" + "--->" + accountbalanceafterBet + "--->" + " -1");
            Assert.assertTrue(true);
        }
    }



    @Test(description = "Game Help", dependsOnMethods = {"Verify_Minesweeper_Game_is_Displayed"})
    public void Help_Minesweeper() {
        test = extent.createTest("Verify Help functional").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        Minesweeper.Game_Help();
        Assert.assertTrue(driver.getPageSource().contains(" Minesweeper is a quick game. Action is 24 hours a day, 7 days a week. Rounds start each second. It is a game of chance, similar to the very classic Minesweeper known to everyone. "));
        test.info("Verify Help section text is present");
    }



    @Test(description = "Top_Results", dependsOnMethods = {"Verify_Minesweeper_Game_is_Displayed"})
    public void Top_Results() {
        test = extent.createTest("Verify Top Result section is present").assignCategory("Functional Test").assignDevice("Windows");
        Minesweeper_page Minesweeper = new Minesweeper_page();
        Assert.assertTrue(Minesweeper.Top_Result_section());
        test.info("Open Minesweeper section and Verify Top Results is displayed");

    }
}

