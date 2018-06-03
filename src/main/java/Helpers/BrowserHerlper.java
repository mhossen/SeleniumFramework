package Helpers;

import org.openqa.selenium.WebDriver;

public class BrowserHerlper  {
    public void RefreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void GoBack(WebDriver driver) {
        driver.navigate().back();
    }

    public void GoForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void BrowserMaximize(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
