package lesson_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Task3 {
    static int pos = 0;
    public static void read () {
        try(RandomAccessFile raf = new RandomAccessFile("hw/Hobbit_or_There_and_Back_Again-J_R_R_Tolkien.txt", "r")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("p - previous; n - next; q - quit");
                raf.seek(pos);
                byte[] barr = new byte[1800];
                raf.read(barr);
                System.out.println(new String(barr));
                String s = reader.readLine();
                if (s.equals("p")) {
                    if (pos > 0) pos = pos - 1800;
                } else if (s.equals("n")) pos = pos + 1800;
                else if (s.equals("q")) {
                    raf.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
