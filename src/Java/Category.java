package Java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Category {

    String category;
    List<News> newsList = new ArrayList<>();

    public Category(String category, Date newsDate , String newsString) {

        this.category = category;
        News n = new News(newsString,newsDate);
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
}
