package data;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Coordinates class represents the coordinates of a location.
 */
public class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = -1477044085600750388L;
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
