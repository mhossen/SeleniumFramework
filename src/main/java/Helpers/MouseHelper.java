package Helpers;

import Base.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHelper extends BaseHelper {
    private Actions _action;
    private WebElement _element;

    public MouseHelper(WebDriver driver) {
        super(driver);
    }

    public <T> void MouseHover(T elementAttr) {
        _action = new Actions(driver);
        if (elementAttr.getClass().getName().contains("By")) {
            _element = driver.findElement((By) elementAttr);
            _action.moveToElement(_element).build().perform();
        } else {
            _action.moveToElement(_element).build().perform();
        }
    }

    public void MouseHover(WebElement element) {
        _action = new Actions(driver);
        _action.moveToElement(element).build().perform();
    }

    public <T> void MouseHoverClick(T elementAttr) {
        _action = new Actions(driver);
        if (elementAttr.getClass().getName().contains("By")) {
            _element = driver.findElement((By) elementAttr);
            _action.moveToElement(_element).click().build().perform();
        } else {
            _action.moveToElement(_element).click().build().perform();
        }
    }

    public void MouseHoverClick(WebElement element) {
        _action = new Actions(driver);
        _action.moveToElement(element).click().build().perform();
    }
}
