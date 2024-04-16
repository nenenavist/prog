package system;

import data.MusicBand;
import exceptions.RootException;
import managers.CollectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLReader {
    public static void read(String path) throws IOException, RootException, ParserConfigurationException, SAXException {
        File file = new File(path);
        if (!file.canRead()){
            throw new RootException("You do not have enough rights to read the file");
        }
        // Чтение из файла
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        if (text.length()==0){
            System.out.println("No element to add, your collection is clear");
            return;
        }

        InputSource in = new InputSource(new StringReader(text.toString()));

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Document хранит данные из файла в древовидной структуре xml.
        Document document = builder.parse(in);

        //NodeList позволяет получить доступ к узлам xml
        NodeList musicBandElements = document.getDocumentElement().getElementsByTagName("musicBand");

        for (int i = 0; i < musicBandElements.getLength(); i++) {
            Node musicBand = musicBandElements.item(i);
            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = musicBand.getAttributes();
            String[] data = {null, attributes.getNamedItem("id").getNodeValue(),
                    attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("x").getNodeValue(),
                    attributes.getNamedItem("y").getNodeValue(), attributes.getNamedItem("creationDate").getNodeValue(),
                    attributes.getNamedItem("numberOfParticipants").getNodeValue(),
                    attributes.getNamedItem("genre").getNodeValue(),
                    attributes.getNamedItem("studio").getNodeValue()};
            try {
                MusicBand newMusicBand = new MusicBand(data);
                CollectionManager.add(newMusicBand);
            } catch (Exception e) {
                System.out.println("Wrong XML data in " + (i+1) + " music band");
            }
        }
    }
}

