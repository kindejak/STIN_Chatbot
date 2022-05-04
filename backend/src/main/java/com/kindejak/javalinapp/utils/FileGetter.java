package com.kindejak.javalinapp.utils;


import java.io.InputStream;


public class FileGetter {

    // solution from https://mkyong.com/java/java-read-a-file-from-resources-folder/
    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
