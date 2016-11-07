package tat.maven;

import java.math.BigDecimal;

/**
 * Class contains data of travelling by bus.
 */
public class Bus implements Moveable {

    /**
     * Constants.
     */
    private double averageSpeed = 0.0;
    private final double FUEL_CONSUMPTION = 30.0;
    public static final String NAME = "Bus";
    private int countPeople = 30;
    private BigDecimal fuelPrice = new BigDecimal(0.0);
    private double travelTime = 0.0;
    private double travelCost = 0.0;

    /**
     * Current coordinates.
     */
    private double x = 0.0;
    private double y = 0.0;

    /**
     * Constructor creates the vehicle, set average speed, count of people,
     * fuel price
     *
     * @param averageSpeed average speed of travelling afoot
     * @param countPeople  count of people
     * @param fuelPrice    fuel price
     */
    public Bus(double averageSpeed, int countPeople, BigDecimal fuelPrice) {
        this.averageSpeed = averageSpeed;
        this.countPeople = countPeople;
        this.fuelPrice = fuelPrice;
    }

    /**
     * Method sets start coordinates.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void setStartPoint(double x, double y) {
        this.x = x;
        this.y = y;
        travelTime = 0;
        travelCost = 0;
    }

    /**
     * Method emulates moving to the next point, which coordinates got as
     * parameters. It calculates current travel time and cost.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void moveToNextPoint(double x, double y) {
        double X = Math.abs(x - this.x);
        double Y = Math.abs(y - this.y);
        this.x = x;
        this.y = y;
        travelTime += Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)) / averageSpeed;
        travelCost += Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2))
                * FUEL_CONSUMPTION * fuelPrice.doubleValue()
                * (0.5 * countPeople);
    }

    /**
     * Method returns current travel time.
     *
     * @return line with current time
     */
    @Override
    public double getTime() {
        return travelTime;
    }

    /**
     * Method returns current cost of travel
     *
     * @return cost of travel
     */
    @Override
    public double getCost() {
        return travelCost;
    }

    /**
     * Method returns name of vehicle
     *
     * @return name of vehicle
     */
    public static String getName() {
        return NAME;
    }
}
