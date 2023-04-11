package org.example.utils;

public class DateUtils {

    public static Boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
