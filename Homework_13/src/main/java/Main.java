import Reader.*;

import java.io.File;

/**
 * Class containing entry point
 * Created by Nikita Zenchik.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Message.ABOUT);
        Executer ex = new Executer();
        try {
            ex.executeCommands(chooseReader(args).readCommands());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Mehtod to choose method to read
     * @param args arguments from command line
     * @return
     */
    public static Reader chooseReader(String[] args) {
        File file = new File(args[0]);
        if (file.exists()) {
            if (args[0].endsWith("xml")) {
                return new ReaderFromTxt(file);
            }
            if (args[0].endsWith("txt")) {
                return new ReaderFromTxt(file);
            }
            if (args[0].endsWith("json")) {
                return new ReadFromJson(file);
            }
        }
        return new ReadFromCommandLine(args);
    }
}