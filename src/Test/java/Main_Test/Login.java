package Main_Test;

import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends BaseClass {

    String randomGmail = faker.name().firstName() + faker.name().lastName() + "@gmail.com";
    String randomPassword = faker.name().firstName() + ".12345";

    public Login() throws IOException {
    }

    @DataProvider(name = "invalid_login_credentials")
    public Object[][] getData() {

        Object[][] data = new Object[7][2];

        data[0][0] = randomGmail;
        data[0][1] = randomPassword;

        data[1][0] = "sdfsadf@gmail.com";
        data[1][1] = "Avengers5844521";

        data[2][0] = "h.hambardzumyan@iqsoft.am";
        data[2][1] = "";

        data[3][0] = "";
        data[3][1] = "Test12345";

        data[4][0] = "sdfsadf@gmail.com";
        data[4][1] = randomPassword;

        data[5][0] = randomGmail;
        data[5][1] = "Avengers5844521";

        data[6][0] = "H.HAMBARDZUMYAN@IQSOFT.AM";
        data[6][1] = "Test12345";

        return data;
    }


    @Test(priority = 1, dataProvider = "invalid_login_credentials", description = "invalid login password")
    public void verify_Invalid_Login_Credentials(String testUsername, String testPassword) {
        test = extent.createTest("verifyInvalidLoginCredentials").assignCategory("Functional Test").assignDevice("Windows");
        Login_Pages login = new Login_Pages();
        login.Choose_ENG_Click_SignIn();
        login.typeUsername(testUsername);
        test.info(testUsername + " --->  Entering invalid username");
        login.typePassword(testPassword);
        test.info(testPassword + " --->  Entering invalid password");


        try {
            login.clickSignIn();
            test.info("Click Sign in button");
            Assert.assertTrue(true);

        } catch (Exception e) {
            test.fail("Unable to click Sign in button");
            Assert.assertTrue(true);
        }


        try {
            String error_message = login.invalid_Login_Password_error_message();
            Assert.assertEquals(error_message, "Username or Password is incorrect. Please try again.");
            test.pass(error_message + " ---> " + " message is Displayed");
            Assert.assertTrue(true);
            } catch (Exception e) {
            test.fail(" Username or Password is incorrect ---> message is not Displayed");
            Assert.fail();
        }
    }


    @DataProvider(name = "valid_data")
    public Object[][] getData1() {
        return new Object[][]{
                {"h.hambardzumyan@iqsoft.am", "Test12345"},

        };
    }

    @Test(priority = 2, dataProvider = "valid_data", description = "Valid login password")
    public void Valid_Login_Credentials(String testUsername, String testPassword) {
        test = extent.createTest("VerifyValidLoginCredentials").assignCategory("Functional Test").assignDevice("Windows");
        Login_Pages login = new Login_Pages();
        login.Choose_ENG_Click_SignIn();
        login.typeUsername(testUsername);
        test.info(testUsername + "---> Entering valid username");
        login.typePassword(testPassword);
        test.info(testPassword + "---> Entering valid password");

        try {
            login.clickSignIn();
            test.info("Click Sign in button");
            Assert.assertTrue(true);
        } catch (Exception e) {
            test.fail("Unable to click Sign in button");
            Assert.fail();
        }

        try {
            if (login.Verify_UserID_is_Displayed()) {
                test.pass("User succesfully Logined");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            test.fail("User is not Logined");
            Assert.fail();
        }
    }


    @DataProvider(name = "Password_recovery_invalid_data")
    public Object[][] getData2() {

        return new Object[][]{
                {randomGmail},
                {"@gmailo.com"},
                {"0000@gmail"},
                {"dsfsfsdfssdfsdfsdjfsdfsdfsdfjhkjhkjhjkhk@gmail.com"},
                {"AAAA578A*@gmail.com"},
                {"rtt AAAA@gmail.com"},

        };
    }


    @Test(priority = 3, dataProvider = "Password_recovery_invalid_data", description = "Password recovery")
    public void invalid_credentials_Password_recovery_page(String testUsername) {
        test = extent.createTest("Invalid data in Password recovery page").assignCategory("Functional Test").assignDevice("Windows");
        Login_Pages login = new Login_Pages();
        login.Choose_ENG_Click_SignIn();
        login.Open_Recovery_Page();
        login.typeUsername(testUsername);
        test.info(testUsername + "---> Entering invalid Gmail");

        try {
            login.Send_Me_Recovery_Link_btn();
            test.info("Click Send Me Recovery button");
            Assert.assertTrue(true);
        } catch (Exception e) {
            test.fail("Unable to click Send Me Recovery button");
            Assert.fail();
        }

        try {
            String error_message = login.Wrong_recovery_input_text();
            Assert.assertEquals(error_message, "Wrong recovery input");
            test.pass(error_message + " ---> " + " message is Displayed");
            Assert.assertTrue(true);
        } catch (Exception e) {
            test.fail("Password recovery is in Process! section is  Displayed || Should be Wrong recovery input text ");
            Assert.fail();
        }
    }
}


