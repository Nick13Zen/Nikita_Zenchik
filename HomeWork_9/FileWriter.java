package com.company;

import java.io.PrintWriter;

/**
 * Creates new file and writes data into it.
 *
 * @author Nikita Zenchik
 */
public class FileWriter {
    /**
     * Output file name.
     */
    private static final String FILE_NAME = "FileTest.html";

    /**
     * Creates new file and writes data into it.
     *
     * @param fileData
     */
    public void writeToFile(String fileData) throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException{
            String encoding = System.getProperty("consol.encoding", "utf-8");
            PrintWriter writer = new PrintWriter(FILE_NAME, encoding);
            writer.write(fileData);
            writer.close();
    }
}
