import java.util.*;

class InvalidDateException extends Exception {
    InvalidDateException(String s) { super(s); }
}

class MyDate {
    int d, m, y;
    MyDate(int d, int m, int y) throws InvalidDateException {
        if (d < 1 || d > 31 || m < 1 || m > 12) throw new InvalidDateException("Invalid date");
        this.d = d; this.m = m; this.y = y;
    }
    public String toString() { return d + "/" + m + "/" + y; }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            MyDate md = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(md);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}