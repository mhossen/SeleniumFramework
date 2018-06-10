package Base;

import Configuration.PropertyKeyReader;
import Helpers.BrowserHelper;
import Helpers.NavigationHelper;
import Interface.IConfig;
import Settings.ClassRepo;
import Settings.ObjectRepo;
import Settings.PageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseDriver extends ObjectRepo {
    public WebDriver driver;
    private PageRepo _pageRepo;
    private ClassRepo _classRepo;

    public ClassRepo getClassRepo() {
        _classRepo = new ClassRepo(driver);
        return _classRepo;
    }

    public PageRepo getPageRepo() {
        _pageRepo = new PageRepo(driver);
        return _pageRepo;
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

    @AfterSuite
    public void TearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
