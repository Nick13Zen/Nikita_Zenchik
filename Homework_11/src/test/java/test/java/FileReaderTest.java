package test.java;

import org.junit.Test;
import tat.maven.FileReader;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Nick on 29/10/16.
 */
public class FileReaderTest {
    @Test
    public void validation() throws Exception {
        FileReader readerFile = new FileReader();
        ArrayList<String[]> checkpoints = new ArrayList<>();
        String point = "0 0";
        checkpoints.add(point.split(" "));
        checkpoints.add(point.split(" "));
        assertFalse(readerFile.validation(checkpoints));
    }
}