package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

// NOTES

// FILE HANDLE
    // ref to a file used by OS to track the file
    // An abstract rep of the file; doesn't contain file's actual data

// FILE RESOURCE
    // The actual data from the file
    // Stored on disk, accessed by OS and applications

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "testing.csv";

        File file = new File(filename);
        if (!file.exists()){
            System.out.println("I can't run unless this file exists");
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
        FileReader reader = null;

        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(filename);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(reader != null){
                // Make sure to close file when done, usually in finally block
                try{
                    reader.close();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way");
        }

        System.out.println("File exists and able to use as a resource");
    }

    // more elegant way than original testFile
    private static void testFile2(String fileName){
        try (FileReader reader = new FileReader(fileName)) {
            // Can have multiple catch clauses
            // This might occur when opening or closing resource
        }
        catch(NullPointerException | IllegalArgumentException badData){
            System.out.println("User has entered bad data " + badData.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println("File '" + fileName + " ' does not exist" );
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e){
            System.out.println("Something unrelated and unexpected happened");
        }
        finally{
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists");
    }
}