package Main_Test;

import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.BookBet_page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookBet extends BaseClass {

    @BeforeMethod

    public void LoginSystem_Open_Sport() throws InterruptedException {
        try {
            Login_Pages login = new Login_Pages();
            login.Choose_Eng_Language();
            //Select Eng Language
            login.Sport();
            //Open Sport Page
        } catch (Exception err) {
            System.out.println("Unable to Login");
            Assert.fail();
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void BookBet_section_functional() throws InterruptedException {
        test = extent.createTest("BookBet section functional").assignCategory("Functional Test").assignDevice("Windows");
        BookBet_page bookbet = new BookBet_page();
        bookbet.Make_random_bet();

        test.info("Make Random Express Bet");
        if (driver.getPageSource().contains("Unallowed Combination")) {
            test.info("Unallowed Combination");
            Assert.fail();
        }
        Assert.assertTrue(bookbet.Open_BookBet_Tab());
        test.info("Verify BookBet section is Displayed");


        if (driver.getPageSource().contains("Your bet has been booked.")) {
            test.pass("Your bet has been booked. text is displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Your bet has been booked. text is not displayed");
            Assert.fail();
        }

        if (driver.getPageSource().contains("Print Bet")) {
            test.pass("Print Bet text is displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Print Bet text is not displayed");
            Assert.fail();
        }

        if (driver.getPageSource().contains("Book New Bets")) {
            test.pass("Book New Bets text is displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Book New Bets text is not displayed");
            Assert.fail();
        }

        if (driver.getPageSource().contains("For your bet to be valid, take your booking code to any Betting shop to place your bet. Note that odds might change.")) {
             test.pass("Book Bet info text is displayed");
             Assert.assertTrue(true);
        } else {
             test.fail("Book Bet info text is not displayed");
             Assert.fail();
        }
        Assert.assertTrue(bookbet.is_booking_code_displayed());
        Assert.assertTrue(bookbet.is_date_displayed());
        test.info("Verify BookBet Content is displayed");
    }
}
