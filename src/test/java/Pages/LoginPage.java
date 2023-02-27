package Pages;

import base.BasePage;
import Context.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(DriverContext driverContext) {
        super(driverContext);
    }

    @FindBy(id = "txtUsername")
    private WebElement txtUserName;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    public void Login(String userName, String password) {
        writeText(txtUserName, userName);
        writeText(txtPassword, password);
        click(btnLogin);
    }
}
