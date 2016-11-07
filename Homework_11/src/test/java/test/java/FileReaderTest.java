package test.java;

import org.junit.Before;
import org.junit.Test;
import tat.maven.FileReader;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Nick on 29/10/16.
 */
public class FileReaderTest {
    FileReader readerFile;
    ArrayList<String[]> checkpoints;
    String point = "0 0";

    @Before
    public void setUp() throws Exception {
        readerFile = new FileReader();
        checkpoints = new ArrayList<>();
        checkpoints.add(point.split(" "));
    }

    @Test
    public void validationPositive() throws Exception {
        checkpoints.add(point.split(" "));
        assertFalse(readerFile.validation(checkpoints));
    }

    @Test
    public void validationNegative() throws Exception {
        point = "0 1";
        checkpoints.add(point.split(" "));
        assertTrue(readerFile.validation(checkpoints));
    }
}