package com.dk.lambda.dao.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dk.lambda.dao.entity.Product;

public class ProductRepository extends RepositoryDynamoDb<Product, String>{

    public ProductRepository() {
        super(Product.class);
    }

    @Override
    public void update(Product product) {
        dynamoDBMapper.save(product,
                new DynamoDBSaveExpression().withExpectedEntry(
                        "product_id",
                        new ExpectedAttributeValue(
                                new AttributeValue()
                                        .withS(product.getProductId()))));
    }
}
