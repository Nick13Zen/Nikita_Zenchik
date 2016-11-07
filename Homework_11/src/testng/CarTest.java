package test.java;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import tat.maven.Car;

import java.math.BigDecimal;

/**
 * Created by Nick on 28/10/16.
 */
public class CarTest {
    Car car;
    double start;

    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {26, 0, 2},
                {39, 0, 3},
                {Double.NaN, Double.NaN, 9},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0},
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0},
                {119.85407794480753, 9, -2},
                {119.85407794480753, -2, 9}
        };
    }

    @BeforeTest
    public void setUp() {
        car = new Car(1.0, new BigDecimal(1.0));
        start = car.getTime();
    }

    @Test(dataProvider = "points")
    public void moveToNextPoint(double expected,
                                double firstpoint,
                                double secondpoint) throws Exception {
        car.setStartPoint(0, 0);
        car.moveToNextPoint(firstpoint, secondpoint);
        assertEquals(expected, car.getCost());
    }

    @Test
    public void getTime() {
        assertTrue(car.getTime() == 0);
    }

    @Test
    public void moveToNextPointTestTime() {
        car.setStartPoint(0, 0);
        car.moveToNextPoint(0, 2);
        assertNotEquals(start, car.getTime());
    }
}