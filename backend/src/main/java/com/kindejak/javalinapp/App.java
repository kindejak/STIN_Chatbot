package com.kindejak.javalinapp;

import com.kindejak.javalinapp.utils.BasicRequest;
import com.kindejak.javalinapp.utils.RequestHandeler;
import com. kindejak.javalinapp.utils.ResponseFactory;
import io.javalin.Javalin;

import java.io.IOException;

/**
 * Main class of the Chatbot App
 * mapping http requests
 */
public class App
{
    public static void main( String[] args )
    {

        Javalin app = Javalin
                .create(config -> config.enableCorsForAllOrigins())
                .start(7070);
        app.get("/", ctx -> ctx.result("ok"));
        app.error(404, ctx -> {
            ctx.result("There is no operation supported at the URI path and HTTP method you specified in the request.");
        });
        app.post("/request", RequestHandeler.fetchResponse);
    }
}
