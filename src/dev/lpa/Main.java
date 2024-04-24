package dev.lpa;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String filename = "testing.csv";
        Path path = Paths.get(filename);
//        try {
//            List<String> lines = Files.readAllLines(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

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
}