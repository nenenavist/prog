package Place;

public class Coordinate {

    private int x;
    private int y;
    private int z;
    private int r;

    public Coordinate(int x1, int y1, int z1, int r1){
        this.r = r1;
        this.x = x1;
        this.y = y1;
        this.z = z1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getR() {
        return r;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Coordinate coordinate= (Coordinate) o;
//        return java.util.Objects.equals(name, coordinate.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(name);
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return  this.getName();
//    }
}

