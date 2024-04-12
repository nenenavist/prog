package data;

/**
 * The Studio class represents a music studio.
 */
public class Studio {
    private String name; // The field can be null

    /**
     * Constructs a Studio object with the specified name.
     *
     * @param name the name of the studio
     */
    public Studio(String name){
        this.name = name;
    }

    /**
     * Gets the name of the studio.
     *
     * @return the name of the studio
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the studio.
     *
     * @param name the name of the studio to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
