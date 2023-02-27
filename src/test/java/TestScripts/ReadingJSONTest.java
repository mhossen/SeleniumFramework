package TestScripts;

import base.BaseDriver;
import helpers.JsonReader;
import Settings.PropertyKeys;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReadingJSONTest extends BaseDriver {
    @Test
    public void jsonTest() throws IOException, ParseException {
        String path = "\\src\\main\\resources\\config.json";
        JsonReader jsonReader = new JsonReader(path);
        System.out.println(jsonReader.getValue(PropertyKeys.Browser));
        System.out.println(jsonReader.getValue(PropertyKeys.UserName));
        System.out.println(jsonReader.getValue(PropertyKeys.Password));
    }
}
