package com.dk.lambda.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.dk.lambda.service.ProductService;
import com.dk.lambda.service.impl.ProductServiceImpl;

public class GetController implements Controller {

    private ProductService productService = new ProductServiceImpl();

    @Override
    public String processRequest(APIGatewayProxyRequestEvent input, Context context) {
        return productService.get(input.getPathParameters().get("id"));
    }
}