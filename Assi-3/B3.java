import java.io.*;
import java.util.*;

class B3 {
    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("customers.dat"))
        ) {
            System.out.print("Enter number of customers: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for customer " + (i+1) + ":");
                System.out.print("ID: ");
                dos.writeInt(sc.nextInt());
                sc.nextLine(); // consume newline
                
                System.out.print("Name: ");
                dos.writeUTF(sc.nextLine());
                
                System.out.print("Email: ");
                dos.writeUTF(sc.nextLine());
                
                System.out.print("Phone: ");
                dos.writeUTF(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("customers.dat"))) {
            System.out.println("\nCustomer Details:");
            while (dis.available() > 0) {
                System.out.printf("ID: %d, Name: %s, Email: %s, Phone: %s%n",
                    dis.readInt(),
                    dis.readUTF(),
                    dis.readUTF(),
                    dis.readUTF()
                );
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}