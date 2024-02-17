package edu.upf.filter;

import edu.upf.parser.SimplifiedTweet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
public class FileLanguageFilter implements LanguageFilter {

    //Variables
    final String inputFile;
    final String outputFile;
    public int counter;


    //Constructor
    public FileLanguageFilter(String inputFilePath, String outputFilePath) {
        this.inputFile = inputFilePath;
        this.outputFile = outputFilePath;
        this.counter = 0;

    }

    //Override Language Filter Class
    public void filterLanguage(String language) throws Exception {
        try {
            //Open the input and output files
            FileReader reader = new FileReader(inputFile);
            BufferedReader bReader = new BufferedReader(reader);

            FileWriter writer = new FileWriter(outputFile, true);
            BufferedWriter bWriter = new BufferedWriter(writer);



            //Get the first JsonString
            String line = bReader.readLine();


            while (line != null) {
                Optional<SimplifiedTweet> optionalTweet = SimplifiedTweet.fromJson(line);
                if (optionalTweet.isPresent()) {
                    SimplifiedTweet tweet = optionalTweet.get();
                    if (tweet.getLanguage().equals(language)) {
                        bWriter.write(line);
                        bWriter.newLine();
                        counter++;

                    }
                }
                line = bReader.readLine();
            }

            bReader.close();
            bWriter.close();
        } catch (Exception e) {
            // Handle or log the exception
            e.printStackTrace();
            throw e; // rethrow the exception if needed
        }
    }
}
