package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "testing.csv";
        testFile2(filename);

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
        } catch (FileNotFoundException e) {
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