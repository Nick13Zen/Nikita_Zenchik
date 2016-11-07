package test.java;

import org.junit.Before;
import org.junit.Test;
import tat.maven.Bicycle;

import static org.junit.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class BicycleTest {
    Bicycle bicycle;

    @Before
    public void setUp() {
        Bicycle bicycle = new Bicycle(1.0);
    }

    @Test
    public void getTime() {
        assertTrue(bicycle.getTime() == 0);
    }

    @Test
    public void moveToNextPointTestTime() {
        double start = bicycle.getTime();
        bicycle.moveToNextPoint(0, 2);
        assertNotEquals(start, bicycle.getTime());
    }

}