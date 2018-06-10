package Helpers;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private String filePaht;

    public JsonReader(String path) {
        this.filePaht = path;
    }

    public String getValue(String name) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + filePaht));
        JSONObject jObject = (JSONObject) obj;
        return (String) jObject.get(name);
    }
}
