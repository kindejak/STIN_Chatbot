package com.kindejak.javalinapp.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class BasicRequest {
    @Getter @Setter private String bot_id;
    @Getter @Setter private String language;
    @Getter @Setter private String message;
}
