package edu.upf.uploader;

import java.util.List;

import java.io.File;
import java.util.List;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

//Add library
public class S3Uploader implements Uploader {

    //Variables
    String BucketName;
    String Prefix;
    AmazonS3 Client;


    //Constructor
    public S3Uploader(String bucket, String prefix){
        this.BucketName = bucket;
        this.Prefix = prefix;
        this.Client = AmazonS3ClientBuilder.standard()      // getting the default client
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }
    @Override
    public void upload(List<String> files) {

        for (String filePath : files) {
            File file = new File(filePath);
            String key = Prefix + "/" + file.getName();

            PutObjectRequest request = new PutObjectRequest(BucketName, key, file);
            Client.putObject(request);
            System.out.println("Uploaded file '" + filePath + "' to S3 bucket '" + BucketName + "' with key '" + key + "'");
        }
    }
}
