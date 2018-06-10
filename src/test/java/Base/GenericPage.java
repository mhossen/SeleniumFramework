package Base;

import Settings.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GenericPage {
    public WebDriver driver;

    public GenericPage(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
