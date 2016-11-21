package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to read commands from txt file
 * Created by Nikita Zenchik.
 */
public class ReaderFromTxt extends Reader {
    private static String FilePath = "./InputData.txt";
    public ArrayList<String> listOfCommands = new ArrayList<String>();

    /**
     * Method to read data from Txt file.
     */
    @Override
    public void readCommands() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FilePath));
        String line;
        line = in.readLine();
        while (line != null) {
            listOfCommands.add(line);
            line = in.readLine();
        }
        in.close();
    }
    /**
     * mehod to get list of commands
     * @return ArrayList of commands
     */
    public ArrayList<String> getListOfCommands(){

        return listOfCommands;
    }
}
