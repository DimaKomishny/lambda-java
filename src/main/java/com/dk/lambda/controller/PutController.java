package com.dk.lambda.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

public class PutController implements Controller {

    @Override
    public String processRequest(APIGatewayProxyRequestEvent input, Context context) {
        return null;
    }
}
