package data.comparators;

import data.MusicBand;

import java.util.Comparator;

/**
 * The NumberOfParticipantsComparator class implements a comparator for MusicBand objects based on the number of participants.
 * It compares two MusicBand objects based on their number of participants.
 */
public class NumberOfParticipantsComparator implements Comparator<MusicBand> {

    /**
     * Compares two MusicBand objects based on their number of participants.
     *
     * @param m1 the first MusicBand object to compare
     * @param m2 the second MusicBand object to compare
     * @return a negative integer, zero, or a positive integer as the first MusicBand's number of participants
     *         is less than, equal to, or greater than the second MusicBand's number of participants.
     */
    @Override
    public int compare(MusicBand m1, MusicBand m2){
        return m1.getNumber0fParticipants() - m2.getNumber0fParticipants();
    }
}
