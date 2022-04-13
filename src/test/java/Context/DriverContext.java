package Context;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class DriverContext {
  private final Select select;
  private final int maxTimeOutMinute;
  private final int maxMilliSeconds;
  private final WebDriver driver;
  private WebElement element;
  private List<WebElement> elements;
  private final Actions actions;


  private DriverContext(DriverContextBuilder builder) {
    this.driver = builder.driver;
    this.element = builder.element;
    this.elements = builder.elements;
    this.select = builder.select;
    this.actions = builder.actions;
    this.maxTimeOutMinute = builder.maxTimeOutMinute;
    this.maxMilliSeconds = builder.maxMilliSeconds;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public Actions getActions() {
    return actions;
  }


  public List<WebElement> getElements() {
    return elements;
  }

  public Select getSelect() {
    return select;
  }

  public WebElement getElement() {
    return element;
  }

  public WebElement withId(String id) {
    return activeElement(By.id(id)).getElement();
  }

  public WebElement withCss(String css) {
    return activeElement(By.cssSelector(css)).getElement();
  }

  public WebElement withXpath(String xpath) {
    return activeElement(By.xpath(xpath)).getElement();
  }

  public List<WebElement> withAllCss(String css) {
    return activeElements(By.cssSelector(css)).getElements();
  }

  public List<WebElement> withAllXpath(String xpath) {
    return activeElements(By.xpath(xpath)).getElements();
  }

  private DriverContext activeElement(By locateBy) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
            .withTimeout(Duration.ofMinutes(maxTimeOutMinute))
            .pollingEvery(Duration.ofMillis(maxMilliSeconds))
            .withMessage(String.format("Max time of %s minute(s) reached, retried to locate element every %s milli seconds and failed to find element: %s"
                    , maxTimeOutMinute
                    , maxMilliSeconds
                    , locateBy))
            .ignoring(NoSuchElementException.class);

    this.element = (WebElement) wait.until(e ->
            e.findElement(locateBy).isEnabled() || e.findElement(locateBy).isDisplayed()
                    ? e.findElement(locateBy)
                    : new NoSuchElementException("No such element exist"));
    return this;
  }

  private DriverContext activeElements(By locateBy) {
    Wait<WebDriver> wait = new FluentWait(getDriver())
            .withTimeout(Duration.ofMinutes(maxTimeOutMinute))
            .pollingEvery(Duration.ofMillis(maxMilliSeconds))
            .withMessage(String.format("Max time of %s minute(s) reached, retried to locate element every %s milli seconds and failed to find element: %s"
                    , maxTimeOutMinute
                    , maxMilliSeconds
                    , locateBy))
            .ignoring(NoSuchElementException.class);

    this.elements = (List<WebElement>) wait.until(d -> {
      List<WebElement> elements = d.findElements(locateBy);

      return elements.stream().anyMatch(e -> e.isDisplayed() || e.isEnabled()) || elements.size() > 0
              ? elements
              : new NoSuchElementException("Unable to locate elements: " + locateBy.toString());
    });
    return this;
  }

  public void dispose() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }


  public static class DriverContextBuilder {
    private WebDriver driver;
    private WebElement element;
    private List<WebElement> elements;
    private Select select;
    private Actions actions;
    private int maxTimeOutMinute;
    private int maxMilliSeconds;

    public DriverContextBuilder createBrowserInstance(BrowserType browserType) {
      if (driver != null) return this;

      if (browserType.equals("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
      } else if (browserType.equals("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      } else {
        throw new IllegalArgumentException("No definition or implementation created for browser type: " + browserType);
      }

      driver.manage().window().maximize();
      return this;
    }

    public DriverContextBuilder setMaxTimeOut(int minutes) {
      this.maxTimeOutMinute = minutes;
      return this;
    }

    public DriverContextBuilder setRetryInterval(int milliSeconds) {
      this.maxMilliSeconds = milliSeconds;
      return this;
    }

    public DriverContext build() {
      return new DriverContext(this);
    }
  }


}
