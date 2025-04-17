package exonclass;

public class date {
    private int day;
    private int month;
    private int year;
    public date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public  static class TestMain {
        public static void main(String[] args) {
            // Test constructor and toString()
            date d1 = new date(1, 2, 2014);
            System.out.println(d1);  // toString()

            // Test Setters and Getters
            d1.setMonth(12);
            d1.setDay(9);
            d1.setYear(2099);
            System.out.println(d1);  // toString()
            System.out.println("Month: " + d1.getMonth());
            System.out.println("Day: " + d1.getDay());
            System.out.println("Year: " + d1.getYear());

            // Test setDate()
            d1.setDate(3, 4, 2016);
            System.out.println(d1);  // toString()
        }
    }
}
