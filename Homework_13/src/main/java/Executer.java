
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


/**
 * Class to run through commands
 * Created by Nikita Zenchik.
 */
public class Executer {

    public ArrayList<String> openCommands = new ArrayList<String>();
    private ArrayList<String> fileData = new ArrayList<String>();

    /**
     * Method to find all open commands in list of commands
     *
     * @param listOfCommands ArrayList of commands
     */
    private ArrayList<String> findAllOpens(ArrayList<String> listOfCommands) {
        for (String command : listOfCommands) {
            if (command.split(" ")[1].equals("open")) {
                openCommands.add(command);
            }
        }
        return openCommands;
    }

    /**
     * Method to run commands
     *
     * @param listOfCommands ArrayList of commands
     */
    public void executeCommands(ArrayList<String> listOfCommands) {
        findAllOpens(listOfCommands);
        String id;
        TxtFileMaker txtFile = new TxtFileMaker();
        Commands commands = new Commands();
        WebDriver driver = new ChromeDriver();
        for (String openCommand : openCommands) {
            id = openCommand.split(" ")[0];
            fileData.add(
                    commands.openUrl(openCommand.split(" ")[2].replaceAll("\"",""),
                            openCommand.split(" ")[3].replaceAll("\"","")));
            for (String command : listOfCommands) {
                if (command.split(" ")[0].equals(id)) {
                    if (command.split(" ")[1].equals("checkLinkPresentByHref")) {
                        fileData.add(
                                commands.checkLinkPresentByHref(
                                        command.split(" ")[2].replaceAll(" \"","")));
                    } else if (command.split(" ")[1].equals("checkPageTitle")) {
                        fileData.add(
                                commands.checkPageTitle(command.split(" ")[2].replaceAll(" \"","")));
                    } else if (command.split(" ")[1].equals("checkLinkPresentByName")) {
                        fileData.add(
                                commands.checkLinkPresentByName(command.split(" ")[2].replaceAll(" \"","")));
                    } else if (command.split(" ")[1].equals("checkPageContains")) {
                        fileData.add(
                                commands.checkPageContains(command.split(" ")[2].replaceAll(" \"","")));
                    }
                }
            }
        }
        driver.quit();
        try {
            TxtFileMaker tx = new TxtFileMaker();
            tx.txtFileWriter(commands.getFailedTests(),
                    commands.getPassedTests(),
                    commands.getTime(),
                    fileData);
        } catch (Exception e) {
            System.out.println(Message.CAN_NOT_WRITE_FILE);
        }
    }
}
