package Pages;

import Settings.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver _driver;

    public LoginPage(WebDriver driver) {
        this._driver = driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(id = "txtUsername")
    private WebElement txtUserName;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    public void Login(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
}
