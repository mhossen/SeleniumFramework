package helpers;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private final String filePath;

    public JsonReader(String path) {
        this.filePath = path;
    }

    public String getValue(String name) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + filePath));
        JSONObject jObject = (JSONObject) obj;
        return (String) jObject.get(name);
    }
}
