package Java;

public class NewsId {

    private static int id=0;

    public static int GetNewNewsId() {
        int ID = id;
        id++;
        return ID;
    }

}
