package data.comparators;

import data.MusicBand;

import java.util.Comparator;

public class NumberOfParticipantsComparator implements Comparator<MusicBand> {
    @Override
    public int compare(MusicBand m1, MusicBand m2){
        return m1.getNumber0fParticipants() - m2.getNumber0fParticipants();
    }
}
