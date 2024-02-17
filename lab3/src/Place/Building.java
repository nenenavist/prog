package Place;

public class Building {
    private String name;
    private Coordinate coordinate;

    public Building(String newName, Coordinate newCoordinate) {
        this.coordinate = newCoordinate;
        this.name = newName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building= (Building) o;
        return java.util.Objects.equals(name, building.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }

    @Override
    public String toString() {
        return  this.getName();
    }
}