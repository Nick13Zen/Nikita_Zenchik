package test.java;

import org.testng.annotations.*;

import tat.maven.Validator;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Nick on 29/10/16.
 */
public class ValidatorTest {
    Validator validator;
    ArrayList<String[]> checkpoints;
    String point = "0 0";

    @BeforeTest
    public void setUp() throws Exception {
        validator = new Validator();
        checkpoints = new ArrayList<>();
    }

    @Test
    public void validationPositive() throws Exception {
        point = "0 0";
        checkpoints.add(point.split(" "));
        checkpoints.add(point.split(" "));
        assertFalse(validator.validation(checkpoints));
    }

    @Test
    public void validationNegative() throws Exception {
        validator = new Validator();
        checkpoints = new ArrayList<>();
        checkpoints.add(point.split(" "));
        point = "0 1";
        checkpoints.add(point.split(" "));
        assertTrue(validator.validation(checkpoints));
    }
}