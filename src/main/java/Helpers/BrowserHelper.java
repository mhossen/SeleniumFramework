package Helpers;

import Base.BaseHelper;
import org.openqa.selenium.WebDriver;

public class BrowserHelper extends BaseHelper {


    public BrowserHelper(WebDriver driver) {
       super(driver);
    }

    public void RefreshCurrentPage() {
        driver.navigate().refresh();
    }

    public void GoBack() {
        driver.navigate().back();
    }

    public void GoForward() {
        driver.navigate().forward();
    }

    public void BrowserMaximize() {
        driver.manage().window().maximize();
    }
}
