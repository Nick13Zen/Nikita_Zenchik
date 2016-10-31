package tat.maven;

import java.util.Map;

/**
 * Class outputs statistics of travel of definite vehicle
 */
public class Printer {

    /**
     * Method outputs information of definite vehicle
     *
     * @param vehicle list of vehicles
     */
    public void printMessage(Map.Entry<String, Moveable> vehicle) {
        System.out.println("Transport: " + vehicle.getKey());
        System.out.println("Time = " + (int) (vehicle.getValue().getTime()) + " hours "
                + Math.round((vehicle.getValue().getTime() - (int) vehicle.getValue().getTime()) * 60) + " minutes");
        System.out.println("Cost (BYN) = " + vehicle.getValue().getCost());
    }
}
