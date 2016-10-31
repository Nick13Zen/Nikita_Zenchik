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
    @Test
    public void moveToNextPoint() throws Exception {
        Car car = new Car(1.0, new BigDecimal(1.0));
        car.setStartPoint(0, 0);
        car.moveToNextPoint(0, 2);
        assertTrue(26 == car.getCost());
    }

    @Test
    public void getTime() {
        Car car = new Car(1.0, new BigDecimal(1.0));
        assertTrue(car.getTime().equals("0 hours 0 minutes"));
    }
}