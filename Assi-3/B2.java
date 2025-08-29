import java.util.Scanner;

class InvalidNameException extends Exception {
    public InvalidNameException(String message) { super(message); }
}

public class B2 {
    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches("[a-zA-Z ]+")) throw new InvalidNameException("Name is invalid");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Doctor Name: ");
            String doctorName = sc.nextLine();
            try {
                validateName(doctorName);
                System.out.println("Doctor Name: " + doctorName);
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }    }
}