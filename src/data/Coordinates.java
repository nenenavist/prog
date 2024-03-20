package data;

public class Coordinates {
    private long x; //Максимальное значение поля: 566
    private Float y; //Поле не может быть null
    public Coordinates(long x, Float y){
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
