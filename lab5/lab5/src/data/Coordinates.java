package data;

/**
 * The Coordinates class represents the coordinates of a location.
 */
public class Coordinates {
    private long x; // Maximum value of the field: 566
    private Float y; // The field cannot be null

    /**
     * Constructs a Coordinates object with the specified x and y coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Coordinates(long x, Float y){
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate.
     *
     * @return the x-coordinate
     */
    public Long getX() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     *
     * @param x the x-coordinate to set
     */
    public void setX(Long x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate.
     *
     * @return the y-coordinate
     */
    public Float getY() {
        return y;
    }

    /**
     * Sets the y-coordinate.
     *
     * @param y the y-coordinate to set
     */
    public void setY(Float y) {
        this.y = y;
    }
}
