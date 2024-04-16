package data.comparators;

import data.MusicBand;

import java.util.Comparator;

/**
 * The StudioComparator class implements a comparator for MusicBand objects based on the length of studio names.
 * It compares two MusicBand objects based on the length of their associated studio names.
 */
public class StudioComparator implements Comparator<MusicBand> {

    /**
     * Compares two MusicBand objects based on the length of their associated studio names.
     *
     * @param m1 the first MusicBand object to compare
     * @param m2 the second MusicBand object to compare
     * @return a negative integer, zero, or a positive integer as the length of the first MusicBand's associated studio name
     *         is less than, equal to, or greater than the length of the second MusicBand's associated studio name.
     */
    @Override
    public int compare(MusicBand m1, MusicBand m2){
        return m1.getStudio().getName().length() - m2.getStudio().getName().length();
    }
}
