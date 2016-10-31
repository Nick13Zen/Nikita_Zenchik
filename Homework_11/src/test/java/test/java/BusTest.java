package test.java;

import org.junit.Test;
import tat.maven.Bus;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Nick on 29/10/16.
 */
public class BusTest {

    @Test
    public void moveToNextPoint() throws Exception {
        Bus bus = new Bus(1.0, 2, new BigDecimal(1.0));
        bus.setStartPoint(0.0, 0.0);
        bus.moveToNextPoint(0, 2);
        assertTrue(60 == bus.getCost());
    }

    @Test
    public void getTime() {
        Bus bus = new Bus(1.0, 2, new BigDecimal(1.0));
        System.out.println(bus.getTime());
        assertTrue(bus.getTime().equals("0 hours 0 minutes"));
    }

}