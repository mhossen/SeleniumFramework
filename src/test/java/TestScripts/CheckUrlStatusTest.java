package TestScripts;

import Base.BaseDriver;
import Helpers.FileHelper;
import Settings.ClassRepo;
import Settings.ObjectRepo;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class CheckUrlStatusTest extends BaseDriver {
    String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\ListOfUrl.txt";
    List<String> urls = Collections.emptyList();
    FileHelper fileReader = new FileHelper(fileName);

    @Test
    public void StatusTest() {
        urls = fileReader.GetAllLineAsList();

        for (String url : urls) {
            getClassRepo().get_navigation().NavigateToUrl(url);

            if (!driver.getTitle().toLowerCase().contains("server information")) {
                System.out.println(driver.getTitle());
            }
        }
    }
}
