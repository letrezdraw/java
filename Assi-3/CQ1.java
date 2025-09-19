//Program to read file content and display the conent in uppercase
import java.io.*;
import java.util.*;

public class CQ1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the file name: ");
            String fileName = sc.nextLine();
            
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                System.out.println("File content in uppercase:");
                while ((line = br.readLine()) != null) {
                    System.out.println(line.toUpperCase());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}