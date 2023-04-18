package my.edu.utar.ga;

public class DataModel {
    private String name;
    private String category;

    public DataModel(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
