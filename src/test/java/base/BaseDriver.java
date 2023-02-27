package base;

import configuration.PropertyKeyReader;
import Context.DriverContext;
import Interface.IConfig;
import Settings.ClassRepo;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public abstract class BaseDriver {
    //public WebDriver driver;
    protected DriverContext driverContext;
    private ClassRepo _classRepo;
    public GenericPage pages;
    public ClassRepo getClassRepo() {
        _classRepo = new ClassRepo(driverContext.getDriver());
        return _classRepo;
    }



    @BeforeSuite
    public void InitDriver() throws IOException {
        IConfig config = new PropertyKeyReader();
        driverContext = new DriverContext.DriverContextBuilder()
                .setMaxTimeOut(1)
                .setRetryInterval(250)
                .createBrowserInstance(config.getBrowser())
                .build();
    }

    @BeforeMethod
    public void testSetup() {
        pages = new GenericPage(driverContext);
           }

    @AfterSuite
    public void TearDown() {
        if (driverContext.getDriver() != null) {
            driverContext.getDriver().close();
            driverContext.getDriver().quit();
        }
    }
}
