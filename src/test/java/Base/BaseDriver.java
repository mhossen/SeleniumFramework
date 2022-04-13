package Base;

import Configuration.PropertyKeyReader;
import Context.DriverContext;
import Interface.IConfig;
import Settings.ClassRepo;
import Settings.ObjectRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseDriver extends ObjectRepo {
    //public WebDriver driver;
    protected DriverContext driverContext;
    private ClassRepo _classRepo;
    public GenericPage pages;
    public ClassRepo getClassRepo() {
        _classRepo = new ClassRepo(driver);
        return _classRepo;
    }



    @BeforeSuite
    public void InitDriver() throws IOException {
        IConfig config = new PropertyKeyReader();
//        if (driver == null) {
//            switch (config.getBrowser()) {
//                case "Chrome":
//                    GetChromeDriver();
//                    break;
//                case "Firefox":
//                    GetFirefoxDriver();
//                    break;
//                default:
//                    throw new WebDriverException("Browser driver is not created");
//            }
//        }
//        // BrowserHelper browser = new BrowserHelper();
//        getClassRepo().get_browser().BrowserMaximize();

        driverContext = new DriverContext.DriverContextBuilder()
                .setMaxTimeOut(1)
                .setRetryInterval(250)
                .createBrowserInstance(config.getBrowser() instanceof BrowserType)
                .build();
    }

    @BeforeMethod
    public void testSetup() {
        pages = new GenericPage(driverContext);
           }

    @AfterSuite
    public void TearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
