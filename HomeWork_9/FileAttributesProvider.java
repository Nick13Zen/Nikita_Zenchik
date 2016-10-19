package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Provides information about file attributes.
 *
 * @author Nikita Zenchik
 */
public class FileAttributesProvider {
    // Constants for file type.
    private static final String TYPE_DIR = "DIR";
    private static final String TYPE_FILE = "FILE";
    private static final String TYPE_OTHER = "OTHER";
    /**
     * Field for file.
     */
    private File file;

    /**
     * Creates new FileAttributesProvider with received file.
     *
     * @param file file to provide information about.
     */
    public FileAttributesProvider(File file) {
        this.file = file;
    }

    /**
     * @return file creation date.
     */
    public String getDate() {
        try {
            BasicFileAttributes attr =
                    Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            String[] line = attr.creationTime().toString().split("T")[0].split("-");
            return line[2] + "." + line[1] + "." + line[0];
        } catch (IOException e) {
            return "No data";
        }
    }

    /**
     * @return file name.
     */
    public String getName() {
        return file.getName();
    }

    /**
     * @return file size.
     */
    public double getSize() {
        double size = 0;
        if (file.isDirectory()) {
            // Can be stack overflow.
            for (File inFolder : file.listFiles()) {
                ///
                size += new FileAttributesProvider(inFolder).getSize();
            }
        }
        return size + file.length();
    }

    /**
     * @return file type.
     */
    public String getType() {
        if (file.isDirectory()) {
            return TYPE_DIR;
        }
        if (file.isFile()) {
            return TYPE_FILE;
        }
        return TYPE_OTHER;
    }
}
