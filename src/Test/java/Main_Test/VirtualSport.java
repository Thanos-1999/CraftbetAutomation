package Main_Test;

import PageObjects.Login_Pages;
import PageObjects.VirtualSport_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class VirtualSport extends BaseClass {

    String Virtual_Games_URL = "https://craftbet.com/products/7346/60001/real";

    @BeforeMethod
    public void LoginSystem() throws InterruptedException {
        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
            //Open Virtual Sport Page
            login.Virtual_Sport();
        } catch (Exception err) {
            test.info("Unable to Login");
            Assert.fail();
        }
    }

    @Test(description = "Virtual Sport section")
    public void Virtual_Sport_Games_functional() throws InterruptedException, IOException {
        test = extent.createTest("Virtual Sport section functional").assignCategory("Functional Main_Test.Main_Test.Test").assignDevice("Windows");
        VirtualSport_Page virtual = new VirtualSport_Page();
        test.info("Open Virtual Games Page");

        if (virtual.is_VirtualSport_Section_Displayed()) {
            test.pass("Games displayed successfully");
            Assert.assertTrue(true);
        } else {
            test.fail("Games are not displayed");
            Assert.fail();
        }

        Assert.assertEquals(driver.getCurrentUrl(), Virtual_Games_URL);
        test.info("Compare CurrentUrl to Virtual Games URL");

        Assert.assertTrue(virtual.is_Sport_present());
        test.info("Verify SPORT section is present");

        Assert.assertTrue(virtual.is_Games_present());
        test.info("Verify GAMES section is present");

    }
}