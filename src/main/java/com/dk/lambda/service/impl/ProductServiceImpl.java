package com.dk.lambda.service.impl;

import com.dk.lambda.dao.entity.Product;
import com.dk.lambda.dao.repository.ProductRepository;
import com.dk.lambda.service.ProductService;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepository();
    private Gson gson = new Gson();

    @Override
    public String save(String productJson) {
        Product product = gson.fromJson(productJson, Product.class);
        productRepository.save(product);
        Map<String, String> response = new HashMap<>();
        response.put("response", product.getProductId());
        return gson.toJson(response);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public String get(String id) {
        Product product = productRepository.get(id);
        return gson.toJson(product);
    }

    @Override
    public void update(String productJson) {
        productRepository.update(gson.fromJson(productJson, Product.class));
    }
}
