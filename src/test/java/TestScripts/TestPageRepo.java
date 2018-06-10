package TestScripts;

import Base.BaseDriver;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPageRepo extends BaseDriver {

    @Test
    public void TestRepo() throws IOException, InterruptedException {
        getClassRepo().get_navigation().NavigateToUrl(getClassRepo().get_config().getWebSite());
        Thread.sleep(5000);
        pages.getInstance(LoginPage.class).Login(getClassRepo().get_config().getUsername(), getClassRepo().get_config().getPassword());
        Thread.sleep(5000);
    }
}
