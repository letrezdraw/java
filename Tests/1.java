public class MyProgram {
    public static void main(String[] args) {
        // 1. Check if input is provided
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return; // Exit the program
        }

        // 2. Parse the input string to an integer/double
        int myNumber = Integer.parseInt(args[0]);

        // 3. Add your logic here (e.g., check for prime, reverse, find factors)
        System.out.println("You entered: " + myNumber);
    }
}