package com.company;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Main class of the application. Contains the entry point.
 */
public class Main {

    /**
     * The entry point of application. Reads ip addresses from command line or file,
     * simulates poll of servers and writes results to file.
     * @param args command line launch parameters.
     */
    public static void main(String[] args) {
        int maxPing = 0;
        String[] ip;
        if (args.length != 0) {
            ip = args;
        } else {
            ip = new ReadFile().getStrings();
        }
        ArrayList<Server> ipList = getServersList(ip);
        int[] ping = new int[ipList.size()];
        for (int i = 0; i < ping.length; i++) {
            ping[i] = new TestPing().writePing();
            if (maxPing < ping[i]) {
                maxPing = ping[i];
            }
        }
        HtmlMarkerFiller filler = new HtmlMarkerFiller();
        for (int j = 0; ipList.size() > j; j++) {
            filler.addStringToTable(ipList.get(j).getIp(), ping[j], maxPing == ping[j]);
        }
        try {
            new WriteFile().writeToFile(filler.getResult());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error while writing file.");
        }

    }

    /**
     * Tries to build <tt>Server</tt>s with received ip addresses. Increases constant counter
     * for every invalid ip address.
     * @param ip <tt>String</tt> array with ip addresses.
     * @return <tt>ArrayList</tt> with <tt>Server</tt>s.
     */
    private static ArrayList<Server> getServersList(String[] ip) {
        ArrayList<Server> ipList = new ArrayList<>();
        for (String argument : ip) {
            try {
                ipList.add(Server.Builder.build(argument));
            } catch (Exception e) {
                System.out.println("Invalid ip: " + argument);
            }
        }
        return ipList;
    }
}
