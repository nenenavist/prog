package data;

//import com.thoughtworks.xstream.annotations.XStreamAlias;
import data.generators.IdGenerator;
import exceptions.IncorrectInputException;
import exceptions.UsedIdException;
import managers.Validator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * The MusicBand class represents a music band entity.
 */
//@XStreamAlias("MusicBand")
public class MusicBand implements Comparable<MusicBand>, Serializable {
    @Serial
    private static final long serialVersionUID = -5703671082810752017L;
    private Integer id; // The field cannot be null, must be greater than 0, and must be unique
    private String name; // The field cannot be null and cannot be empty
    private Coordinates coordinates; // The field cannot be null
    private Date creationDate; // The field cannot be null and is automatically generated
    private Integer number0fParticipants; // The field cannot be null and must be greater than 0
    private Studio studio; // The field cannot be null
    private MusicGenre genre; // The field can be null


    /**
     * Constructs a MusicBand object with the provided data.
     *
     * @param data an array containing data for constructing the MusicBand
     * @throws Exception if data validation fails
     */
    public MusicBand(String[] data) throws Exception {
        Validator.idIsRight(data[1]);
        Validator.inputIsFilled(data[2], "NAME");
        Validator.coordinateXIsRight(data[3]);
        Validator.coordinateYIsRight(data[4]);
        Validator.number0fParticipantsIsRight(data[6]);
        Validator.inputIsFilled(data[8], "STUDIO");

        this.id = Integer.parseInt(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Long.parseLong(data[3]), Float.parseFloat(data[4]));
        this.creationDate = new Date();
        this.number0fParticipants = Integer.parseInt(data[6]);
        String typeGenre = switch (Validator.musicGenreIsRight(data[7])) {
            case 1 -> "PROGRESSIVE_ROCK";
            case 2 -> "HIP_HOP";
            case 3 -> "PSYCHEDELIC_CLOUD_RAP";
            case 4 -> "PUNK_ROCK";
            case 5 -> "BRIT_POP";
            default -> throw new IllegalStateException("Unexpected value: genre");
        };
        this.genre = MusicGenre.valueOf(typeGenre);
        this.studio = new Studio(data[8]);
    }

    public MusicBand(Integer id , String[] data) throws IncorrectInputException, UsedIdException {
        Validator.inputIsFilled(data[1], "NAME");
        Validator.coordinateXIsRight(data[2]);
        Validator.coordinateYIsRight(data[3]);
        Validator.number0fParticipantsIsRight(data[5]);
        Validator.inputIsFilled(data[7], "STUDIO");

        this.id = id;
        this.name = data[1];
        this.coordinates = new Coordinates(Long.parseLong(data[2]), Float.parseFloat(data[3]));
        this.creationDate = new Date();
        this.number0fParticipants = Integer.parseInt(data[5]);
        String typeGenre = switch (Validator.musicGenreIsRight(data[6])) {
            case 1 -> "PROGRESSIVE_ROCK";
            case 2 -> "HIP_HOP";
            case 3 -> "PSYCHEDELIC_CLOUD_RAP";
            case 4 -> "PUNK_ROCK";
            case 5 -> "BRIT_POP";
            default -> throw new IllegalStateException("Unexpected value: genre");
        };
        this.genre = MusicGenre.valueOf(typeGenre);
        this.studio = new Studio(data[7]);
    }

    public MusicBand(String[] data, String line) throws Exception {
        Validator.inputIsFilled(data[2], "NAME");
        Validator.coordinateXIsRight(data[3]);
        Validator.coordinateYIsRight(data[4]);
        Validator.number0fParticipantsIsRight(data[6]);
        Validator.inputIsFilled(data[8], "STUDIO");

        this.id = Integer.parseInt(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Long.parseLong(data[3]), Float.parseFloat(data[4]));
        this.creationDate = new Date();
        this.number0fParticipants = Integer.parseInt(data[6]);
        String typeGenre = switch (Validator.musicGenreIsRight(data[7])) {
            case 1 -> "PROGRESSIVE_ROCK";
            case 2 -> "HIP_HOP";
            case 3 -> "PSYCHEDELIC_CLOUD_RAP";
            case 4 -> "PUNK_ROCK";
            case 5 -> "BRIT_POP";
            default -> throw new IllegalStateException("Unexpected value: genre");
        };
        this.genre = MusicGenre.valueOf(typeGenre);
        this.studio = new Studio(data[8]);
    }



    /**
     * Constructs a MusicBand object with default values.
     */
    public MusicBand() {
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = new Date();
        this.number0fParticipants = null;
        this.genre = null;
        this.studio = null;
    }

    /**
     * Constructs a MusicBand object with the specified ID.
     *
     * @param id the ID of the MusicBand
     */
    public MusicBand(Integer id) {
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = new Date();
        this.number0fParticipants = 0;
        this.genre = null;
        this.studio = null;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", number0fParticipants=" + number0fParticipants +
                ", genre='" + genre + '\'' +
                ", studio=" + studio +
                '}';
    }

    public String toXML() {
        return "id=\"" + id + "\"" +
                " name=\"" + name + "\"" +
                " x=\"" + coordinates.getX() + "\"" +
                " y=\"" + coordinates.getY() + "\"" +
                " creationDate=\"" + creationDate + "\"" +
                " numberOfParticipants=\"" + number0fParticipants + "\"" +
                " genre=\"" + genre + "\"" +
                " studio=\"" + studio.getName() + "\"";
    }

    /**
     * Retrieves the ID of the music band.
     *
     * @return the ID of the music band
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieves the name of the music band.
     *
     * @return the name of the music band
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the coordinates of the music band.
     *
     * @return the coordinates of the music band
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Retrieves the creation date of the music band.
     *
     * @return the creation date of the music band
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Retrieves the number of participants in the music band.
     *
     * @return the number of participants in the music band
     */
    public Integer getNumber0fParticipants() {
        return number0fParticipants;
    }

    /**
     * Retrieves the genre of the music band.
     *
     * @return the genre of the music band
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Retrieves the studio of the music band.
     *
     * @return the studio of the music band
     */
    public Studio getStudio() {
        return studio;
    }

    /**
     * Sets the ID of the music band.
     *
     * @param id the ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the name of the music band.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the coordinates of the music band.
     *
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the creation date of the music band.
     *
     * @param creationDate the creation date to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets the number of participants in the music band.
     *
     * @param number0fParticipants the number of participants to set
     */
    public void setNumber0fParticipants(Integer number0fParticipants) {
        this.number0fParticipants = number0fParticipants;
    }

    /**
     * Sets the genre of the music band.
     *
     * @param genre the genre to set
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Sets the studio of the music band.
     *
     * @param studio the studio to set
     */
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Override
    public int compareTo(MusicBand m2) {
        if (this.genre.equals(m2.getGenre())) {
            return this.name.compareTo(m2.getName());
        } else {
            return this.genre.compareTo(m2.getGenre());
        }
    }
}
