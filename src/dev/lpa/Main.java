package dev.lpa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "testing.csv";
        testFile(filename);

        File file = new File(filename);
        if (!file.exists()){
            System.out.println("I can't run unless this file exists");
            System.out.println("Quitting application, go figure it out");
            // returning in main causes app to end
            return;
        }
        System.out.println("Good to go, file exists");

        // TWO APPROACHES:

        // LBYL
        // Look before you leap
        // check for errors before performing an op

        // EAFP
        // Easier to ask forgiveness than permission
        // Assumes op will usually succeed, and handles any errors that occur if they do happen



    }


    private static void testFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            System.out.println("Maybe I'd log something either way");
        }

        System.out.println("File exists and able to use as a resource");
    }
}