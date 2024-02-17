package Enums;

public enum Gender {
    MALE("мужчина"),
    THEY("они"),
    FEMALE("женщина");

    private String place;

    Gender(String place){
        this.place = place;
    }
    @Override
    public String toString(){
        return place;
    }
}
