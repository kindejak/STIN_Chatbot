package com.kindejak.javalinapp.utils;

import lombok.Getter;
import lombok.Setter;

public class BasicRequest {
    @Getter @Setter private String bot_id;
    @Getter @Setter private String language;
    @Getter @Setter private String message;
}