package tat.maven;

/**
 * Interface Moveable points methods, that belongs to objects,
 * that can travel
 */
public interface Moveable {

    /**
     * Method will be implemented by inherits
     * To set start point of travel
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    void setStartPoint(double x, double y);

    /**
     * Method will be implemented by inherits
     * Method emulates moving to the next point, which coordinates got as
     * parameters. It calculates current travel time
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    void moveToNextPoint(double x, double y);

    /**
     * Method will be implemented by inherits
     * Method returns current travel time in special format
     *
     * @return line with current time
     */
    double getTime();

    /**
     * Method will be implemented by inherits
     * Method returns cost of travel. Travelling afoot doesn't waste any resources, so method returns zero
     *
     * @return travelCost
     */
    double getCost();
}
