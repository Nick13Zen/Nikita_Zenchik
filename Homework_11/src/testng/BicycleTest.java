package test.java;

import org.testng.annotations.*;

import tat.maven.Bicycle;

import static org.testng.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class BicycleTest {
    Bicycle bicycle;
    double start;

    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {2, 0, 2},
                {3, 0, 3},
                {Double.NaN, Double.NaN, 9},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0},
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0},
                {9.219544457292887, 9, -2},
                {9.219544457292887, -2, 9}
        };
    }

    @BeforeTest
    public void setUp() {
        bicycle = new Bicycle(1.0);
        start = bicycle.getTime();
    }

    @Test
    public void getTime() {
        assertTrue(bicycle.getTime() == 0);
    }

    @Test(dataProvider = "points")
    public void moveToNextPointTestTime(double expected,
                                        double firstpoint,
                                        double secondpoint) throws Exception {
        bicycle.setStartPoint(0, 0);
        bicycle.moveToNextPoint(firstpoint, secondpoint);
        assertEquals(expected, bicycle.getTime());
    }
    @Test
    public void moveToNextPointTestTime() {
        bicycle.setStartPoint(0, 0);
        bicycle.moveToNextPoint(0, 2);
        assertNotEquals(start, bicycle.getTime());
    }
}