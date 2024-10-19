package edu.upf.uploader;

import java.util.List;

public class S3Uploader implements Uploader {

    //Variables
    String BucketName;
    String Prefix;
    AmazonS3 Client;


    //Constructor
    public S3Uploader(String bucket, String prefix){
        this.BucketName = bucket;
        this.Prefix = prefix;
        this.Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }
    @Override
    public void upload(List<String> files) {

    }
}
