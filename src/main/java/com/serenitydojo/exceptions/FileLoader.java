package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileLoader {


    public String readHelloWorld(String fileName) throws IOException {
        String fileContents = Files.readString(Paths.get(fileName));
        return fileContents;
    }

    public boolean fileContainsText(String filename, String expectedText) {
        try {
           // String path = "src/main/resources/" + filename;
            String fileContent = Files.readString(Paths.get(filename));
            return (fileContent.contains(expectedText));
        } catch (IOException e) {
            return true;
        }
    }

    public boolean fileDoeNotContainText(String filename, String expectedText) {
        try {
          //  String path = "src/main/resources/" + filename;
            String fileContent = Files.readString(Paths.get(filename));
            return (fileContent.contains(expectedText));
        } catch (NoSuchFileException e) {
            return false;
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }



    public boolean fileHasText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        try {
            return (Files.readString(Paths.get(path)).contains(expectedText));
        } catch (IOException e) {
            throw new MissingWelcomeFileException("Missing welcome file: " + filename, e);
        }
    }
}
