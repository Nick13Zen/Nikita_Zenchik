import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Created by Nick on 07/11/16.
 */
public class ValidatorTest {
    private Solve solve;

    @BeforeTest
    public void setUp() throws Exception {
        solve = new Solve();
    }

    @DataProvider(name = "positiveForEquilateral")
    public Object[][] getNumber() {
        return new Object[][]{
                {1.0, 1.0, 1.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {10.0, 10.0, 10.0},
                {156.3, 156.3, 156.3},
                {1765.67, 1765.67, 1765.67},
        };
    }

    @DataProvider(name = "positiveForIsosceles ")
    public Object[][] getIsoscelesNumber() {
        return new Object[][]{
                {3.0, 5.0, 5.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, 10000000},
                {10000000, Double.MAX_VALUE, Double.MAX_VALUE},
                {10.0, 10.0, 15},
                {150, 156.3, 156.3},
                {1500, 1765.67, 1765.67},
                {135, 135, 134.99999},
                {1765.67406, 1765.67456, 1765.67456},

        };
    }

    @DataProvider(name = "positiveForSimple")
    public Object[][] getSimpleNumber() {
        return new Object[][]{
                {10.0, 45.0, 37.0},
                {45.4, 65.8, 32.6},
                {130.6, 234.0, 124.7},
                {1.75, 2.55, 3.25},
        };
    }

    @DataProvider(name = "invalidData")
    public Object[][] negativeValues() throws Exception {
        return new Object[][]{
                {10, Double.NEGATIVE_INFINITY, 1},
                {10, Double.NaN, 23},
                {45, Double.POSITIVE_INFINITY, 7},
                {45, 7, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, 7, 45},
                {Double.NaN, 23, 10},
                {10, 23, Double.NaN},
                {10, 1, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, 1, 10},
                {Double.MIN_VALUE, 1000000.0000, Double.MIN_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, 1000000.0000},
                {1000000.0000, Double.MIN_VALUE, Double.MIN_VALUE}
        };
    }

    @DataProvider(name = "positiveForCheckZero")
    public Object[][] getZeroNumbers() {
        return new Object[][]{
                {5, 5, 0},
                {5, 0, 5},
                {0, 5, 5},
                {0.0, 0.0, 0.0},
        };
    }

    @Test(dataProvider = "positiveForEquilateral")
    public void testEquilateral(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Equilateral triangle.");
    }

    @Test(dataProvider = "positiveForIsosceles")
    public void testIsosceles(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Isosceles triangle.");
    }

    @Test(dataProvider = "positiveForSimple")
    public void testSimple(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Simple triangular.");
    }

    @Test(dataProvider = "invalidData")
    public void testSideTriangle(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Not a triangular.");
    }

    @Test(dataProvider = "invalidData", expectedExceptions = Exception.class)
    public void testCheckInvalidData(double a, double b, double c) throws Exception {
        Validator validator = new Validator();
        validator.checkInvalidData(a, b, c);
    }

    @Test(dataProvider = "positiveForCheckZero")
    public void testCheckZero(double a, double b, double c) {
        Validator validator = new Validator();
        assertFalse(validator.checkZero(a, b, c));

    }
}