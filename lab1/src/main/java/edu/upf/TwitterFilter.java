package edu.upf;

import edu.upf.filter.FileLanguageFilter;
import edu.upf.uploader.S3Uploader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.File;

public class TwitterFilter {
    public static void main( String[] args ) throws IOException {

        long startTime = System.currentTimeMillis(); // Record the start time

        List<String> argsList = Arrays.asList(args);
        String language = argsList.get(0);
        String outputFile = argsList.get(1);
        String bucket = argsList.get(2);
        System.out.println("Language: " + language + ". Output file: " + outputFile + ". Destination bucket: " + bucket);

        //ADD TIMER

        try{
            File fileToDelete = new File(outputFile);

            // Check if the file exists
            if (fileToDelete.exists()) {
                // Delete the file
                fileToDelete.delete();
            }

            for(String inputFile: argsList.subList(3, argsList.size())) {
                System.out.println("Processing: " + inputFile);
                final FileLanguageFilter filter = new FileLanguageFilter(inputFile, outputFile);
                filter.filterLanguage(language);
            }
            final S3Uploader uploader = new S3Uploader(bucket, "lab1-test");
            uploader.upload(Arrays.asList(outputFile));

        }
        //STOP TIMER
        catch (Exception e) {
            // Handle the exception or log it
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis(); // Record the end time
        long duration = (endTime - startTime)/1000; // Calculate the elapsed time
        System.out.println("Execution time: " + duration + " seconds");


    }
}
