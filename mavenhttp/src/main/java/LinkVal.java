import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class LinkVal {
    //Link Validation
    public static void main (String[] args) throws Exception{
    System.setProperty("webdriver.gecko.driver","D:\\Mega\\PR3lab\\geckodriver-v0.16.1-win64\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://torrentsmd.com/");
    List<WebElement> links=driver.findElements(By.tagName("a"));
    System.out.println("Total links are "+links.size());
    for(int i=0;i<links.size();i++)
    {
        WebElement ele= links.get(i);
        String url=ele.getAttribute("href");
       verifyLinkActive(url);
    }
}


    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
}
}