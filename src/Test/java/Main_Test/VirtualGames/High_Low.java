package Main_Test.VirtualGames;

import Main_Test.BaseClass;
import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.High_Low_page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class High_Low extends BaseClass {

    @BeforeMethod
    public void LoginSystem_Open_Keno() throws InterruptedException {
        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Keno Game
            login.High_Low();

        } catch (Exception err) {
            System.out.println("Unable to Login");
        }
    }



    @Test(description = "Verify High Low Game is Displayed", retryAnalyzer = Retry.class)
    public void Verify_High_Low_is_Displayed() {
        test = extent.createTest("Verify High Low Game is Displayed").assignCategory("Functional Test").assignDevice("Windows");
        High_Low_page High_low = new High_Low_page();
         if (High_low.Verify_High_Low_is_Displayed()) {
            test.pass("High Low Game is Displayed");
            Assert.assertTrue(true);
         } else {
            test.fail("High Low Game is not Displayed");
            Assert.fail();
        }
    }
}
