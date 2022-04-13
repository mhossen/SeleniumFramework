package Helpers;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpHelper {

  public String GetStatusCode(String url) throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(url);
    CloseableHttpResponse response1 = httpclient.execute(httpGet);
    try {
      System.out.println(response1.getStatusLine());
      HttpEntity entity1 = response1.getEntity();
      // do something useful with the response body
      // and ensure it is fully consumed
      //   EntityUtils.consume(entity1);
      return entity1.toString();
    } finally {
      response1.close();
    }
  }
}
