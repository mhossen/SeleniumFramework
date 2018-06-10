package TestScripts;

import Base.BaseDriver;
import Helpers.NavigationHelper;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class LoginTest extends BaseDriver {

    @Test
    public void TestLogin() throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        getClassRepo().get_navigation().NavigateToUrl("http://opensource.demo.orangehrmlive.com/");
        Thread.sleep(2000);
        pages.getInstance(LoginPage.class).Login("admin", "admin");
        Thread.sleep(10 + 000);
    }
}
