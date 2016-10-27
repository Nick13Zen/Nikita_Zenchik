package com.company;

/**
 * Creates html file with table of file names, types, date of creation and size.
 *
 * @author Nikita Zenchik
 */
public class HtmlMarkerFiller {
    /*
     * Constants with table header names.
     */
    private static final String SERVER = "Server";
    private static final String RESPONSE = "Response, ms";
    /*
     * Colors constants.
     */
    private static final String HEADER_TABLE_COLOR = "#999999";
    private static final String BODY_TABLE_COLOR_1 = "#efefef";
    private static final String BODY_TABLE_COLOR_2 = "#d9d9d9";
    private static final String BODY_TABLE_PICK_COLOR = "#ff0000";
    private static final String BORDER_COLOR = "#ffffff";
    private static final String TEXT_COLOR = "#000000";
    /*
     * Constant strings with Html marking.
     */
    private static final String HEADER
            = "<!DOCTYPE html>\n"
            + "<html lang=\"ru\">\n"
            + "  <head>\n"
            + "    <title>Pings</title>\n"
            + "    <meta charset=\"utf-8\">\n"
            + "    <style>"
            + "      tr > * {"
            + "        padding: 5px"
            + "      }"
            + "    </style>"
            + "  </head>\n"
            + "  <body text\"" + TEXT_COLOR + "\">\n"
            + "    <table bordercolor=\"" + BORDER_COLOR + "\">\n"
            + "      <tr bgcolor=\"" + HEADER_TABLE_COLOR + "\">\n"
            + "        <th width=\"250px\">" + SERVER + "</th>\n"
            + "        <th width=\"250px\">" + RESPONSE + "</th>\n"
            + "      </tr>\n";
    private static final String FOOTER
            = "    </table>\n"
            + "  </body>\n"
            + "</html>";
    /**
     * String with Html marking.
     */
    private String result = HEADER;
    /**
     * Table body line color switcher.
     */
    private boolean colorSwitcher = true;

    /**
     * Adds new String to table in Html marking.
     * @param ip one of table values.
     * @param ping one of table values.
     * @param picked flag that indicates if string must be distinguish with special color.
     */
    public void addStringToTable(String ip, int ping, boolean picked) {
        if (picked) {
            result += "      <tr bgcolor=\"" + BODY_TABLE_PICK_COLOR + "\">\n";
        } else if (colorSwitcher) {
            result += "      <tr bgcolor=\"" + BODY_TABLE_COLOR_1 + "\">\n";
        } else {
            result += "      <tr bgcolor=\"" + BODY_TABLE_COLOR_2 + "\">\n";
        }
        result += "        <td>" + ip + "</td>\n"
                + "        <td>" + ping + "</td>\n"
                + "      </tr>\n";
        colorSwitcher = !colorSwitcher;
    }

    /**
     * @return <tt>String</tt> with Html marking.
     */
    public String getResult() {
        return result + FOOTER;
    }


}
