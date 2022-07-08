package com.dk.lambda.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

@FunctionalInterface
public interface Controller {

    String processRequest(APIGatewayProxyRequestEvent input, Context context);
}
