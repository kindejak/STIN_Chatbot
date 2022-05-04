package com.kindejak.javalinapp;

import com.kindejak.javalinapp.request.BasicRequest;
import com.kindejak.javalinapp.utils.RequestHandeler;
import io.javalin.testtools.TestUtil;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class AppTest {

    @Test
    void test_ok_response() {
        TestUtil.test((app,client) -> {
            app.get("/", ctx -> ctx.result("ok"));
            final Response resp = client.get("/");
            Assertions.assertEquals(200,resp.code());
            Assertions.assertEquals("ok",resp.message().toLowerCase(Locale.ROOT));
        });
    }

    @Test
    void test_post_and_handler(){
        TestUtil.test((app,client) -> {
            app.post("/request", RequestHandeler.fetchResponse);
            BasicRequest basicRequest = new BasicRequest();
            final BasicRequest request = new BasicRequest();
            Map<String, String> body = new HashMap<>();
            body.put("bot_id","1");
            body.put("language", "en");
            body.put("message", "euro to czk on 01.01.2010");
            Response resp = client.post("/request",body);
            Assertions.assertEquals("{\"bot_id\":\"1\",\"language\":\"en\",\"message\":\"On 01.01.2010 the exchange rate was 26,465 CZK for 1 EUR\",\"image\":\"\"}",resp.body().string());
        });
    }
}
