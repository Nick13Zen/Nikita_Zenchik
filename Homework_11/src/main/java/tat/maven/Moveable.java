package tat.maven;

/**
 * Interface Moveable points methods, that belongs to objects,
 * that can travel
 */
public interface Moveable {

    /**
     * Method will be implemented by inherits
     */
    void setStartPoint(double x, double y);

    /**
     * Method will be implemented by inherits
     */
    void moveToNextPoint(double x, double y);

    /**
     * Method will be implemented by inherits
     */
    String getTime();

    /**
     * Method will be implemented by inherits
     */
    double getCost();
}
