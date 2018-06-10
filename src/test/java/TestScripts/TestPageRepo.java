package TestScripts;

import Base.BaseDriver;
import Configuration.PropertyKeyReader;
import Helpers.NavigationHelper;
import Interface.IConfig;
import Settings.PageRepo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPageRepo extends BaseDriver {

    @Test
    public void TestRepo() throws IOException, InterruptedException {
        getClassRepo().get_navigation().NavigateToUrl(getClassRepo().get_config().getWebSite());
        Thread.sleep(5000);
        getPageRepo().loginPage.Login(getClassRepo().get_config().getUsername(), getClassRepo().get_config().getPassword());
        Thread.sleep(5000);
    }
}
