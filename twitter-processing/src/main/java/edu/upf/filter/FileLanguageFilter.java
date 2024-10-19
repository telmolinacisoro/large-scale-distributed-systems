package edu.upf.filter;

public class FileLanguageFilter implements LanguageFilter {

    //Variables
    final String inputFile;
    final String outputFile;

    //Constructor
    public FileLanguageFilter(String inputFilePath, String outputFilePath) {
        this.inputFile = inputFilePath;
        this.outputFile = outputFilePath;
    }

    //Override Language Filter Class
    public void filterLanguage(String language) throws Exception {
        try {

            //Open the input and output files
            FileReader reader = new FileReader(inputFile);
            BufferedReader bReader = new BufferedReader(reader);

            FileWriter writer = new FileWriter(outputFile);
            BufferedWriter bWriter = new BufferedWriter(writer);


            //Get the first JsonString
            String line = bReader.readLine();


            while ( line != null) {
                Optional<SimplifiedTweet> optionalTweet = SimplifiedTweet.fromJson(line);
                if (optionalTweet.isPresent()) {
                    SimplifiedTweet tweet = optionalTweet.get();
                    if (tweet.getLanguage().equals(language)) {
                        bWriter.write(line);
                        bWwriter.newLine();
                    }
                }
                line = bReader.readLine();
            }

            bReader.close();
            bWriter.close();


    }

}
