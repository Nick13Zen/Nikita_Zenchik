package tat.maven;

import java.io.*;
import java.util.*;

/**
 * Class reads data from file and return list of checkpoints.
 */
public class FileReader {

    /**
     * Method reads data from file and returns list of checkpoints
     *
     * @param path path to file
     * @return list of coordinates of checkpoints
     */
    public ArrayList<String[]> read(String path) throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            String[] currentCoordinates;
            while ((reader.readLine()) != null) {
                currentCoordinates = reader.readLine().split(" ");
                if (currentCoordinates.length != 2) {
                    System.out.println("Error. Missing finish point.");
                    continue;
                }
                checkpoints.add(currentCoordinates);
            }
            if (!new Validator().validation(checkpoints)) {
                throw new Exception();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return checkpoints;
    }
}
