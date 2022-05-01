package com.kindejak.javalinapp.utils;

import lombok.Getter;
import lombok.Setter;

public class BasicRequest {
    @Getter @Setter private int bot_id;
    @Getter @Setter private String lang;
    @Getter @Setter private String message;
}
