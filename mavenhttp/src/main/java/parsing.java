import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class parsing {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://www.imdb.com/chart/top").get();

        for (Element row : doc.select("table.chart.full-width tr")){

            final String title = row.select(".titlecolumn").text();
            final String rating = row.select(".imdbRating").text();
            System.out.println(title+ " Rating: " + rating);
        }

        Elements mElements = doc.getElementsByAttributeValue("class", "titleColumn");


    }}

    /*
        mElements.forEach(mElement -> {
            Element aElement = mElement.child(0);
            String url = aElement.attr("a href");
            String title = aElement.child(0).text();
            articleslist.add(new Article(url, title));
        });
        articleslist.forEach(System.out::println);

    }
  static class Article {
private String url;
private String name;

        Article(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}*/