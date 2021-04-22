package com.example.HandyMan.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {
    public Date formatDate(String date) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        parser.setTimeZone(TimeZone.getTimeZone("UTC"));
        return parser.parse(date);
    }
}
