package Base;

import Configuration.PropertyKeyReader;
import Interface.IConfig;
import Settings.ClassRepo;
import Settings.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseDriver extends ObjectRepo {
    public WebDriver driver;
    private ClassRepo _classRepo;
    public GenericPage pages;
    public ClassRepo getClassRepo() {
        _classRepo = new ClassRepo(driver);
        return _classRepo;
    }


    private WebDriver GetChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "K:\\Drivers\\chromedriver.exe");
        driver = set_driver(new ChromeDriver());
        return driver;
    }

    private WebDriver GetFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "K:\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeSuite
    public void InitDriver() throws IOException {
        IConfig config = new PropertyKeyReader();
        if (driver == null) {
            switch (config.getBrowser()) {
                case "Chrome":
                    GetChromeDriver();
                    break;
                case "Firefox":
                    GetFirefoxDriver();
                    break;
                default:
                    throw new WebDriverException("Browser driver is not created");
            }
        }
        // BrowserHelper browser = new BrowserHelper();
        getClassRepo().get_browser().BrowserMaximize();
    }

    @BeforeMethod
    public void testSetup() {
        pages = new GenericPage(driver);
           }

    @AfterSuite
    public void TearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
