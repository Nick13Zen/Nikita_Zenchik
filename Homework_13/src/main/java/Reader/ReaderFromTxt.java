package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to read commands from txt file
 * Created by Nikita Zenchik.
 */
public class ReaderFromTxt extends Reader {
    private File file;
    private ArrayList<String> listOfCommands = new ArrayList<String>();

    public ReaderFromTxt(File file){
        this.file = file;
    }
    /**
     * Method to read data from Txt file.
     */
    @Override
    public ArrayList<String> readCommands() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        line = in.readLine();
        while (line != null) {
            listOfCommands.add(line);
            line = in.readLine();
        }
        in.close();
        return listOfCommands;
    }
}
