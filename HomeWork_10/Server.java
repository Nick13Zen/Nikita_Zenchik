package com.company;

/**
 * Class that represents model of server.
 *
 * @author Nikita Zenchik
 */
public class Server {
    /**
     * <tt>String</tt> with ip address of this server.
     */
    private String ip;

    /**
     * Private constructor for avoiding creation with invalid ip address.
     *
     * @param ip <tt>String</tt> with ip address.
     */
    private Server(String ip) {
        this.ip = ip;
    }

    /**
     * @return <tt>String</tt> with ip of this <tt>Server</tt>.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Class that represents Builder design pattern.
     */
    public static class Builder {
        /**
         * Tries to build <tt>Server</tt> with received ip address.
         *
         * @param ip <tt>String</tt> with ip address.
         * @return new <tt>Server</tt> with received ip address.
         */
        public static Server build(String ip) throws Exception {
            validate(ip);
            return new Server(ip);
        }


        /**
         * Checks if ip address is valid.
         *
         * @param ip <tt>String</tt> with ip address to check.
         * @throws Exception if ip address is invalid.
         */
        private static void validate(String ip) throws Exception {
            for (int i = 0; i < 3; i++) {
                int separatorIndex = ip.indexOf(".");
                if (separatorIndex == -1) {
                    throw new Exception("Invalid ip address.");
                }
                String ipPart = ip.substring(0, separatorIndex);
                if (ipPart.startsWith("+")) {
                    throw new Exception("Invalid ip address.");
                }
                int number = Integer.parseInt(ipPart);
                if (number < 0 || number > 255) {
                    throw new Exception("Invalid ip address.");
                }
                ip = ip.substring(separatorIndex + 1);
            }
            int number = Integer.parseInt(ip);
            if (number < 0 || number > 255) {
                throw new Exception("Invalid ip address.");
            }

        }
    }
}