import java.io.*;
import java.util.*;

class MenuFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        Random r = new Random();
        while (true) {
            System.out.println("1.Load 2.Save 3.Exit"); int ch = sc.nextInt();
            if (ch == 1) {
                for (int i = 0; i < 10; i++) nums[i] = r.nextInt(90) + 10;
                System.out.println(Arrays.toString(nums));
            } else if (ch == 2) {
                DataOutputStream d = new DataOutputStream(new FileOutputStream("number.txt"));
                for (int i : nums) d.writeInt(i);
                d.close();
            } else break;
        }
    }
}