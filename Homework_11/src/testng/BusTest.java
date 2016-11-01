package test.java;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import tat.maven.Bus;

import java.math.BigDecimal;


/**
 * Created by Nick on 29/10/16.
 */
public class BusTest {
    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {60, 0, 2},
                {90, 0, 3},
                {Double.NaN, Double.NaN, 9},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0},
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0},
                {161.55494421403512, 5, -2},
                {161.55494421403512, -2, 5}
        };
    }

    Bus bus;
    double start;

    @BeforeTest
    public void setUp() {
        bus = new Bus(1.0, 2, new BigDecimal(1.0));
        start = bus.getTime();
    }

    @Test(dataProvider = "points")
    public void moveToNextPoint(double expected,
                                double firstpoint,
                                double secondpoint) throws Exception {
        bus.setStartPoint(0.0, 0.0);
        bus.moveToNextPoint(firstpoint, secondpoint);
        assertEquals(expected, bus.getCost());
    }

    @Test
    public void getTime() {
        assertTrue(bus.getTime() == 0);
    }

    @Test
    public void moveToNextPointTestTime() {
        bus.setStartPoint(0, 0);
        bus.moveToNextPoint(0, 2);
        assertNotEquals(start, bus.getTime());
    }

}