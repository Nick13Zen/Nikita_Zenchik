package test.java;

import org.junit.Before;
import org.junit.Test;
import tat.maven.Onfoot;

import static org.junit.Assert.*;

/**
 * Created by Nick on 30/10/16.
 */
public class OnfootTest {
    Onfoot onfoot;

    @Before
    public void setUp() {
        Onfoot onfoot = new Onfoot(1.0);
    }

    @Test
    public void getTime() throws Exception {
        assertTrue(onfoot.getTime() == 0);
    }

    @Test
    public void moveToNextPointTestTime() {
        double start = onfoot.getTime();
        onfoot.moveToNextPoint(0, 2);
        assertNotEquals(start, onfoot.getTime());
    }

}