package Settings;

import Configuration.PropertyKeyReader;
import Helpers.BrowserHelper;
import Helpers.MouseHelper;
import Helpers.NavigationHelper;
import Interface.IConfig;
import org.openqa.selenium.WebDriver;

public class ClassRepo {
    private WebDriver _driver;
    private BrowserHelper _browser;
    private MouseHelper _mouse;
    private NavigationHelper _navigation;
    private IConfig _config;

    public IConfig get_config() {
        _config = new PropertyKeyReader();
        return _config;
    }

    public ClassRepo(WebDriver driver) {
        this._driver = driver;
    }

    public BrowserHelper get_browser() {
        _browser = new BrowserHelper(_driver);
        return _browser;
    }

    public MouseHelper get_mouse() {
        _mouse = new MouseHelper(_driver);
        return _mouse;
    }

    public NavigationHelper get_navigation() {
        _navigation = new NavigationHelper(_driver);
        return _navigation;
    }
}
