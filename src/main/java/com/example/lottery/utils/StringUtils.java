package com.example.lottery.utils;

public class StringUtils {

    public static final String getLast(String text, int charLength){
        return text.substring(text.length()-(charLength), text.length());
    }

    public static final String getFront(String text, int charLength){
        return text.substring(0, charLength);
    }
}
