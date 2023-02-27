package configuration;

import helpers.ConfigReader;
import Interface.IConfig;
import Settings.PropertyKeys;

import java.io.IOException;

public class PropertyKeyReader implements IConfig {
    private static final String configFilePath = "\\src\\main\\resources\\config.properties";

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
