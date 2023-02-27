package base;

import Context.DriverContext;
import org.openqa.selenium.support.PageFactory;

public class GenericPage {
  //  public WebDriver driver;
protected DriverContext driverContext;
    public GenericPage(DriverContext driverContext) {
        this.driverContext = driverContext;
    }

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driverContext.getDriver(), pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
