package TestScripts;

import Base.BaseDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {

    @Test
    public void TestLogin() throws InterruptedException {
        getClassRepo().get_navigation().NavigateToUrl("http://opensource.demo.orangehrmlive.com/");
        Thread.sleep(2000);
        getPageRepo().loginPage.Login("admin", "admin");
        Thread.sleep(10 + 000);
    }
}
