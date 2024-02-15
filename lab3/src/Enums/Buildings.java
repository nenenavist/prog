package Enums;

public enum Buildings {
    FACTORY(" заводы"),
    MANUFACTORY(" фабрики"),
    LARGE_THEATRE("большие театры"),
    MUSEUM("музеи"),
    ART_GALLERY("картинные галереи"),
    STADIUM("стадионы"),
    SWIMMING_POOL("плавательные бассейны"),
    HOSPITAL("больницы"),
    STEAMBOAT("прогулочные пароходики");

    private String place;
    protected boolean builder;

    Buildings(String place){
        this.place = place;
    }
    @Override
    public String toString(){
        return place;
}
    public void setStatus(boolean b){
        builder = b;
    }
    public boolean getStatus(){
         return builder;
    }
}

