package test.java;

import org.junit.Before;
import org.junit.Test;
import tat.maven.Car;

import static org.junit.Assert.*;

import java.math.BigDecimal;

/**
 * Created by Nick on 28/10/16.
 */
public class CarTest {
    Car car;

    @Before
    public void setUp() {
        Car car = new Car(1.0, new BigDecimal(1.0));
    }
    @Test
    public void moveToNextPoint() throws Exception {
        car.setStartPoint(0, 0);
        car.moveToNextPoint(0, 2);
        assertTrue(26 == car.getCost());
    }

    @Test
    public void getTime() {
        assertTrue(car.getTime().equals("0 hours 0 minutes"));
    }

    @Test
    public void moveToNextPointTestTime() {
        String start = car.getTime();
        car.moveToNextPoint(0, 2);
        assertNotEquals(start, car.getTime());
    }
}