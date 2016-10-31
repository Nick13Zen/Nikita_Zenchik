package test.java;

import org.junit.Test;
import tat.maven.Bicycle;

import static org.junit.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class BicycleTest {

    @Test
    public void getTime() {
        Bicycle bicycle = new Bicycle(1.0);
        assertTrue(bicycle.getTime().equals("0 hours 0 minutes"));
    }
    @Test
    public void moveToNextPointTestTime() {
        Bicycle bicycle = new Bicycle(1.0);
        String start = bicycle.getTime();
        bicycle.moveToNextPoint(0, 2);
        assertNotEquals(start, bicycle.getTime());
    }

}