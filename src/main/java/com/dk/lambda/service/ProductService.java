package com.dk.lambda.service;

public interface ProductService {

    String save(String productJson);
    void delete(String id);
    String get(String id);
    void update(String productJson);
}
