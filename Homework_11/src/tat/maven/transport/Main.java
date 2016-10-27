package tat.maven.transport;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.*;

/**
 * Main class containing enter point to the program.
 */
public class Main {

    /**
     * Name of input file.
     */
    private static final String FILE_NAME = "Input.txt";
    /**
     * Constants.
     */
    private static final int COUNT_BUS_PASSENGERS = 50;
    private static final double CAR_SPEED = 120;
    private static final double BUS_SPEED = 70;
    private static final double BICYCLE_SPEED = 20;
    private static final double AFOOT_SPEED = 5;
    private static final BigDecimal FUEL_PRICE = new BigDecimal("1.19");

    /**
     * Method creates object, that read file, emulate movement of vehicles
     * and show massage with time and cost.
     */
    public static void main(String[] args) {
        // write your code here
        try {
            FileReader readerFile = new FileReader();
            // List of checkpoints
            ArrayList<String[]> checkpoints = readerFile.read(FILE_NAME);
            // List of vehicles
            HashMap<String, Moveable> transport = new HashMap<>();
            transport.put(Onfoot.getName(), new Onfoot(AFOOT_SPEED));
            transport.put(Car.getName(), new Car(CAR_SPEED, FUEL_PRICE));
            transport.put(Bicycle.getName(), new Bicycle(BICYCLE_SPEED));
            transport.put(Bus.getName(), new Bus(BUS_SPEED, COUNT_BUS_PASSENGERS, FUEL_PRICE));
            Printer output = new Printer();
            for (Map.Entry<String, Moveable> vehicle : transport.entrySet()) {
                moveVehicles(vehicle, checkpoints);
                output.printStats(vehicle);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error. Incorrect input ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method emulates movement of vehicles from list.
     *
     * @param vehicle     list of vehicle
     * @param checkpoints list of checkpoints
     */
    private static void moveVehicles(Map.Entry<String,
            Moveable> vehicle, ArrayList<String[]> checkpoints) {
        double[] coordinates = new double[2];
        coordinates[0] = Double.parseDouble(checkpoints.get(0)[0]);
        coordinates[1] = Double.parseDouble(checkpoints.get(0)[1]);
        vehicle.getValue().setStartPoint(coordinates[0], coordinates[1]);
        for (String[] coordinate : checkpoints) {
            vehicle.getValue().moveToNextPoint(
                    Double.parseDouble(coordinate[0])
                    , Double.parseDouble(coordinate[1]));
        }
    }
}
