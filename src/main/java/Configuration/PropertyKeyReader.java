package Configuration;

import Helpers.ConfigReader;
import Interface.IConfig;
import Settings.PropertyKeys;

import javax.annotation.PropertyKey;
import java.io.IOException;

public class PropertyKeyReader implements IConfig {
    private static String configFilePath = "\\src\\main\\resources\\config.properties";

    @Override
    public String getBrowser() throws IOException {
        return ConfigReader.getString(configFilePath, PropertyKeys.Browser);
    }

    @Override
    public String getWebSite() throws IOException {
        return ConfigReader.getString(configFilePath, PropertyKeys.WebSite);
    }

    @Override
    public String getUsername() throws IOException {
        return ConfigReader.getString(configFilePath, PropertyKeys.UserName);
    }

    @Override
    public String getPassword() throws IOException {
        return ConfigReader.getString(configFilePath, PropertyKeys.Password);
    }

    @Override
    public int getPageTimeout() throws IOException {
        return ConfigReader.getInt(configFilePath, PropertyKeys.PageLoadoutTime);
    }

    @Override
    public int getElementTimeout() throws IOException {
        return ConfigReader.getInt(configFilePath, PropertyKeys.ElementLoadoutTime);
    }
}
