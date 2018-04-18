package Java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Category {

    String category;
    List<News> newsList = new ArrayList<>();

    public Category(String category, Date newsDate , String newsString, int id) {

        this.category = category;
        News n = new News(newsString,newsDate,id);
        this.newsList.add(n);
    }
    public List<News> GetNewsList()
    {
        return newsList;
    }
    public String GetCategoryName()
    {
        return category;
    }
    public void SetCategoryName(String categoryName)
    {
        this.category = categoryName;
    }
    public void AddNewsToCategory(String newsString, Date newsDate, int newsID)
    {
        News n = new News(newsString,newsDate,newsID);
        this.newsList.add(n);
    }
}
