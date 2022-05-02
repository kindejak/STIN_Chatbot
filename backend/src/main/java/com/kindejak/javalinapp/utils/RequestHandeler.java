package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.io.IOException;

public class RequestHandeler {
    public static Handler fetchResponse = ctx -> {
        ResponseFactory responseFactory  = new ResponseFactory("src/main/java/com/kindejak/javalinapp/language/Map_en.json","en");
        ObjectMapper objectMapper = new ObjectMapper();
        BasicRequest request = objectMapper.readValue(ctx.body(),BasicRequest.class);
        Object response = responseFactory.getResponse(request);
        ctx.json(response);
    };
}
