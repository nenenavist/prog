package data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import data.generators.IdGenerator;
import managers.Validator;

import java.util.Date;
public class MusicBand implements Comparable<MusicBand> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Зна
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически 
    private Integer number0fParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Studio studio; //Поле не может быть null

    public MusicBand(String[] data) throws Exception {
        Validator.idIsRight(data[1]);
        Validator.inputIsFilled(data[2],"NAME");
        Validator.coordinateXIsRight(data[3]);
        Validator.coordinateYIsRight(data[4]);
        Validator.number0fParticipantsIsRight(data[5]);
        Validator.musicGenreIsRight(data[6]);
        Validator.inputIsFilled(data[7],"STUDIO");

        this.id = Integer.parseInt(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Long.parseLong(data[3]), Float.parseFloat(data[4]));
        this.creationDate = new Date();
        this.number0fParticipants = Integer.parseInt(data[5]);
        this.genre = MusicGenre.valueOf(data[6]);
        this.studio = new Studio(data[7]);
    }
    public MusicBand(){
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = new Date();
        this.number0fParticipants = null;
        this.genre = null;
        this.studio = null;
    }
    public MusicBand(Integer id){
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
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", number0fParticipants=" + number0fParticipants +
                ", genre='" + genre + '\'' +
                ", studio=" + studio +
                '}';
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Integer getNumber0fParticipants() {
        return number0fParticipants;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setNumber0fParticipants(Integer number0fParticipants) {
        this.number0fParticipants = number0fParticipants;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Override
    public int compareTo(MusicBand musicBand){
        return (this.id - musicBand.getId());
    }
}
