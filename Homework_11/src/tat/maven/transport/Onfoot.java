package tat.maven.transport;

/**
 * Class contains data of travelling afoot.
 */
public class Onfoot implements Moveable {
    /**
     * Constants.
     */
    private double averageSpeed = 0.0;
    public static final String NAME = "Onfoot";
    private double travelTime = 0.0;

    /**
     * Current coordinates
     */
    private double x = 0.0, y = 0.0;

    /**
     * Constructor creates the vehicle, set average speed
     *
     * @param averageSpeed average speed of travelling onfoot
     */
    public Onfoot(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    /**
     * Method sets start coordinates of travelling
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void setStartPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method emulates moving to the next point, which coordinates got as
     * parameters. It calculates current travel time
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
        travelTime += (Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)) / averageSpeed);
    }

    /**
     * Method returns current travel time in special format
     *
     * @return line with current time
     */
    @Override
    public String getTime() {
        return (int) (travelTime) + " hours "
                + Math.round((travelTime - (int) travelTime) * 60) + " minutes";
    }

    /**
     * Method returns cost of travel. Travelling afoot doesn't waste any resources, so method returns zero
     *
     * @return zero
     */
    @Override
    public double getCost() {
        return 0.0;
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