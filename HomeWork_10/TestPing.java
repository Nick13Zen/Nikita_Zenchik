package com.company;

import java.util.Random;

/**
 * Class that simulates poll of server by assign random number from 10 to 500 ms to it.
 *
 * @author Nikita Zenchik
 */
public class TestPing {

    /**
     *  * Simulates poll of received server.
     *
     * @return random number from 10 to 500.
     */
    public int writePing() {
        return new Random().nextInt(491) + 10;
    }
}