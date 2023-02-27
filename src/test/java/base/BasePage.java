package base;

import Context.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends GenericPage {
    public BasePage(DriverContext driverContext) {
        super(driverContext);
    }

    public <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driverContext.getDriver().findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            driverContext.getDriver().findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    public <T> String readText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            return driverContext.getDriver().findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    public void handlePopup (By by) throws InterruptedException {
        List<WebElement> popup = driverContext.getDriver().findElements(by);
        if(!popup.isEmpty()){
            popup.get(0).click();
            Thread.sleep(200);
        }
    }
}

