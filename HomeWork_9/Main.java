package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main class that contains entry point.
 *
 * @author Nikita Zenchik
 */
public class Main {
    /**
     * Finds files in current directory and saves to html file some information about them.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Path path = Paths.get(".");
            File folder = new File(path.toString());
            File[] listOfFiles = folder.listFiles();
            HtmlMarkerFiller filler = new HtmlMarkerFiller();
            for (File file : listOfFiles) {
                FileAttributesProvider provider = new FileAttributesProvider(file);
                filler.addTableLine(provider.getName()
                        , provider.getType()
                        , provider.getDate()
                        , provider.getSize() / 1024);
            }
            new FileWriter().writeToFile(filler.getHtmlMarking());
        } catch (java.io.FileNotFoundException | java.io.UnsupportedEncodingException e){
                System.out.println("Error while writing file.");
            }
    }
}
