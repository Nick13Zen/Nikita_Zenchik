package Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read commands from command line
 * Created by Nikita Zenchik.
 */
public class ReadFromCommandLine extends Reader {
    private String[] args;
    private ArrayList<String> listOfCommands = new ArrayList<String>();

    public ReadFromCommandLine(String[] args) {
        this.args = args;
    }

    /**
     * Method to read from command line.
     */
    @Override
    public ArrayList<String> readCommands() {
        for (String line : args) {
            line = line.replaceAll("\"","");
            listOfCommands.add(line);
        }
        return listOfCommands;
    }

}