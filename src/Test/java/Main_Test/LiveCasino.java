package Main_Test;

import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.LiveCasino_Page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LiveCasino extends BaseClass {

    String PragmaticPlay_URL = "https://craftbet.com/products/5/54230/real";
    String Evolution_URL = "https://craftbet.com/products/5/21000/real";
    String Ezugi_URL = "https://craftbet.com/products/5/5001/real";
    String TVBet_URL = "https://craftbet.com/products/5/22001/real?scroll=yes";
    String SaGaming_URL = "https://craftbet.com/products/5/66470/real";
    String VivoGaming_URL = "https://craftbet.com/products/5/75697/real";
    String VisionaryiGaming_URL = "https://craftbet.com/products/5/74000/real";
    String BETCONSTRUCT_URL = "https://craftbet.com/products/5/68606/real";

    @BeforeMethod
    public void LoginSystem_hover_open_Live_Casino_Provider() throws InterruptedException {
        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Choose ENG language
            login.Hover_Live_Casino();
            //Hover on Live Casino
        } catch (Exception err) {
            test.info("Unable to Login");
            Assert.fail();
        }
    }

    @Test(description = "PragmaticPlay Test", retryAnalyzer = Retry.class)
    public void PragmaticPlay() throws InterruptedException, IOException {
        test = extent.createTest("PragmaticPlay Provider Check (Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_PragmaticPlay_Games_Displayed()) {
                test.pass("PragmaticPlay games displayed");
                Assert.assertTrue(true);

            }
        } catch (Exception e) {
            test.fail("PragmaticPlay games not displayed");
            Assert.fail();

        }

        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, PragmaticPlay_URL);
        test.info("Compare CurrentUrl to PragmaticPlay Url");

    }




    @Test(description = "Evolution Test", retryAnalyzer = Retry.class)
    public void Evolution() throws InterruptedException, IOException {
        test = extent.createTest("Evolution Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        if (liveCasino_logic.is_Evolution_Games_Displayed()) {
            test.pass("Evolution games displayed");
            Assert.assertTrue(true);
        } else {
            test.fail("Evolution games not displayed");
            Assert.fail();
        }

        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, Evolution_URL);
        test.info("Compare CurrentUrl to Evolution Url");

    }




    @Test(description = "Ezugi Test", retryAnalyzer = Retry.class)
    public void Ezugi() throws InterruptedException, IOException {
        test = extent.createTest("Ezugi Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_Ezugi_Games_Displayed()) {
                test.pass("Ezugi games displayed");
                Assert.assertTrue(true);

            }
        } catch (Exception e) {
            test.fail("Ezugi games not displayed");
            Assert.fail();
        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, Ezugi_URL);
        test.info("Compare CurrentUrl to Ezugi Url");
    }





    @Test(description = "TVBet Test", retryAnalyzer = Retry.class)
    public void TVBet() throws InterruptedException, IOException {
        test = extent.createTest("TVBet Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_TVBet_Games_Displayed()) {
                test.pass("TVBet games displayed");
                Assert.assertTrue(true);

            }
        } catch (Exception e) {
            test.fail("TVBet games not displayed");
            Assert.fail();

        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, TVBet_URL);
        test.info("Compare CurrentUrl to TVBet Url");

    }







    @Test(description = "SaGaming Test", retryAnalyzer = Retry.class)
    public void SaGaming() throws InterruptedException, IOException {
        test = extent.createTest("SaGaming Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_SaGaming_Games_Displayed()) {
                test.pass("SaGaming games displayed");
                Assert.assertTrue(true);

            }
        } catch (Exception e) {
            test.fail("SaGaming games not displayed");
            Assert.fail();
        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, SaGaming_URL);
        test.info("Compare CurrentUrl to SaGaming Url");
    }





    @Test(description = "VivoGaming Test", retryAnalyzer = Retry.class)
    public void VivoGaming() throws InterruptedException, IOException {
        test = extent.createTest("VivoGaming Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_VivoGaming_Games_Displayed()) {
                test.pass("VivoGaming games displayed");
                Assert.assertTrue(true);

            }
        } catch (Exception e) {
            test.fail("VivoGaming games not displayed");
            Assert.fail();
        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, VivoGaming_URL);
        test.info("Compare CurrentUrl to VivoGaming Url");

    }




    @Test(description = "VisionaryiGaming Test", retryAnalyzer = Retry.class)
    public void VisionaryiGaming() throws InterruptedException, IOException {
        test = extent.createTest("VisionaryiGaming Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_VisionaryiGaming_Games_Displayed()) {
                test.pass("VisionaryiGaming games displayed");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            test.fail("VisionaryiGaming games not displayed");
            Assert.fail();

        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, VisionaryiGaming_URL);
        test.info("Compare CurrentUrl to VisionaryiGaming Url");
    }





    @Test(description = "Betconsturct Test", retryAnalyzer = Retry.class)
    public void Betconsturct() throws InterruptedException, IOException {
        test = extent.createTest("Betconsturct Provider Check(Live Casino)").assignCategory("Functional Test").assignDevice("Windows");
        LiveCasino_Page liveCasino_logic = new LiveCasino_Page();
        try {
            if (liveCasino_logic.is_Betconstruct_Games_Displayed()) {
                test.pass("Betconsturct games displayed");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            test.fail("Betconsturct games not displayed");
            Assert.fail();

        }
        String URL = driver.getCurrentUrl();
        test.info("Get CurrentUrl");
        Assert.assertEquals(URL, BETCONSTRUCT_URL);
        test.info("Compare CurrentUrl to TVBet Url");
    }
}