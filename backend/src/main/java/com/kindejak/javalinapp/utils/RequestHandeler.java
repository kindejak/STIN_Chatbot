package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;


public class RequestHandeler {
    public static Handler fetchResponse = ctx -> {
        ObjectMapper objectMapper = new ObjectMapper();
        BasicRequest request = objectMapper.readValue(ctx.body(),BasicRequest.class);
        ResponseFactory responseFactory  = new ResponseFactory(request.getLanguage());
        Object response = responseFactory.getResponse(request);
        ctx.json(response);
    };
}
