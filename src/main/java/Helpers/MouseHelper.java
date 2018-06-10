package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHelper {
    private Actions _action;
    private WebElement _element;
    private WebDriver _driver;

    public MouseHelper(WebDriver driver) {
        this._driver = driver;
    }

    public void MouseHover(By locator) {
        _action = new Actions(_driver);
        _element = _driver.findElement(locator);
        _action.moveToElement(_element).build().perform();
    }

    public void MouseHoverClick(By locator) {
        _action = new Actions(_driver);
        _element = _driver.findElement(locator);
        _action.moveToElement(_element).click().build().perform();
    }
}
