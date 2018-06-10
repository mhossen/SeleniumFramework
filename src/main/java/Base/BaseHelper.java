package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    public WebDriver driver;
    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }
}
