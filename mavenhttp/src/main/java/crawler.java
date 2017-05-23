import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ion.C on 16-May-17.
 */
public class crawler {

    public static Queue<String> queue = new LinkedList<>();
    public static Set<String> marked = new HashSet<>();
    public static String regex = "http[s]*://(\\w+\\.)*(\\w+)";

    public static void bfsalg(String root) throws Exception{
        queue.add(root);

        while (!queue.isEmpty()) {
            String crawledUrl = queue.poll();
            System.out.print("\n=== Site crawled: " + crawledUrl + " ====");
            if (marked.size()>100){
                return;
            }
            boolean ok = false;
            URL url =null ;
            BufferedReader br = null;

            while(!ok){
                try{
                    url = new URL(crawledUrl);
                    br = new BufferedReader(new InputStreamReader(url.openStream()));
                    ok = true;
                }catch (MalformedURLException e){
                    System.out.println("Malformed URL: " + crawledUrl);
                    crawledUrl = queue.poll();
                    ok = false;
                }catch(IOException ioe) {
                    System.out.println("IOException for URL: " + crawledUrl);
                    crawledUrl = queue.poll();
                    ok = false;
                }
            }

            StringBuilder sb  = new StringBuilder();
            String tmp = null;

            while((tmp = br.readLine())!=null){
                sb.append(tmp);
            }
            tmp = sb.toString();

            Pattern pattern =  Pattern.compile(regex);
            Matcher matcher  = pattern.matcher(tmp);

            while (matcher.find()) {
                String w = matcher.group();

                if (!marked.contains(w)){
                    marked.add(w);
                    System.out.println("Site-ul adaugat pentru crawling:" + w);
                    queue.add(w);
                }
            }
        }
    }

    public static void Show(){
        System.out.println("\n\nResults : ");
        System.out.println("Web Sites crawled : " +marked.size() + "\n");
        for(String s : marked ) {
            System.out.println(" * " +s );
        }
    }

    public static void main(String[] args){
        try {
            bfsalg("http://httpbin.org/");
            Show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
