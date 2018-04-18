package Java;

import java.util.Date;

public class News {
    private String news;
    private Date newsDate;

    public News(String news, Date newsDate) {
        this.news = news;
        this.newsDate = newsDate;
    }

    public String GetNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date GetNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }
}
