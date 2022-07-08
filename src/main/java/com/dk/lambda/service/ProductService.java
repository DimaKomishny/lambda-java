package com.dk.lambda.service;

import com.dk.lambda.dao.entity.Product;

public interface ProductService {

    String save(String productJson);
    void delete(String id);
    String get(String id);
}
