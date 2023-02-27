package TestScripts;

import base.BaseDriver;
import helpers.FileHelper;
import helpers.HttpHelper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CheckUrlStatusTest extends BaseDriver {
    String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\ListOfUrl.txt";
    List<String> urls = Collections.emptyList();
    FileHelper fileReader = new FileHelper(fileName);
    HttpHelper httpHelper = new HttpHelper();


    @Test
    public void StatusTest() throws IOException {
        urls = fileReader.GetAllLineAsList();

        for (String url : urls) {
            getClassRepo().get_navigation().NavigateToUrl(url);
            System.out.println(httpHelper.GetStatusCode(url));
        }
    }
}
