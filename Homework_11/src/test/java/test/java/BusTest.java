package test.java;

import org.junit.Before;
import org.junit.Test;
import tat.maven.Bus;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Nick on 29/10/16.
 */
public class BusTest {

    Bus bus;

    @Before
    public void setUp() {
        Bus bus = new Bus(1.0, 2, new BigDecimal(1.0));
    }

    @Test
    public void moveToNextPoint() throws Exception {
        bus.setStartPoint(0.0, 0.0);
        bus.moveToNextPoint(0, 2);
        assertTrue(60 == bus.getCost());
    }

    @Test
    public void getTime() {
        assertTrue(bus.getTime() == 0);
    }

    @Test
    public void moveToNextPointTestTime() {
        double start = bus.getTime();
        bus.moveToNextPoint(0, 2);
        assertNotEquals(start, bus.getTime());
    }

}