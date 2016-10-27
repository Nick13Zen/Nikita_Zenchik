package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class with method to read ip from file.
 *
 * @author Nikita Zenchik
 */
public class ReadFile {
    /**
     * <tt>String</tt> with default name of file with ip addresses.
     */
    private static final String ADDRESSES_FILE = "addresses.txt";

    /**
     * Method to read ip from file.
     *
     * @return String array of ip.
     */
    public String[] getStrings() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ADDRESSES_FILE));
            String address;
            ArrayList<String> addressesList = new ArrayList<>();
            while ((address = reader.readLine()) != null) {
                addressesList.add(address.trim());
            }
            return addressesList.toArray(new String[addressesList.size()]);
        } catch (IOException ioe) {
            return null;
        }
    }
}
