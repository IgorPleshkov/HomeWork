package Courseworks.Fitness;

import java.time.LocalDate;

public class IsValidDate extends Exception {
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
