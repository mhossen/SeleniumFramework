package Pages;

import base.BasePage;
import Context.DriverContext;
import Settings.ClassRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    ClassRepo repo;

    public HomePage(DriverContext driverContext) {
        super(driverContext);
        repo = new ClassRepo(driverContext.getDriver());
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement menuAdmin;

    @FindBy(id = "menu_admin_UserManagement")
    private WebElement menuUserManagement;

    @FindBy(id = "menu_admin_viewSystemUsers")
    private WebElement menuUser;

    public void goToUser() {
        repo.get_mouse().MouseHover(menuAdmin);
        repo.get_mouse().MouseHover(menuUserManagement);
        repo.get_mouse().MouseHoverClick(menuUser);
    }
}
