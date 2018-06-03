package TestScripts;

import Base.BaseDriver;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {
    @Test
    public void TestLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        repo.navigation.NavigateToUrl(driver, "http://opensource.demo.orangehrmlive.com/");
        Thread.sleep(2000);
        loginPage.Login("admin", "admin");
        Thread.sleep(10+000);
    }
}
