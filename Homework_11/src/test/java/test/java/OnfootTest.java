package test.java;

import org.junit.Test;
import tat.maven.Onfoot;

import static org.junit.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class OnfootTest {
    @Test
    public void getTime() throws Exception {
        Onfoot onfoot = new Onfoot(1.0);
        assertTrue(onfoot.getTime().equals("0 hours 0 minutes"));
    }

}