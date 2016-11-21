package Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read commands from command line
 * Created by Nikita Zenchik.
 */
public class ReadFromCommandLine extends Reader {

    public ArrayList<String> listOfCommands = new ArrayList<String>();

    /**
     * Method to read from command line.
     */
    @Override
    public void readCommands() {
        String inputLine;
        Scanner input = new Scanner(System.in);
        String argument ="";
        do {
            System.out.println("Enter command");
            inputLine = input.nextLine();
            listOfCommands.add(inputLine);
            System.out.println("Continue? (Enter 'yes' to repeat, any to continue)");
            argument = input.nextLine();
        } while (argument.equals("yes"));
    }

    /**
     * mehod to get list of commands
     *
     * @return ArrayList of commands
     */
    public ArrayList<String> getListOfCommands() {
        return listOfCommands;
    }
}