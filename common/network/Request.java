package network;

import data.MusicBand;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 5653699505659246052L;
    private MusicBand musicBand;
    String[] args;

    public Request(MusicBand musicBand){
        this.musicBand = musicBand;
    }

    public Request(String[] args){
        this.args = args;
    }

    public Request(MusicBand musicBand, String[] args){
        this.musicBand = musicBand;
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void setMusicBand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
