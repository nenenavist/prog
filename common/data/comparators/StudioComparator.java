package data.comparators;

import data.MusicBand;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class StudioComparator implements Comparator<MusicBand>, Serializable {
    @Serial
    private static final long serialVersionUID = 4091620458797958691L;
    @Override
    public int compare(MusicBand m1, MusicBand m2){
        return m1.getStudio().getName().compareTo(m2.getStudio().getName());
    }
}
