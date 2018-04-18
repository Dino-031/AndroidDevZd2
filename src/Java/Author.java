package Java;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Author {

    private String name;
    private List<Category> categoryList = new ArrayList<>();

    public Author(String authorName, String categoryName, Date newsDate , String newsString) {
        this.name = authorName;
        Category c = new Category(categoryName, newsDate , newsString);
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
    public void AddCategoryAndNews(String categoryName,Date newsDate,String newsString)
    {
        Category c = new Category(categoryName, newsDate , newsString);
        categoryList.add(c);
    }
    public void SetAuthorName(String authorName)
    {
        this.name = authorName;
    }
}
