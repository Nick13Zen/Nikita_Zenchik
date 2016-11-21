package Reader;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

/**
 * Class to read commands from xml file
 * Created by Nikita Zenchik.
 */
public class ReaderFromXml extends Reader {
    private File file;
    private ArrayList<String> listOfCommands = new ArrayList<String>();

    public ReaderFromXml(File file) {
        this.file = file;
    }

    /**
     * Method to read data from Xml file.
     */
    @Override
    public ArrayList<String> readCommands() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("commands");
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            if (attrs.getNamedItem("command").getNodeValue().equals("open")) {
                listOfCommands.add(attrs.getNamedItem("id").getNodeValue() + " " +
                        attrs.getNamedItem("command").getNodeValue() + " " +
                        attrs.getNamedItem("address").getNodeValue() + " " +
                        attrs.getNamedItem("time").getNodeValue());
            } else {
                listOfCommands.add(attrs.getNamedItem("id").getNodeValue() + " " +
                        attrs.getNamedItem("command").getNodeValue() + " " +
                        attrs.getNamedItem("attribute").getNodeValue());
            }
        }
        return listOfCommands;
    }
}
