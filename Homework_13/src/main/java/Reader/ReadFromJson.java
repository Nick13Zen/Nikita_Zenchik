package Reader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to read from json file
 * Created by Nikita Zenchik.
 */
public class ReadFromJson extends Reader {
    ArrayList<String> listOfCommands = new ArrayList<String>();

    @Override
    public void readCommands() throws IOException {

    }

    public ArrayList<String> getListOfCommands() {

        return listOfCommands;
    }
}
