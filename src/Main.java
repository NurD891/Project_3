class Date {
    private int day, month, year;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public boolean isValidDate() {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month == 2 && day > 28) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        return true;
    }

    public void updateDate(int d, int m, int y) {
        Date temp = new Date(d, m, y);
        if (temp.isValidDate()) {
            day = d;
            month = m;
            year = y;
        } else {
            System.out.println("Invalid date: " + d + "/" + m + "/" + y);
        }
    }

    public void printDate() {
        if (isValidDate()) {
            System.out.println(month + "/" + day + "/" + year);
        } else {
            System.out.println("Invalid date");
        }
    }

    public int calculateDifference(Date other) {
        if (!isValidDate() || !other.isValidDate()) {
            System.out.println("One of the dates is invalid");
            return 0;
        }
        int myDays = year * 360 + month * 30 + day;
        int otherDays = other.year * 360 + other.month * 30 + other.day;
        return myDays - otherDays;
    }
}

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(1, 1, 2023);
        Date date2 = new Date(30, 2, 2023);

        System.out.println("Is date1 valid? " + date1.isValidDate());
        System.out.println("Is date2 valid? " + date2.isValidDate());

        date2.updateDate(28, 2, 2023);
        System.out.print("date2 after update: ");
        date2.printDate();

        System.out.print("date1: ");
        date1.printDate();
        System.out.print("date2: ");
        date2.printDate();

        Date date3 = new Date(15, 3, 2023);
        int diff = date3.calculateDifference(date1);
        System.out.println("Days between date3 and date1: " + diff);
    }
}