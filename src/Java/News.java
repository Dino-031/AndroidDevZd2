package Java;

import java.util.Date;

public class News {
    private int id;
    private String news;
    private Date newsDate;

    public News(String news, Date newsDate, int id) {
        this.news = news;
        this.newsDate = newsDate;
        this.id = id;
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

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }
}
