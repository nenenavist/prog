package system;

import data.MusicBand;
import exceptions.RootException;
import managers.CollectionManager;

import java.io.*;
import java.util.PriorityQueue;

/**
 * The XMLSerializer class provides methods to serialize and deserialize objects to and from XML format.
 */
public class XMLWriter {

    /**
     * Writes the collection of MusicBand objects to an XML file specified by the given path.
     *
     * @param path The path to the XML file to be written.
     * @throws IOException    If an I/O error occurs.
     * @throws RootException If the user does not have enough rights to write to the file.
     */
    public static void write(String path) throws IOException, RootException {
        File file = new File(path);
        if (!file.canRead()){
            throw new RootException("You do not have enough rights to write to the file");
        }
        StringBuilder xml = new StringBuilder("""
                <?xml version="1.0" encoding="UTF-8" ?>

                <collection>
                \t<musicBands>
                """);

        PriorityQueue <MusicBand> queue = CollectionManager.getCollection();
        for (MusicBand musicBand : queue) {
            xml.append("\t\t<musicBand ");
            xml.append(musicBand.toXML()).append("/>\n");
        }

        xml.append("\t</musicBands>\n" + "</collection>");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(xml.toString().getBytes());
        bufferedOutputStream.close();
    }
}