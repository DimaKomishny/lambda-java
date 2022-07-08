package com.dk.lambda.dao.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dk.lambda.dao.connnection.ConnectionDynamoDB;

public abstract class RepositoryDynamoDb<T, ID> {

    private Class<T> clazz;
    protected DynamoDBMapper dynamoDBMapper;

    public RepositoryDynamoDb(Class<T> clazz) {
        this.clazz = clazz;
        dynamoDBMapper = ConnectionDynamoDB.getInstance().getDynamoDBMapper();
    }

    public void save(T entity) {
        dynamoDBMapper.save(entity);
    }

    public T get(ID id) {
        return dynamoDBMapper.load(clazz, id);
    }

    public void delete(T entity) {
        dynamoDBMapper.delete(entity);
    }

    public void deleteById(ID id) {
        dynamoDBMapper.delete(dynamoDBMapper.load(clazz, id));
    }

    public abstract void update(T entity);
}
