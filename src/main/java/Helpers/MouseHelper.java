package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHelper {
    Actions action;
    WebElement element;

    public void MouseHover(WebDriver driver, By locator) {
        action = new Actions(driver);
        element = driver.findElement(locator);
        action.moveToElement(element).build().perform();
    }

    public void MouseHoverClick(WebDriver driver, By locator) {
        action = new Actions(driver);
        element = driver.findElement(locator);
        action.moveToElement(element).click().build().perform();
    }
}
