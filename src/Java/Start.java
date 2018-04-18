package Java;

import java.util.*;


public class Start {
    public static void main(String[] args)
    {
        List<Author> authorList = new ArrayList<>();
        int selection ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose option:");
            System.out.println("1.Create new...");
            System.out.println("2.Read existing...");
            System.out.println("3.Update existing...");
            System.out.println("4.Delete...");
            System.out.println("5.Exit");
            selection = scanner.nextInt();
            switch (selection)
            {
                case 1:
                    CreateNew(authorList);
                    break;
                case 2:
                    ReadExisting(authorList);
                    break;
                case 3:
                    UpdateData(authorList);
                    break;
            }
        }
        while(selection != 5);

    }

    private static void UpdateData(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        int selection;
        System.out.println("Please choose option:");
        System.out.println("1.Update author name");
        System.out.println("2.Create category name");
        System.out.println("3.Update news & news date");
        System.out.println("4.Exit");
        selection = scanner.nextInt();
        switch (selection)
        {
            case 1:
                UpdateAuthorName(authorList);
                break;
            case 2:
                UpdateCategoryName(authorList);
                break;
            case 3:
                UpdateNews(authorList);
                break;
        }
    }
    private static void UpdateAuthorName(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        String oldName;
        String newName;
        System.out.print("Enter old name of author: ");
        oldName = scanner.next();
        System.out.print("Enter new name of author");
        newName=scanner.next();
        for (int i = 0;i< authorList.size();i++)
            if(authorList.get(i).GetAuthorName().equals(oldName))
                authorList.get(i).SetAuthorName(newName);
    }

    private  static void UpdateCategoryName(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        String oldName;
        String newName;
        System.out.print("Enter old name of category: ");
        oldName = scanner.next();
        System.out.print("Enter new name of category: ");
        newName=scanner.next();
        for(int i=0; i < authorList.size();i++)
        {
            for(int j=0;j<authorList.get(i).GetCategories().size();j++)
            {
                if(authorList.get(i).GetCategories().get(j).GetCategoryName().equals(oldName))
                    authorList.get(i).GetCategories().get(j).SetCategoryName(newName);
            }
        }

    }

    private static void UpdateNews(List<Author> authorList)
    {
        //Vijest ce morat imat id,jer vijest moze biti u vise kategorija,pa neces ic po kategorijama i mjenjat svaku posebno
        Scanner scanner = new Scanner(System.in);
        String authorName;
        String categoryName;
        int newsNumber;
        System.out.print("Enter author's name: ");
        authorName = scanner.next();
        System.out.print("Enter the name of category that contains news which you want to change: ");
        categoryName=scanner.next();
        for(int i=0; i < authorList.size();i++)
        {
            for(int j=0;j<authorList.get(i).GetCategories().size();j++)
            {
                if(authorList.get(i).GetCategories().get(j).GetCategoryName().equals(categoryName))
                {
                    for(int k=0;k<authorList.get(i).GetCategories().get(j).GetNewsList().size();k++)
                        System.out.printf("%d . %s\t %s",k,authorList.get(i).GetCategories().get(j).GetNewsList().get(k).GetNews(),authorList.get(i).GetCategories().get(j).GetNewsList().get(k).GetNewsDate().toString());
                }
            }
        }
        System.out.print("Enter the number of news that you want to change: ");
        newsNumber = scanner.nextInt();

    }

    private static void CreateNew(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        int selection;
        System.out.println("Please choose option:");
        System.out.println("1.Create new author");
        System.out.println("2.Create new category");
        System.out.println("3.Create news");
        System.out.println("4.Exit");
        selection = scanner.nextInt();
        switch (selection)
        {
            case 1:
                AddAuthorOrCategory(authorList,true);
                break;
            case 2:
                AddAuthorOrCategory(authorList,false);
                break;
            case 3:
                AddNews(authorList);
                break;
        }
    }
    private static List<Author> AddNews(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        String nameAuthor;
        String nameCategory;
        String news;
        String newsDateString;
        String[] newsDateSplitted;
        System.out.print("Enter the name of author for who you want to add news: ");
        nameAuthor = scanner.next();
        System.out.print("Enter the category name: ");
        nameCategory = scanner.next();
        System.out.print("Enter the news: ");
        news = scanner.next();
        System.out.print("Enter news date(dd/mm/yyyy): ");
        newsDateString = scanner.next();
        newsDateSplitted = newsDateString.split("/");
        for(int i=0; i < authorList.size();i++)
        {

            if(authorList.get(i).GetAuthorName().equals(nameAuthor))
            {
                authorList.get(i).AddCategoryAndNews(nameCategory,new Date(Integer.parseInt(newsDateSplitted[2]),Integer.parseInt(newsDateSplitted[1]),Integer.parseInt(newsDateSplitted[0])),news);
            }
        }
        return authorList;

    }

    private static void AddAuthorOrCategory(List<Author> authorList,boolean AuthorMode)
    {
        Scanner scanner = new Scanner(System.in);
        if(AuthorMode)
        {
            System.out.println("Enter author name, category of news, date of news and news itself(dd/mm/yyyy)");
            String[] dateSplitted;
            String name = scanner.next();
            String category = scanner.next();
            String NewsDateString = scanner.next();
            String news = scanner.next();
            dateSplitted = NewsDateString.split("/");
            Author a = new Author(name,category,new Date(Integer.parseInt(dateSplitted[2]),Integer.parseInt(dateSplitted[1]),Integer.parseInt(dateSplitted[0])),news);
            authorList.add(a);
        }
        else
        {
            //Moras napraviti razliku izmedu postojeceg i novog autora,korisnik nece unositi podatak da li autor vec postoji ili ne
            System.out.println("Enter category author name, category of news, date of news and news itself(dd/mm/yyyy)-Category must have at least one author and news to exist");
            String[] dateSplitted;
            String name = scanner.next();
            String category = scanner.next();
            String NewsDateString = scanner.next();
            String news = scanner.next();
            dateSplitted = NewsDateString.split("/");
            Author a = new Author(name,category,new Date(Integer.parseInt(dateSplitted[2]),Integer.parseInt(dateSplitted[1]),Integer.parseInt(dateSplitted[0])),news);
            authorList.add(a);
        }

    }

    private static void ReadExisting(List<Author> authorList)
    {
        Scanner scanner = new Scanner(System.in);
        int selection;
        System.out.println("Please choose option:");
        System.out.println("1.Order by authors");
        System.out.println("2.Order by categories");
        System.out.println("3.Order by dates");
        System.out.println("4.Exit");
        selection = scanner.nextInt();
        switch (selection)
        {
            case 1:
                ReadAuthors(authorList);
                break;
            case 2:
                ReadCategories(authorList);
                break;
            case 3:
                ReadDates(authorList);
                break;
        }
    }

    private static void ReadAuthors(List<Author> authorList)
    {
        List<Category> categoriesPerAuthor = new ArrayList<>();
        List<News> newsPerCategory = new ArrayList<>();
        String AuthorsArray[] = new String[authorList.size()];

        for(int i = 0;i<authorList.size();i++)
        {
            AuthorsArray[i] = authorList.get(i).GetAuthorName();

        }
        Arrays.sort(AuthorsArray);
        int counter=0;
        do
        {
            for(int i = 0;i<authorList.size();i++)
            {
                if(authorList.get(i).GetAuthorName() == AuthorsArray[counter])
                {
                    categoriesPerAuthor = authorList.get(i).GetCategories();
                    for(int j=0;j<categoriesPerAuthor.size();j++)
                    {
                        newsPerCategory = categoriesPerAuthor.get(j).GetNewsList();
                        for(int k = 0;k<newsPerCategory.size();k++)
                            System.out.printf("%s\t %s\t %s\t %s\t\n",authorList.get(i).GetAuthorName(),categoriesPerAuthor.get(j).GetCategoryName(),newsPerCategory.get(k).GetNewsDate().toString(),newsPerCategory.get(k).GetNews());
                    }

                }
            }
            counter++;
        }
        while(counter<AuthorsArray.length);
    }

    private static void ReadCategories(List<Author> authorList)
    {

        List<String> categoryList = new ArrayList<>();


        for(int i=0;i<authorList.size();i++)
        {
            for(int j = 0;j<authorList.get(i).GetCategories().size();j++)
            {
                if(!categoryList.contains(authorList.get(i).GetCategories().get(j).GetCategoryName()))
                    categoryList.add(authorList.get(i).GetCategories().get(j).GetCategoryName());
            }
        }
        Collections.sort(categoryList);

        for(int i = 0; i< categoryList.size();i++)
        {
            for(int j =0;j<authorList.size();j++)
            {
                for(int k = 0;k<authorList.get(j).GetCategories().size();k++)
                {
                    if(authorList.get(j).GetCategories().get(k).GetCategoryName() == categoryList.get(i))
                    {
                        for(int z = 0;z<authorList.get(j).GetCategories().get(k).GetNewsList().size();z++)
                            System.out.printf("%s\t %s\t %s\t %s\t \n",authorList.get(j).GetAuthorName(),authorList.get(j).GetCategories().get(k).GetCategoryName(),authorList.get(j).GetCategories().get(k).GetNewsList().get(z).GetNewsDate().toString(),authorList.get(j).GetCategories().get(k).GetNewsList().get(z).GetNews());
                    }
                }
            }
        }
    }

    private static void ReadDates(List<Author> authorList)
    {
        List<Date> datesList = new ArrayList<>();
        for(int i=0;i<authorList.size();i++)
        {
            for(int j=0;j<authorList.get(i).GetCategories().size();j++)
            {
                for (int k =0;k<authorList.get(i).GetCategories().get(j).GetNewsList().size();k++)
                    datesList.add(authorList.get(i).GetCategories().get(j).GetNewsList().get(k).GetNewsDate());
            }
        }
        Collections.sort(datesList);


        for(int i = 0; i< datesList.size();i++)
        {
            for(int j =0;j<authorList.size();j++)
            {
                for(int k = 0;k<authorList.get(j).GetCategories().size();k++)
                {
                    for(int z = 0;z<authorList.get(j).GetCategories().get(k).GetNewsList().size();z++)
                        if(authorList.get(j).GetCategories().get(k).GetNewsList().get(z).GetNewsDate() == datesList.get(i))
                            System.out.printf("%s\t %s\t %s\t %s\t \n",authorList.get(j).GetAuthorName(),authorList.get(j).GetCategories().get(k).GetCategoryName(),authorList.get(j).GetCategories().get(k).GetNewsList().get(z).GetNewsDate().toString(),authorList.get(j).GetCategories().get(k).GetNewsList().get(z).GetNews());

                }
            }
        }

    }


}

