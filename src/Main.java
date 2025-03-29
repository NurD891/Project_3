import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Validates the date
    public boolean isValidDate() {
        if (year < 0) return false;
        if (month < 1 || month > 12) return false;
        int maxDay = getMaxDay(month, year);
        return day >= 1 && day <= maxDay;
    }

    private int getMaxDay(int m, int y) {
        switch (m) {
            case 2: return isLeapYear(y) ? 29 : 28;
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // Updates the date if valid
    public boolean updateDate(int day, int month, int year) {
        if (isValid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
            return true;
        }
        return false;
    }

    private boolean isValid(int d, int m, int y) {
        if (y < 0) return false;
        if (m < 1 || m > 12) return false;
        int maxDay = getMaxDay(m, y);
        return d >= 1 && d <= maxDay;
    }

    // Returns day of the week
    public String getDayOfWeek() {
        if (!isValidDate()) {
            throw new IllegalStateException("Date is invalid");
        }
        int q = day;
        int m = month;
        int y = year;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int K = y % 100;
        int J = y / 100;
        int h = (q + (13 * (m + 1) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    // Calculates difference in days
    public int calculateDifference(Date other) {
        return Math.abs(toJulianDay() - other.toJulianDay());
    }

    private int toJulianDay() {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        return day + (153 * m + 2) / 5 + y * 365 + y / 4 - y / 100 + y / 400 - 32045;
    }

    // Prints date in readable format
    public String printDate() {
        if (!isValidDate()) {
            return "Invalid Date";
        }
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1] + " " + day + ", " + year;
    }

    // For sorting
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create valid and invalid dates
        Date validDate = new Date(1, 1, 2025);
        Date invalidDate = new Date(31, 2, 2025); // Invalid date example
        System.out.println("Valid Date: " + validDate.printDate());
        System.out.println("Invalid Date: " + invalidDate.printDate());

        // Update date
        boolean updated = invalidDate.updateDate(28, 2, 2025); // Updated to 28.02.2025
        System.out.println("Update successful? " + updated);
        System.out.println("Updated Date: " + invalidDate.printDate());

        // Day of week
        try {
            System.out.println("Day of Week: " + validDate.getDayOfWeek());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Difference in days (non-leap year example)
        Date date1 = new Date(1, 1, 2025);
        Date date2 = new Date(1, 1, 2026); // Difference is 365 days
        System.out.println("Difference: " + date1.calculateDifference(date2) + " days");

        // Sorting dates
        List<Date> dates = new ArrayList<>();
        dates.add(new Date(15, 5, 2025)); // May 15, 2025
        dates.add(new Date(1, 1, 2025));  // January 1, 2025
        dates.add(new Date(10, 3, 2024)); // March 10, 2024
        Collections.sort(dates);
        System.out.println("Sorted Dates:");
        for (Date d : dates) {
            System.out.println(d.printDate());
        }
    }
}