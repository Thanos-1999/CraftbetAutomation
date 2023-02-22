package Main_Test;
import PageObjects.Footer_Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class Footer extends BaseClass {

    String PREMIER_LEAGUE_URL = "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10186";

    String LIGUE_1_URL = "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=9312";

    String BUNDESLIGA_URL = "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=11270";

    String SERIE_A_URL = "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=11270";

    String CHAMPIONS_LEAGUE_URL = "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10055";

    String BINGO_37_URL = "https://craftbet.com/category/5/1001/real/1";

    String KENO_URL = "https://craftbet.com/category/5/1004/real/1";

    String CRASH_URL = "https://craftbet.com/category/5/1008/real/1";

    String HIGH_LOW_URL = "https://craftbet.com/category/5/1007/real/1";

    String BET_ON_RACING_URL = "https://craftbet.com/category/5/1006/real/1";

    String BET_ON_POKER = "https://craftbet.com/category/5/1005/real/1";

    String BINGO_47_URL = "https://craftbet.com/category/5/1003/real/1";

    String COLORS_URL = "https://craftbet.com/category/5/1002/real/1";

    String MINESWEEPER_URL = "https://craftbet.com/category/5/1001/real/1";


    @Test(description = "LEGAL")
    public void TERMS_CONDITIONS() throws InterruptedException {
        test = extent.createTest("TERMS CONDITIONS").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.TERMS_CONDITIONS();
        test.info("Check TERMS CONDITIONS section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
        Thread.sleep(1000);
        if (driver.getPageSource().contains("We are CraftBet, a leading international provider of sports betting, casino and online poker.")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }


    @Test(description = "SELF EXCLUSION")
    public void SELF_EXCLUSION() throws InterruptedException {
        test = extent.createTest("SELF EXCLUSION").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.SELF_EXLUSION();
        test.info("Check SELF EXCLUSION section ");
        Assert.assertTrue(footer.Content.isDisplayed());
        Thread.sleep(3000);
        if (driver.getPageSource().contains("It is our responsibility to ensure that all of our customers are provided a safe and secure gaming")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }


    @Test(description = "RESPONSIBLE GAMING")
    public void RESPONSIBLE_GAMING() {
        test = extent.createTest("RESPONSIBLE GAMING").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.RESPONSIBLE_GAMING();
        test.info("Check RESPONSIBLE GAMING section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
        if (driver.getPageSource().contains("CraftBet is committed to offering its customers a fun gaming experience, accepting that gambling")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }


    @Test(description = "DISPUTE RESOLUTION")
    public void DISPUTE_RESOLUTION() {
        test = extent.createTest("DISPUTE RESOLUTION").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.DISPUTE_RESOLUTION();
        test.info("Check RESPONSIBLE GAMING section wor");
        Assert.assertTrue(footer.Content.isDisplayed());
    }



    @Test(description = "AML")
    public void AML() {
        test = extent.createTest("AML").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.AML();
        test.info("Check AML  section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
    }




    @Test(description = "FAIR GAMING AND RNG")
    public void FAIR_GAMING_AND_RNG() {
        test = extent.createTest("FAIR GAMING AND RNG").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.FAIR_GAMING_AND_RNG();
        test.info("Check FAIR GAMING AND RNG section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
    }




    @Test(description = "PRIVACY POLICY")
    public void PRIVACY_POLICY() {
        test = extent.createTest("PRIVACY POLICY").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.PRIVACY_POLICY();
        test.info("Check PRIVACY POLICY section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
    }




    @Test(description = "ACCOUNT, PAYOUTS, BONUSES")
    public void ACCOUNT_PAYOUTS_BONUSES() {
        test = extent.createTest("ACCOUNT, PAYOUTS, BONUSES").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.ACCOUNT_PAYOUTS_BONUSES();
        test.info("Check ACCOUNT, PAYOUTS, BONUSES section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
    }




    @Test(description = "KYC POLICIES, PRIVACY AND MANAGEMENT OF PERSONAL DATA")
    public void KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA() {
        test = extent.createTest("KYC POLICIES, PRIVACY AND MANAGEMENT OF PERSONAL DATA").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA();
        test.info("Check KYC POLICIES, PRIVACY AND MANAGEMENT OF PERSONAL DATA section functional");
        Assert.assertTrue(footer.Content.isDisplayed());
    }



    @Test(description = "SPORTSBOOK")
    public void PREMIER_LEAGUE() throws InterruptedException, AWTException {
        test = extent.createTest("PREMIER LEAGUE").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.PREMIER_LEAGUE();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, PREMIER_LEAGUE_URL);
    }

    @Test(description = "SPORTSBOOK")
    public void LIGUE_1() throws InterruptedException, AWTException {
        test = extent.createTest("LIGUE 1").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.LIGUE_1();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, LIGUE_1_URL);
    }

    @Test(description = "SPORTSBOOK")
    public void BUNDESLIGA() throws InterruptedException {
        test = extent.createTest("BUNDESLIGA").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.BUNDESLIGA();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, BUNDESLIGA_URL);
    }

    @Test(description = "SPORTSBOOK")
    public void SERIE_A() throws InterruptedException {
        test = extent.createTest("SERIE A").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.SERIE_A();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, SERIE_A_URL);
    }


    @Test(description = "SPORTSBOOK")
    public void CHAMPIONS_LEAGUE() throws InterruptedException {
        test = extent.createTest("CHAMPIONS LEAGUE").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.CHAMPIONS_LEAGUE();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, CHAMPIONS_LEAGUE_URL);
    }



    @Test(description = "CASINO & LIVE CASINO")
    public void EVOLUTION() throws InterruptedException, IOException {
        LiveCasino liveCasino = new LiveCasino();
        test = extent.createTest("EVOLUTION").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.EVOLUTION();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, liveCasino.Evolution_URL);
    }

    @Test(description = "CASINO & LIVE CASINO")
    public void EZUGI() throws InterruptedException, IOException {
        LiveCasino liveCasino = new LiveCasino();
        test = extent.createTest("EZUGI").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.EZUGI();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, liveCasino.Ezugi_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void BINGO_37() throws InterruptedException, IOException {
        test = extent.createTest("BINGO 37").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.BINGO_37();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, BINGO_37_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void KENO() throws InterruptedException, IOException {
        test = extent.createTest("KENO").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.KENO();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, KENO_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void CRASH() throws InterruptedException, IOException {
        test = extent.createTest("CRASH").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.CRASH();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, CRASH_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void HIGH_LOW() throws InterruptedException, IOException {
        test = extent.createTest("HIGH LOW").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.HIGH_LOW();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, HIGH_LOW_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void BET_ON_RACING() throws InterruptedException, IOException {
        test = extent.createTest("BET ON RACING").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.BET_ON_RACING();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, BET_ON_RACING_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void BET_ON_POKER() throws InterruptedException, IOException {
        test = extent.createTest("BET ON POKER").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.BET_ON_POKER();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, BET_ON_POKER);
    }

    @Test(description = "VIRTUAL GAMES")
    public void BINGO_47() throws InterruptedException, IOException {
        test = extent.createTest("BINGO 47").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.BINGO_47();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, BINGO_47_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void COLORS() throws InterruptedException, IOException {
        test = extent.createTest("COLORS").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.COLORS();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, COLORS_URL);
    }

    @Test(description = "VIRTUAL GAMES")
    public void MINESWEEPER() throws InterruptedException, IOException {
        test = extent.createTest("MINESWEEPER").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.MINESWEEPER();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, MINESWEEPER_URL);
    }

    @Test(enabled = false)
    public void Payment_icons() {
        test = extent.createTest("Social Icons").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Footer_Page footer = new Footer_Page();
        footer.Payment_icons();

    }
}








