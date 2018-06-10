package Settings;

import org.openqa.selenium.WebDriver;

public class ObjectRepo {
    public WebDriver driver;

    public WebDriver set_driver(WebDriver _driver) {
        this.driver = _driver;
        return driver;
    }

}
