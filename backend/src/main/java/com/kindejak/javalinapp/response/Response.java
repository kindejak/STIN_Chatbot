package com.kindejak.javalinapp.response;

import lombok.ToString;

@ToString
public abstract class Response {
    public abstract void setNewMessage(String responseKey,String message);
}
