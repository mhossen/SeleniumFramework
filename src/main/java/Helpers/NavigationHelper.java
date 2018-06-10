package Helpers;

import Base.BaseHelper;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void NavigateToUrl(String url) {
        driver.navigate().to(url);
    }
}
