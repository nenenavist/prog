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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

public class XMLSerializer {
    public XStream xstream;

    public XMLSerializer(){
        xstream = new XStream(new StaxDriver());
        xstream.alias("studio", Studio.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("musicBand", MusicBand.class);
        xstream.alias("musicGenre", MusicGenre.class);

        xstream.addImplicitCollection(CollectionManager.class, "collection");

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypeHierarchy(PriorityQueue.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
    }


    public String serialize(PriorityQueue <MusicBand> data) {
        String rawData = xstream.toXML(data);
        return rawData;
    }
    public PriorityQueue<MusicBand> deserialize() {
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(PriorityQueue.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
        xstream.allowTypes(new Class[] {PriorityQueue.class, MusicBand.class});

        PriorityQueue <MusicBand> data = new PriorityQueue<>();
        try (BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream("lab.xml"))) {
            byte[] bytes = bInputStream.readAllBytes();
            bInputStream.close();
            String rawData  = new String(bytes);
            data = (PriorityQueue<MusicBand>) xstream.fromXML(rawData);
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
        catch (IOException e){
            System.out.println("Ошибка ввода");
        }
        return data;
    }
}
