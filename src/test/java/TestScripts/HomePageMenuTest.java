package TestScripts;

import Base.BaseDriver;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageMenuTest extends BaseDriver {
    @Test
    public void NavigateToUserTest() throws IOException, InterruptedException {
        getClassRepo().get_navigation().NavigateToUrl(getClassRepo().get_config().getWebSite());
        pages.getInstance(LoginPage.class).Login(getClassRepo().get_config().getUsername(),getClassRepo().get_config().getPassword());
        Thread.sleep(2000);
        pages.getInstance(HomePage.class).goToUser();
    }
}
