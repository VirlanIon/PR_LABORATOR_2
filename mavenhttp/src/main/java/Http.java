import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.http.HttpHost;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Ion.C on 15-May-17.
 */
public class Http {
public static void main (String[] args) throws Exception{ //throws Exception{

    //Mask
//Unirest.setDefaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
//Unirest.setProxy(new HttpHost("58.97.81.11",80));
    //Get
 final HttpResponse<JsonNode> getResponse =  Unirest.get("http://httpbin.org/get").asJson();
 System.out.println(getResponse.getBody().getObject().getString("origin"));
 System.out.println(getResponse.getBody());
 System.out.println("IP :"+getResponse.getBody().getObject().getString("origin"));
 System.out.println("User-Agent: "+getResponse.getBody().getObject().getJSONObject("headers").getString("User-Agent"));

 System.out.println("\n\n---------------------------------------\n\n");

    //Post

    final HttpResponse<String> postResponse = Unirest.post("http://httpbin.org/post").field("postalcode", 4839).asString();
    System.out.println(postResponse.getBody());
    System.out.println("\n\n---------------------------------------\n\n");

    final JSONObject obj =new JSONObject().put("postalcode", 4839);
    final HttpResponse<String> postResponse2 = Unirest.post("http://httpbin.org/post").body(obj).asString();

    System.out.println(postResponse2.getBody());

    System.out.println("\n\n---------------------------------------\n\n");
    //head

  final HttpResponse<String> headResponse = Unirest.head("http://point.md").asString();
  System.out.println(headResponse.getHeaders());





}

}
