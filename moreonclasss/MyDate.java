package moreonclasss;

public class MyDate {
    private int year;
    private int month;
    private int day;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public void setYear(int year) { this.year = year; }
    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12) return false;
        int daysInMonth = (month == 2 && isLeapYear(year)) ? 29 : DAYS_IN_MONTHS[month - 1];
        return day >= 1 && day <= daysInMonth;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int m = (month < 3) ? month + 12 : month;
        int y = (month < 3) ? year - 1 : year;
        int K = y % 100;
        int J = y / 100;
        int h = (day + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
        return h;
    }

    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else if (month == 12) {
            year++;
            month = 1;
            day = 1;
        } else {
            month++;
            day = 1;
        }
        return this;
    }

    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else if (month == 1) {
            year--;
            month = 12;
            day = 31;
        } else {
            month--;
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) day = 29;
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }
        day = Math.min(day, DAYS_IN_MONTHS[month - 1]);
        if (month == 2 && isLeapYear(year)) day = Math.min(day, 29);
        return this;
    }

    public MyDate previousMonth() {
        if (month == 1) {
            year--;
            month = 12;
        } else {
            month--;
        }
        day = Math.min(day, DAYS_IN_MONTHS[month - 1]);
        if (month == 2 && isLeapYear(year)) day = Math.min(day, 29);
        return this;
    }

    public MyDate nextYear() {
        year++;
        if (month == 2 && day == 29 && !isLeapYear(year)) day = 28;
        return this;
    }

    public MyDate previousYear() {
        year--;
        if (month == 2 && day == 29 && !isLeapYear(year)) day = 28;
        return this;
    }

    public String toString() {
        int dayOfWeekIndex = getDayOfWeek(year, month, day);
        return DAYS[dayOfWeekIndex] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

}