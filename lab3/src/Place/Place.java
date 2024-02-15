package Place;

public class Place {
    private String name;
    private Coordinate coordinate;


    public Place(String newName, Coordinate newCoordinate) {
        this.coordinate = newCoordinate;
        this.name = newName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }


    public String getName() {
        return name;
    }
}