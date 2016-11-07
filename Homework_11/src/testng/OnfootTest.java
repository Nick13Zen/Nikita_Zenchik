package test.java;


import org.testng.annotations.*;
import tat.maven.Onfoot;

import static org.testng.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class OnfootTest {
    Onfoot onfoot;
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
        onfoot = new Onfoot(1.0);
        start = onfoot.getTime();
    }

    @Test
    public void getTime() throws Exception {
        assertTrue(onfoot.getTime() == 0);
    }

    @Test(dataProvider = "points")
    public void moveToNextPoint(double expected, double firstpoint, double secondpoint) throws Exception {
        onfoot.setStartPoint(0, 0);
        onfoot.moveToNextPoint(firstpoint, secondpoint);
        assertEquals(expected, onfoot.getTime());
    }

    @Test
    public void moveToNextPointTestTime() {
        onfoot.setStartPoint(0, 0);
        onfoot.moveToNextPoint(0, 2);
        assertNotEquals(start, onfoot.getTime());
    }

}