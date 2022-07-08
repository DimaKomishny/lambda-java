package com.dk.lambda.handler;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.dk.lambda.controller.Controller;
import com.dk.lambda.controller.DeleteController;
import com.dk.lambda.controller.GetController;
import com.dk.lambda.controller.PostController;
import com.dk.lambda.controller.PutController;
import com.dk.lambda.exception.NotSupportedMethodException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private Map<HttpMethod, Controller> controllerMap;

    public Handler() {
        controllerMap = new HashMap<>();
        controllerMap.put(HttpMethod.GET, new GetController());
        controllerMap.put(HttpMethod.POST, new PostController());
        controllerMap.put(HttpMethod.PUT, new PutController());
        controllerMap.put(HttpMethod.DELETE, new DeleteController());
        controllerMap.put(HttpMethod.PATCH, (i, c) -> {throw new NotSupportedMethodException();});
        controllerMap.put(HttpMethod.HEAD, (i, c) -> {throw new NotSupportedMethodException();});
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        try {
            HttpMethod httpMethod = HttpMethod.valueOf(input.getHttpMethod().toUpperCase());
            String response = controllerMap.get(httpMethod).processRequest(input, context);
            APIGatewayProxyResponseEvent responseEvent = prepareResponse();
            responseEvent.setBody(response);
            return responseEvent;
        }   catch (Exception e) {
            return createErrorResponse(e);
        }
    }

    private APIGatewayProxyResponseEvent createErrorResponse(Exception e) {
        APIGatewayProxyResponseEvent responseEvent = prepareResponse();
        responseEvent.setStatusCode(404);
        responseEvent.setBody(String.format("\"error\" : \"%s\"", e.getMessage()));
        return responseEvent;
    }

    private APIGatewayProxyResponseEvent prepareResponse() {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Custom-Header", "Lambda Header");
        responseEvent.setHeaders(headers);
        return responseEvent;
    }
}



