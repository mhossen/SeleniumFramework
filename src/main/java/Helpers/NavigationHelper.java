package Helpers;

import Settings.ObjectRepo;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    public void NavigateToUrl(WebDriver driver, String url) {
        driver.navigate().to(url);
    }
}
