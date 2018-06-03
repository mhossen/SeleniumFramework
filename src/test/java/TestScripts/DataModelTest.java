package TestScripts;

import Base.BaseDriver;
import Model.MyDataModel;
import org.testng.annotations.Test;

import java.util.*;
import java.util.ArrayList;

public class DataModelTest extends BaseDriver {
    @Test
    public void Test() {

        Vector<MyDataModel> dms = new Vector<MyDataModel>();

        List<String> urls = new ArrayList<String>();
        urls.add("https://www.google.com");
        urls.add("https://www.amazon.com");
        for (int i = 0; i < urls.size(); i++) {
            repo.navigation.NavigateToUrl(driver, urls.get(i));
            MyDataModel dm = new MyDataModel() {
                {
                    Title = driver.getTitle();
                    Url = driver.getCurrentUrl();
                }

            };
            dms.add(dm);
        }
        for (MyDataModel model : dms) {
            System.out.println("Page title:" + model.Title + " page url: " + model.Url);

        }

    }
}