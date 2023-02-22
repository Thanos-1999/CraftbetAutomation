
package Utills.driver;

import Utills.config.ConfigurationManager;
import Utills.exceptions.HeadlessNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static Utills.config.ConfigurationManager.configuration;
import static java.lang.Boolean.TRUE;

public enum BrowserFactory {


    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(START_MAXIMIZED);
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.setHeadless(ConfigurationManager.configuration().headless());
//          Mobile Emulation
//
//          Map<String, String> mobileEmulation = new HashMap<>();
//          mobileEmulation.put("deviceName", "iPhone 8");
//          chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            return chromeOptions;
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(START_MAXIMIZED);
            firefoxOptions.addArguments("--window-size=1920,1080");
            firefoxOptions.setHeadless(ConfigurationManager.configuration().headless());
            return firefoxOptions;
        }
    },


    EDGE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();

            return new EdgeDriver(getOptions());
        }


        @Override
        public EdgeOptions getOptions() {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments(START_MAXIMIZED);
            edgeOptions.addArguments("--window-size=1920,1080");
            edgeOptions.setHeadless(ConfigurationManager.configuration().headless());
            return edgeOptions;
        }




    }, SAFARI {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();

            return new SafariDriver(getOptions());
        }
        @Override
        public SafariOptions getOptions() {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);

            if (TRUE.equals(ConfigurationManager.configuration().headless()))
                throw new HeadlessNotSupportedException();

            return safariOptions;
        }
    };


    private static final String START_MAXIMIZED = "--start-maximized";

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}
