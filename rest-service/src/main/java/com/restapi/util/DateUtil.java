package com.restapi.util;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Created by pallav on 30/9/16.
 */
public class DateUtil {


   /* public static void main(String s[]) throws ParseException {

        System.out.println("Complete timestamp:Year::"+getYear("2011-09-03T10:15:30Z")+", Quarter::"+getQuarter("2011-09-03T10:15:30Z"));
        System.out.println("Only Date:Year::"+getYear("2011-09-03")+", Quarter::"+getQuarter("2011-09-03"));


    }*/


    public static LocalDateTime parseInstant(String dateValue)
    {
        Objects.requireNonNull(dateValue, "passed date value is null");
        LocalDateTime ltd;
        try {
            Instant format = Instant.parse(dateValue);
            ltd = LocalDateTime.ofInstant(format, ZoneId.systemDefault());
        }catch (DateTimeParseException e)
        {
            ltd = LocalDateTime.of(LocalDate.parse(dateValue), LocalTime.MIDNIGHT);
        }
        return ltd;
    }

    public static String getYear(String dateValue)
    {
        LocalDateTime localDateTime = parseInstant(dateValue);
        return String.valueOf(localDateTime.getYear());

    }

    public static String getQuarter(String dateValue)
    {
        LocalDateTime localDateTime = parseInstant(dateValue);
        return String.valueOf("q"+(int)Math.ceil(localDateTime.getMonthValue() /3));

    }
}

