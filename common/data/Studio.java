package data;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Studio class represents a music studio.
 */
public class Studio implements Serializable {
    @Serial
    private static final long serialVersionUID = 240845716393509765L;
    private String studionName; // The field can be null

    /**
     * Constructs a Studio object with the specified name.
     *
     * @param name the name of the studio
     */
    public Studio(String name){
        this.studionName = name;
    }

    /**
     * Gets the name of the studio.
     *
     * @return the name of the studio
     */
    public String getName() {
        return studionName;
    }

    /**
     * Sets the name of the studio.
     *
     * @param name the name of the studio to set
     */
    public void setName(String name) {
        this.studionName = name;
    }
}
