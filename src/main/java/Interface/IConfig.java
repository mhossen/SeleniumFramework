package Interface;

import java.io.IOException;

public interface IConfig {
    public String getBrowser() throws IOException;
    public String getUsername() throws IOException;
    public String getPassword() throws IOException;
    public int getPageTimeout() throws IOException;
    public int getElementTimeout() throws IOException;
}
