package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepo {
    public WebDriver driver;
    public WebDriver set_driver(WebDriver _driver) {
        this.driver = _driver;
        return driver;
    }

}
