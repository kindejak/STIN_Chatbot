package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;


public class RequestHandeler {
    public static Handler fetchResponse = ctx -> {
        ResponseFactory responseFactory  = new ResponseFactory("en");
        ObjectMapper objectMapper = new ObjectMapper();
        BasicRequest request = objectMapper.readValue(ctx.body(),BasicRequest.class);
        Object response = responseFactory.getResponse(request);
        ctx.json(response);
    };
}
