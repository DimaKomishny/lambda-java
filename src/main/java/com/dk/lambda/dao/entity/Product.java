package com.dk.lambda.dao.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.math.BigDecimal;

@DynamoDBTable(tableName = "products")
public class Product {
    @DynamoDBHashKey(attributeName = "product_id")
    @DynamoDBAutoGeneratedKey
    private String productId;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String description;
    @DynamoDBAttribute
    private BigDecimal price;
    @DynamoDBAttribute
    private ProductProducer producer;

    public Product(String productId, String name, String description, BigDecimal price, ProductProducer producer) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.producer = producer;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductProducer getProducer() {
        return producer;
    }

    public void setProducer(ProductProducer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                '}';
    }
}