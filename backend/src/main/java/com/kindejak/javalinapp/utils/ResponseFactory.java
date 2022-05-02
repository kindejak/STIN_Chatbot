package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kindejak.javalinapp.language.LanguageKeyword;
import com.kindejak.javalinapp.response.Response;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ResponseFactory{
    private final String language;
    private final List<LanguageKeyword> keywords;


    public ResponseFactory(String json,String language) throws IOException {
        this.language = language;
        ObjectMapper objectMapper = new ObjectMapper();
        this.keywords = Arrays.asList(objectMapper.readValue(new File(json), LanguageKeyword[].class));
    }

    /**
     *
     * @param request
     * @return
     * @throws MissingResourceException
     */
    public Object getResponse(@NotNull BasicRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JsonProcessingException {

        if(!language.equals(request.getLanguage())){
            throw new Error("Language doesn't match");
        }
        String responseKeyName = findResponseKeyName(request.getMessage());
        String className = "com.kindejak.javalinapp.response." + responseKeyName + "Response";
        Class<?> responseClass = null;
        try
        {
            responseClass = Class.forName(className);
        }
        catch( ClassNotFoundException e )
        {
            responseClass = Class.forName("com.kindejak.javalinapp.response.BaseResponse");
        }
        Constructor<?> constructor =
                responseClass.getConstructor(String.class,String.class);
        Response response = (Response) constructor.newInstance(request.getBot_id(),request.getLanguage());
        response.setNewMessage(responseKeyName);
        return response;
        
    }

    private String findResponseKeyName(String message){
        for(String word : message.split(" ")){
            LanguageKeyword languageKeyword = keywords.stream().filter(
                    k -> k.getKeywords().contains(word.toLowerCase(Locale.ROOT)))
                    .findFirst().orElse(null);
            if (languageKeyword != null){
                return languageKeyword.getName();
            }
        }
        return "Unrecognised";
    }

}
