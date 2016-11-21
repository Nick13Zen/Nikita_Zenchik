import java.io.*;
import java.util.ArrayList;

/**
 * Class to create and fill txt file
 * @author Alexey Makovski.
 */
public class TxtFileMaker {
    /**
     * Method to write txt file
     */
    public void txtFileWriter(int failedTests,
                              int passedTests,
                              double allCommandTime,
                              ArrayList<String> txtFileData) throws IOException {
        BufferedWriter outPut = new BufferedWriter(new FileWriter("log.txt"));
        for (String line : txtFileData) {
            outPut.write(line + "\r\n");
        }
        outPut.write("Total tests: " + (passedTests + failedTests) + " \r\n" +
                "Passed/Failed: " + passedTests + "/" + failedTests + " \r\n" +
                "Total time: " + allCommandTime + " \r\n" +
                "Average time: " + (allCommandTime / (passedTests + failedTests)));
        outPut.close();
    }

}
