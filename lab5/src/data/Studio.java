package data;

public class Studio {
    private String name; //Поле может быть null
    public Studio(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
