package com.dk.lambda.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.dk.lambda.exception.NotSupportedOperationException;
import com.dk.lambda.service.ProductService;
import com.dk.lambda.service.impl.ProductServiceImpl;

import java.util.Map;

public class GetController implements Controller {

    private ProductService productService = new ProductServiceImpl();

    @Override
    public String processRequest(APIGatewayProxyRequestEvent input, Context context) {
        String id = getParamId(input.getPathParameters());
        return productService.get(id);
    }

    private String getParamId(Map<String, String> params) {
        if (params.containsKey("id")) {
            throw new NotSupportedOperationException();
        }
        return params.get("id");
    }
}
