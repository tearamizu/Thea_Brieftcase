package BackEnd;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date implements Serializable {
    private String day;
    private String month;
    private String year;

    public Date(String day, String month, String year) {
        if (validateDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    private boolean validateDate(String day, String month, String year) {
        int d = Integer.parseInt(day);
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);

        if (m < 1 || m > 12)
            return false;

        return d >= 1 && d <= daysInMonth(m, y);
    }

    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                return 0;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public java.util.Date toDate() {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(day + "-" + month + "-" + year);
        } catch (ParseException e) {
            return null;
        }
    }
}