import java.util.*;

class InvalidDateException extends Exception {
    InvalidDateException(String s) { super(s); }
}

class MyDate {
    int d, m, y;
    
    MyDate(int d, int m, int y) throws InvalidDateException {
        if (m < 1 || m > 12) 
            throw new InvalidDateException("Invalid month: " + m);
            
        if (y < 1) 
            throw new InvalidDateException("Invalid year: " + y);
            
        int maxDays = 31;
        
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxDays = 30;
        } else if (m == 2) {
            // Check for leap year
            boolean isLeapYear = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
            maxDays = isLeapYear ? 29 : 28;
        }
        
        if (d < 1 || d > maxDays)
            throw new InvalidDateException("Invalid day " + d + " for month " + m);
            
        this.d = d;
        this.m = m;
        this.y = y;
    }
    
    public String toString() {
        return String.format("%02d/%02d/%04d", d, m, y);
    }
}

class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter date (day month year):");
            MyDate md = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(md);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            sc.close();
        }
    }
}