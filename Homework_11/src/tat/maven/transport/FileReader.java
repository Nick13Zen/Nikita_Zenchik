package tat.maven.transport;

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
        BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
        String[] currentCoordinates;
        do {
            currentCoordinates = reader.readLine().split(" ");
            if (currentCoordinates.length != 2) {
                System.out.println("Error. Missing finish point.");
                continue;
            }
            checkpoints.add(currentCoordinates);
        } while ((reader.readLine()) != null);
        // Validate start and finish checkpoints
        if (!validation(checkpoints)) {
            throw new Exception("Error. Start and finish coordinates can't be equal");
        }
        return checkpoints;
    }

    /**
     * Method validates start and finish points.
     *
     * @param checkpoints list of coordinates of checkpoints
     * @return boolean value: true - if start and finish coordinates are not equal
     */
    private boolean validation(ArrayList<String[]> checkpoints) {
        return (Double.parseDouble(checkpoints.get(0)[0])
                != Double.parseDouble(checkpoints.get(checkpoints.size() - 1)[1]));
    }
}
