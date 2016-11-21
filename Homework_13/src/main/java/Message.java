/**
 * Class with messages for user
 * Created by Nikita Zenchik.
 */
public class Message {
    public static final String ABOUT = "The program to test website.";
    public static final String INSTRACTIONS = "Input command.\n" +
            "(command) to read from command line\n" +
            "(xml) to read from xml file\n" +
            "(txt) to read from txt file\n" +
            "(json) to read from json file\n";
    public static final String UNKNOWN_COMMAND = "Error. Cheek input command.\n" +
            "Command starts with id, then command name and arguments. All divided by space.";
    public static final String ERROR_WHILE_READ_XML = "Error while reading xml file.\n" +
            " Check file path, file name and file structure.";
    public static final String ERROR_WHILE_READ_TXT = "Error while reading txt file.\n" +
            " Check file path, file name and file structure.";
    public static final String ERROR_WHILE_READ_JSON = "Error while reading json file.\n" +
            " Check file path, file name and file structure.";
    public static final String CAN_NOT_WRITE_FILE = "Error writing file.\n" +
            "Can not write file.";
}