package data.comparators;

import data.MusicBand;

import java.util.Comparator;

public class StudioComparator implements Comparator<MusicBand> {
    @Override
    public int compare(MusicBand m1, MusicBand m2){
        return m1.getStudio().getName().length() - m2.getStudio().getName().length();
    }
}
