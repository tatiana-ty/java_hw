package lesson_c;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("hw/1.txt")) {
            byte[] arr = new byte[70];
            int x;
            while ((x = in.read(arr)) > 0) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<InputStream> ali = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                ali.add(new FileInputStream("hw/" + i + ".txt"));
            }
            for (InputStream in : ali) {
                byte[] arr = new byte[120];
                int x;
                while ((x = in.read(arr)) > 0) {
                    System.out.print(new String(arr, 0, x, "UTF-8"));
                }
                System.out.print(" ");
            }
            System.out.println(ali);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Task3.read();
        //Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    }
}
