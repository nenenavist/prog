package system;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import data.Studio;
import managers.CollectionManager;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class XMLSerializer {
    public XStream xstream;

    public XMLSerializer(){
        xstream = new XStream(new StaxDriver());
        xstream.alias("studio", Studio.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("musicBand", MusicBand.class);
        xstream.alias("musicGenre", MusicGenre.class);

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.ignoreUnknownElements();
    }


    public String serialize(PriorityQueue <MusicBand> data) {
        MusicBand[] dataArray = data.toArray(new MusicBand[0]);
        String rawData = xstream.toXML(dataArray);
        return rawData;
    }
    public PriorityQueue<MusicBand> deserialize(String path) {
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.ignoreUnknownElements();

        MusicBand[] data;
        PriorityQueue <MusicBand> queue = new PriorityQueue<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String rawData  = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            reader.close();
            if (rawData.isEmpty()){
                throw new IOException();
            }
            data = (MusicBand[]) xstream.fromXML(rawData);
            for (MusicBand musicBand : data){
                queue.add(musicBand);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch (IOException e){
            System.out.println("File is empty");
        }
        catch (Exception e){
            System.out.println("Input error");
        }

        return queue;
    }
}
