package Base;

import Settings.ClassRepo;
import Settings.ObjectRepo;
import Settings.PageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver extends ObjectRepo {
    public ClassRepo repo = new ClassRepo();
    public PageRepo pageRepo = new PageRepo();

    private WebDriver GetChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "K:\\Drivers\\chromedriver.exe");
        setDriver(new ChromeDriver());
        return driver;
    }

    private WebDriver GetFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "K:\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeSuite
    public void InitDriver() {
        if (driver == null) {
            GetChromeDriver();
        }
        repo.browser.BrowserMaximize(driver);
    }

    @AfterSuite
    public void TearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
