package com.laptrinhjavaweb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }
    public <T> T toModel (Class<T> zClass){
        try {
            return new ObjectMapper().readValue(value,zClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static HttpUtil of(BufferedReader reader){
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }
}
