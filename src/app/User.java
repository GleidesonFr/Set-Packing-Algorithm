package app;

public class User {
 
    private int[] languages;
    private int id;

    public User(int[] languages, int id){
        this.languages = languages;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int[] getLanguages() {
        return languages;
    }
}
