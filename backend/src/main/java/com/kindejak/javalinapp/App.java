package com.kindejak.javalinapp;

import com.kindejak.javalinapp.utils.ResponseFactory;
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
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> ctx.result("status: online"));
        //TODO map request and send responses in JSON
        try {
            ResponseFactory responseFactory = new ResponseFactory("src/main/java/com/kindejak/javalinapp/language/Map_en.json","en");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
