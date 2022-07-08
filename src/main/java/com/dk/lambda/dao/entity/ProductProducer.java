package com.dk.lambda.dao.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ProductProducer {
    private String name;
    private String country;

    public ProductProducer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public ProductProducer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
