package com.itmo.jjd.Fitness;

import java.time.LocalDate;

public class IsValidDate {
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) { return false;}
       // return false;
    }
}
