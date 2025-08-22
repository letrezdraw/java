import java.io.*;
import java.util.*;

class CustomerIO {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("customers.dat"));
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            dos.writeInt(sc.nextInt()); sc.nextLine();
            dos.writeUTF(sc.nextLine());
            dos.writeUTF(sc.nextLine());
            dos.writeUTF(sc.nextLine());
        }
        dos.close();
        DataInputStream dis = new DataInputStream(new FileInputStream("customers.dat"));
        while (dis.available() > 0) {
            System.out.println(dis.readInt() + " " + dis.readUTF() + " " + dis.readUTF() + " " + dis.readUTF());
        }
        dis.close();
    }
}