package Main_Test;

import Main_Test.Rerun_Failed_Test.Retry;
import PageObjects.Casino_Logic;
import PageObjects.Casino_Page;
import PageObjects.Login_Pages;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Casino extends BaseClass {

    @BeforeMethod
    public void LoginSystem_Open_Casino() throws InterruptedException {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Casino Page
            login.Casino();
        } catch (Exception err) {
            System.out.println("Unable to Login");
            Assert.fail();
        }
    }


    @Test(enabled = false)
    public void Getting_filenames_of_Casino_Games() {

        test = extent.createTest("Getting the filenames of all files in Casino folder");
        File folder = new File("C:\\Users\\Hayk Hambardzumyan\\Desktop\\CRAFTBET_CASINO\\Game.Amatic");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                test.info("File " + listOfFiles[i].getName());
              } else if (listOfFiles[i].isDirectory()) {
                test.info("Directory " + listOfFiles[i].getName());
            }
        }
    }

    @Test(description = "Top Games", retryAnalyzer = Retry.class)
    public void Casino_Favorite_Games() throws InterruptedException, AWTException {
        test = extent.createTest("Casino Top Games").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Page casino_craftBet = new Casino_Page();
        casino_craftBet.Search_Work("Wild West Gold");
        test.info("Search: Wild West Gold Game");
        String Top_Game = casino_craftBet.Casino_Searched_text();
        test.info("Capture game text from Search result :" + " " + Top_Game);
        casino_craftBet.Click_Game_Star();
        test.info("Click " + Top_Game + " game star");
        casino_craftBet.Click_Top_btn();
        test.info("Open Favorite Section");

        if (driver.getPageSource().contains(Top_Game)) {
            test.pass("Favorite section functional works: " + Top_Game + " is  displayed in Favorite section");
            Assert.assertTrue(true);
        } else {
            test.fail("Favorite section functional is not working: " + Top_Game + " is not displayed in Favorite section");
            Assert.fail();
        }
    }

    @DataProvider(name = "Casino_Searched_Games_List")
    public Object[][] Games() {
        return new Object[][]{
                //Search Mentioned Games
                {"Gates of Olympus"},
                {"Sweet Bonanza"},
                {"Fire Strike 2"},
                {"Goblin Heist Powernudge"},
        };
    }


    @Test(priority = 0, description = "Check Casino Search Regression", retryAnalyzer = Retry.class, dataProvider = "Casino_Searched_Games_List")
    public void CasinoSearch(String GameName) throws InterruptedException, AWTException {
        test = extent.createTest("Casino Search Work").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Page casino_craftBet = new Casino_Page();
        casino_craftBet.Search_Work(GameName);
        test.info("Type in Search input field: " + GameName);
        String Actualresult = casino_craftBet.Casino_Searched_text();
        test.info("Capture Search Result");
        Assert.assertEquals(GameName, Actualresult);
        test.pass("Expected Search Result: ---> " + GameName + " || " + "Actual Search result: ---> " + Actualresult);
    }


    @Test(description = "AMATIC")
    public void AMATIC() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("AMATIC Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("AMATIC");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = " Specific Casino Game Bet")
    public void Specific_Game_Bet() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Specific Casino Game Bet").assignDevice("Windows");
        Casino_Page casino_craftBet = new Casino_Page();
        casino_craftBet.Search_Work("Bomb Bonanza");
        test.info("Open Casino and Search mentioned game: Bomb Bonanza");
        casino_craftBet.Hover_Casino_Game_click_Play();
        test.info("Open Game");
        Actions action = new Actions(driver);

        try {
            action.sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(4000);
            } catch (Exception e) {
        }

//        Screen screen = new Screen() ;
//
//        try {
//            for (int z = 0; z < 1000; z++) {
//                screen.find("D:\\Downloads\\bet.png"); //identify pause button
//                screen.click("D:\\Downloads\\bet.png"); //click pause button
//                Thread.sleep(1000);
//                test.info("Bet button clicked " + z);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Unable to click Bet button");
//        }


        try   {
            for (int z = 0; z < 1000; z++) {
                action.sendKeys(Keys.SPACE).build().perform();
                Thread.sleep(60000);
                test.info("Bet button clicked "+ z);
                }
        }  catch (Exception e) {
            System.out.println("Unable to click Bet button");
        }
    }



    @Test(description = "Betsoft", retryAnalyzer = Retry.class)
    public void Betsoft() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Betsoft Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Betsoft");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "BoomingGames", retryAnalyzer = Retry.class)
    public void BoomingGames() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("BoomingGames Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("BoomingGames");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Booongo", retryAnalyzer = Retry.class)
    public void Booongo() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Booongo Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Booongo");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Edict", retryAnalyzer = Retry.class)
    public void Edict() throws IOException, InterruptedException, AWTException, AWTException {
        test = extent.createTest("Edict Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Edict");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "EGT", retryAnalyzer = Retry.class)
    public void EGT() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("EGT Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("EGT");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }



    @Test(description = "Evolution", retryAnalyzer = Retry.class)
    public void Evolution() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Evolution Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Evolution");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Evoplay", retryAnalyzer = Retry.class)
    public void Evoplay() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Evoplay Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("EvoPlay");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Fugaso", retryAnalyzer = Retry.class)
    public void Fugaso() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Fugaso Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Fugaso");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "GameArt", retryAnalyzer = Retry.class)
    public void GameArt() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("GameArt Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("GameArt");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Genii", retryAnalyzer = Retry.class)
    public void Genii() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Genii Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Genii");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "GMW", retryAnalyzer = Retry.class)
    public void GMW() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("GMW Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("GMW");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Greentube", retryAnalyzer = Retry.class)
    public void Greentube() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Greentube Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Greentube");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Habanero", retryAnalyzer = Retry.class)
    public void Habanero() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Habanero Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Habanero");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Igrosoft", retryAnalyzer = Retry.class)
    public void Igrosoft() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Igrosoft Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Igrosoft");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");

    }

    @Test(description = "IGT", retryAnalyzer = Retry.class)
    public void IGT() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("IGT Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("IGT");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");

    }

    @Test(description = "InBet", retryAnalyzer = Retry.class)
    public void InBet() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("InBet Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("InBet");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");

    }

    @Test(description = "ISoftBet", retryAnalyzer = Retry.class)
    public void ISoftBet() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ISoftBet Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("ISoftBet");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");

    }

    @Test(description = "Leander", retryAnalyzer = Retry.class)
    public void Leander() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Leander Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Leander");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Mascot", retryAnalyzer = Retry.class)
    public void Mascot() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Mascot Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Mascot");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Microgaming", retryAnalyzer = Retry.class)
    public void Microgaming() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Microgaming Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Microgaming");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "MrSlotty", retryAnalyzer = Retry.class)
    public void MrSlotty() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("MrSlotty Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("MrSlotty");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "NetEnt", retryAnalyzer = Retry.class)
    public void NetEnt() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("NetEnt Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("NetEnt");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
        casino_logic.Provider_Games_List();
    }


    @Test(description = "NoLimitCity", retryAnalyzer = Retry.class)
    public void NoLimitCity() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("NoLimitCity Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("NoLimitCity");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Novomatic", retryAnalyzer = Retry.class)
    public void Novomatic() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Novomatic Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Novomatic");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "NYX", retryAnalyzer = Retry.class)
    public void NYX() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("NYX Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("NYX");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "PariPlay", retryAnalyzer = Retry.class)
    public void PariPlay() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PariPlay Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("PariPlay");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }

    @Test(description = "PlaynGo", retryAnalyzer = Retry.class)
    public void PlaynGo() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PlaynGo Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("PlaynGo");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "PlaysonDirect", retryAnalyzer = Retry.class)
    public void PlaysonDirect() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PlaysonDirect Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("PlaysonDirect");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }

    @Test(description = "PragmaticPlay", retryAnalyzer = Retry.class)
    public void PragmaticPlay() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PragmaticPlay Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("PragmaticPlay");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "PushGaming")
    public void PushGaming() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("PushGaming Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("PushGaming");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked ");
    }


    @Test(description = "RedTiger", retryAnalyzer = Retry.class)
    public void RedTiger() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("RedTiger Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("RedTiger");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "SoftGaming", retryAnalyzer = Retry.class)
    public void SoftGaming() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("SoftGaming Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("SoftGaming");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Spadegaming", retryAnalyzer = Retry.class)
    public void Spadegaming() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Spadegaming Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Spadegaming");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Thunderkick", retryAnalyzer = Retry.class)
    public void Thunderkick() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Thunderkick Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Thunderkick");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "TomHorn", retryAnalyzer = Retry.class)
    public void TomHorn() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("TomHorn Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("TomHorn");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "TwoWinPower", retryAnalyzer = Retry.class)
    public void TwoWinPower() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("TwoWinPower Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("TwoWinPower");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
        casino_logic.Provider_Games_List();
    }


    @Test(description = "WACS", retryAnalyzer = Retry.class)
    public void WACS() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("WACS Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("WACS");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }



    @Test(description = "Wazdan", retryAnalyzer = Retry.class)
    public void Wazdan() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Wazdan Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Wazdan");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }




    @Test(description = "WorldMatch", retryAnalyzer = Retry.class)
    public void WorldMatch() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("WorldMatch Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("WorldMatch");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "Yggdrasil", retryAnalyzer = Retry.class)
    public void Yggdrasil() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Yggdrasil Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("Yggdrasil");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }


    @Test(description = "ZeusPlay", retryAnalyzer = Retry.class)
    public void ZeusPlay() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ZeusPlay Provider Games Check").assignCategory("Regression Test").assignDevice("Windows");
        Casino_Logic casino_logic = new Casino_Logic();
        casino_logic.Search_and_Open_Casino_Provider("ZeusPlay");
        casino_logic.CasinoLogic();
        test.info(casino_logic.GamesCount_BrokenImages());
        test.info("Provider Games Screenshots/Broken Images checked");
    }
}









