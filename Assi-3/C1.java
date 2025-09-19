import java.io.*;
import java.util.*;

class C1 {
    private static final int ARRAY_SIZE = 10;
    private static final String FILE_NAME = "number.txt";
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] nums = new int[ARRAY_SIZE];
            Random r = new Random();
            
            while (true) {
                try {
                    System.out.println("\nMenu:");
                    System.out.println("1. Load random numbers");
                    System.out.println("2. Save to file");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    
                    int ch = sc.nextInt();
                    
                    switch (ch) {
                        case 1 -> loadRandomNumbers(nums, r);
                        case 2 -> saveToFile(nums);
                        case 3 -> {
                            System.out.println("Exiting program...");
                            return;
                        }
                        default -> System.out.println("Invalid choice! Please enter 1, 2, or 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number!");
                    sc.nextLine(); // if anyinput is notclear it will be removed from here
                }
            }
        }
    }
    
    private static void loadRandomNumbers(int[] nums, Random r) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(90) + 10;
        }
        System.out.println("Generated numbers: " + Arrays.toString(nums));
    }
    
    private static void saveToFile(int[] nums) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int num : nums) {
                writer.println(num);
            }
            System.out.println("Numbers saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}