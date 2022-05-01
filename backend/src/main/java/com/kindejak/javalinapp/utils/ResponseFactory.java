package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kindejak.javalinapp.language.LanguageKeyword;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ResponseFactory{
    private String language;
    private List<LanguageKeyword> keywords;


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
    public Object getResponse(@NotNull BasicRequest request) throws MissingResourceException {
        if(!language.equals(request.getLang())){
            throw new Error("Language doesn't match");
        }
        String responseKey = findResponseKeyName(request.getMessage());
    }

    private String findResponseKeyName(String message){
        for(String word : message.split(" ")){
            LanguageKeyword languageKeyword = keywords.stream().filter(k -> k.getKeywords().contains(word)).findFirst().orElse(null);
            if (languageKeyword != null){
                return languageKeyword.getName();
            }
        }
        return "unrecognised_response";
    }

}
