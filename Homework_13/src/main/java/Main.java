import Reader.ReadFromCommandLine;
import Reader.ReadFromJson;
import Reader.ReaderFromTxt;
import Reader.ReaderFromXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing entry point
 * Created by Nikita Zenchik.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Message.ABOUT);
        System.out.println(Message.INSTRACTIONS);
        String command;
        ArrayList<String> commands = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        command = input.next();
        if (command.equals("xml")) {
            ReaderFromXml readXml = new ReaderFromXml();
            try {
                readXml.readCommands();
                commands = readXml.getListOfCommands();
            } catch (Exception e) {
                System.out.println(Message.ERROR_WHILE_READ_XML);
            }
        } else if (command.equals("txt")) {
            ReaderFromTxt readTxt = new ReaderFromTxt();
            try {
                readTxt.readCommands();
                commands = readTxt.getListOfCommands();
            } catch (IOException e) {
                System.out.println(Message.ERROR_WHILE_READ_TXT);
            }
        } else if (command.equals("command")) {
            ReadFromCommandLine readCommandLine = new ReadFromCommandLine();
            readCommandLine.readCommands();
            commands = readCommandLine.getListOfCommands();
        } else if (command.equals("json")) {
            ReadFromJson readJson = new ReadFromJson();
            try {
                readJson.readCommands();
                commands = readJson.getListOfCommands();
            } catch (IOException e) {
                System.out.println(Message.ERROR_WHILE_READ_JSON);
            }
        } else {
            System.out.println(Message.UNKNOWN_COMMAND);
        }
        Executer ex = new Executer();
        ex.executeCommands(commands);
    }
}