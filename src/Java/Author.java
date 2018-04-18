package Java;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Author {

    private String name;
    private List<Category> categoryList = new ArrayList<>();

    public Author(String authorName, String categoryName, Date newsDate , String newsString,int newsID) {
        this.name = authorName;
        Category c = new Category(categoryName, newsDate , newsString,newsID);
        this.categoryList.add(c);
    }
    public List<Category> GetCategories()
    {
        return categoryList;
    }
    public String GetAuthorName()
    {
        return name;
    }
    public void AddCategoryAndNews(String categoryName,Date newsDate,String newsString,int newsID)
    {
        Category c = new Category(categoryName, newsDate , newsString,newsID);
        categoryList.add(c);
    }
    public void SetAuthorName(String authorName)
    {
        this.name = authorName;
    }
}
