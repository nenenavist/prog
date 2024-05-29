package managers.commands;

import data.MusicBand;
import managers.CollectionManager;
import network.Request;
import network.Response;

/**
 * A command that removes elements in the collection which have a field value lower than the specified one.
 */
public class RemoveLower extends BaseCommand{
    public RemoveLower() {
        super("remove_lower [MusicBand]", false, "removes elements, which field is lower than specified one");
    }


    @Override
    public Response execute(Request request){
        MusicBand musicBand = request.getMusicBand();
        return CollectionManager.removeLower(musicBand);
    }
}
