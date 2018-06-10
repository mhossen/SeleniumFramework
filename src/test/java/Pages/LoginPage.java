package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private WebDriver _driver;

    public LoginPage(WebDriver driver) {
        super(driver);
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
