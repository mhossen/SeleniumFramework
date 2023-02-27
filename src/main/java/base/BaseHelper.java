package base;

import org.openqa.selenium.WebDriver;

public class BaseHelper {
    public WebDriver driver;
    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }
}
