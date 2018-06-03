package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepo {
    public WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver get_driver() {
        return driver;
    }

    public WebElement element;

    public void set_element(WebElement _element) {
        this.element = _element;
    }

    public WebElement get_element() {
        return element;
    }
}
