import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SwiftDate {
    int year;
    int month;
    int day;
    String dateString;

    public SwiftDate(int year, int month, int day, String dateString) {
        this.year = year;
        this.month = month;
        this.day = day;

        this.dateString = dateString;
    }

    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String getDateString() {
        return dateString;
    }

    int getCentury() {
        return (int) Math.ceil((double) year / 100);
    }

    int getDaysDifference(SwiftDate other) {
        float daysBetween = 0f;
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date dateBefore = myFormat.parse(this.getDateString());
            Date dateAfter = myFormat.parse(other.getDateString());
            long difference = dateBefore.getTime() - dateAfter.getTime();
            daysBetween = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) daysBetween;
    }

    /*if (this.year > other.year) {
        for (int i = other.year; i < this.year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
    } else if (this.year < other.year) {
        for (int i = this.year; i < other.year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
    } else {
        if (this.month > other.month) {
            for (int i = other.month; i < this.month; i++) {
                days += getDaysInMonth(i);
            }
        } else if (this.month < other.month) {
            for (int i = this.month; i < other.month; i++) {
                days += getDaysInMonth(i);
            }
        }
    }
    days += getDaysInMonth(this.month) - this.day;
    days += this.day;
    days += getDaysInMonth(other.month) - other.day;
    days += other.day;
    return days;
}
*/
    int getDaysInMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(this.year) ? 29 : 28;
            default -> 0;
        };
    }

    void printInfo() {
        System.out.print(year + " " + month + " " + day + " - " + getCentury() + " century.");
        if (isLeapYear(this.year)) System.out.println(" It is LEAP year.");
    }
}