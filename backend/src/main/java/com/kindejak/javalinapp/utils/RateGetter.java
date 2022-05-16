package com.kindejak.javalinapp.utils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RateGetter {
    public static String getRate(LocalDate localDate){
        String web = "https://www.cnb.cz/cs/financni_trhy/devizovy_trh/kurzy_devizoveho_trhu/denni_kurz.txt?date=";
        URL url = null;
        Scanner s = null;
        try {
            url = new URL(web + localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            s = new Scanner(url.openStream());
        } catch (IOException e) {
            return null;
        }
        while (s.hasNext()){
            String line = s.nextLine();
            if (line.contains("EUR")){
                String[] splitLine = line.split("\\|");
                return splitLine[splitLine.length-1];
            }
        }
        return null;
    }
}
