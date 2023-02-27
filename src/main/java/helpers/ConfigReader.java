package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties propFile = new Properties();
    private static FileInputStream fileInputStreamR = null;

    public static String getString(String propFilePath, String propKey) throws IOException {
        fileInputStreamR = new FileInputStream(System.getProperty("user.dir") + propFilePath);
        propFile.load(fileInputStreamR);
        String propValue = propFile.getProperty(propKey);
        if (propValue == null)
            return propKey + " is empty.";

        return propFile.getProperty(propKey);
    }

    public static String getStringFullFilePath(String fullPropFilePath, String propKey) throws IOException {
        fileInputStreamR = new FileInputStream(fullPropFilePath);

        propFile.load(fileInputStreamR);
        String propValue = propFile.getProperty(propKey);
        if (propValue == null)
            return propKey + " is empty.";

        return propFile.getProperty(propKey);
    }


    public static int getInt(String propFilePath, String propKey) throws IOException {
        fileInputStreamR = new FileInputStream(System.getProperty("user.dir") + propFilePath);

        propFile.load(fileInputStreamR);
        String propValue = propFile.getProperty(propKey);
        if (propValue == null)
            return 0;

        return Integer.parseInt(propFile.getProperty(propKey));
    }


    public static int getIntFullFilePath(String fullPropFilePath, String propKey) throws IOException {
        fileInputStreamR = new FileInputStream(fullPropFilePath);
        propFile.load(fileInputStreamR);
        String propValue = propFile.getProperty(propKey);
        if (propValue == null)
            return 0;
        return Integer.parseInt(propFile.getProperty(propKey));
    }
}
