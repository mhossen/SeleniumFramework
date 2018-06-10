package Helpers;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {

    private WebDriver _driver;

    public BrowserHelper(WebDriver driver) {
        this._driver = driver;
    }

    public void RefreshCurrentPage() {
        _driver.navigate().refresh();
    }

    public void GoBack() {
        _driver.navigate().back();
    }

    public void GoForward() {
        _driver.navigate().forward();
    }

    public void BrowserMaximize() {
        _driver.manage().window().maximize();
    }
}
