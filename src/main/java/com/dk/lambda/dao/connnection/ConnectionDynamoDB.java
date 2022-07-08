package com.dk.lambda.dao.connnection;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class ConnectionDynamoDB {

    private static ConnectionDynamoDB instance;
    DynamoDBMapper dynamoDBMapper;

    private ConnectionDynamoDB() {
        dynamoDBMapper = createDynamoDBMapper();
    }

    public static ConnectionDynamoDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDynamoDB();
        }
        return instance;
    }

    public DynamoDBMapper getDynamoDBMapper() {
        return dynamoDBMapper;
    }
    private DynamoDBMapper createDynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }

    private AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(createEndpoint())
                .withCredentials(createCredentialProvider())
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration createEndpoint() {
        return new AwsClientBuilder
                .EndpointConfiguration(
                "",
                "");
    }

    private AWSStaticCredentialsProvider createCredentialProvider() {
        return new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("",
                        "")
        );
    }


}
