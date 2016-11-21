package Reader;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * interface for classes of reading data from xml, txt and command line.
 * Created by Nikita Zenchik.
 */
public abstract class Reader {
    /**
     * Method to read data from file.
     * Will be implemented by inherits
     */
    public void readCommands() throws IOException, SAXException, ParserConfigurationException {

    }
}
