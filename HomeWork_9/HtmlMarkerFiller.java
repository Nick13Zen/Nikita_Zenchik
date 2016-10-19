package com.company;

/**
 * Creates html file with table of file names, types, date of creation and size.
 *
 * @author Nikita Zenchik
 */
public class HtmlMarkerFiller {
    // Constants for html file table header.
    private static final String NAME = "ИМЯ";
    private static final String TYPE = "ТИП";
    private static final String DATE = "ДАТА СОЗДАНИЯ";
    private static final String SIZE = "РАЗМЕР (в Kb)";
    // Constants with table colors.
    private final static String HEAD_COLOR = "#A4A4A4";
    private final static String COLOR_1 = "#D8D8D8";
    private final static String COLOR_2 = "#E6E6E6";
    // Constants with html marking.
    private final String START_HTML
            = "<html>\n"
            + "  <head>\n"
            + "    <mate charset=\"utf-8\">\n"
            + "  </head>"
            + "    <body>\n"
            + "        <table border = 0 align=center width=25%>\n"
            + "          <tbody>\n"
            + "            <tr bgcolor=\"" + HEAD_COLOR + "\"><th>\n" + NAME + "</th><th>"
            + TYPE + "</th><th>" + DATE + "</th><th>" + SIZE + "</th></tr>";
    private final String END_HTML
            = "      </tbody>\n"
            + "    </table>\n"
            + "  </body>\n"
            + "</html>";
    /**
     * Attribute for table marking.
     */
    private String tableLines = "";
    /**
     * Attribute for color switch.
     */
    private boolean colorSwitcher = true;

    /**
     * Adds line in table.
     *
     * @param name file name.
     * @param type file type.
     * @param date file date of creation.
     * @param size file size.
     */
    public void addTableLine(String name, String type, String date, double size) {
        String color = (colorSwitcher) ? COLOR_1 : COLOR_2;

        colorSwitcher = !colorSwitcher;
        tableLines += "<tr bgcolor=" + color + "><th>"
                + name + "</th>"
                + "<th>" + type + "</th>"
                + "<th>" + date + "</th>"
                + "<th>" + size + "</th></tr>\n";
    }

    /**
     * @return html marking.
     */
    public String getHtmlMarking() {
        return START_HTML + tableLines + END_HTML;
    }


}
