package Helpers;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver _driver;
    public NavigationHelper(WebDriver driver){
        this._driver = driver;
    }
       public void NavigateToUrl(String url) {
        _driver.navigate().to(url);
    }
}
