package tat.maven;

import java.util.ArrayList;

/**
 * Class to validate parameters.
 */
public class Validator {
    /**
     * Method validates start and finish points.
     *
     * @param checkpoints list of coordinates of checkpoints
     * @return boolean value: true - if start and finish coordinates are not equal
     */
    public boolean validation(ArrayList<String[]> checkpoints) {
        return (Double.parseDouble(checkpoints.get(0)[0])
                != Double.parseDouble(checkpoints.get(checkpoints.size() - 1)[1]));
    }
}
