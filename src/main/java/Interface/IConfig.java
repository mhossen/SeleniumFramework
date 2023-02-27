package Interface;

import java.io.IOException;

public interface IConfig {
    String getBrowser() throws IOException;
    String getWebSite() throws IOException;
    String getUsername() throws IOException;
    String getPassword() throws IOException;
    int getPageTimeout() throws IOException;
    int getElementTimeout() throws IOException;
}
