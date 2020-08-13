package src.main.java.com.kotov.thread.output_input2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Ввести с консоли имя файла.
 * Найти байт или байты с максимальным количеством повторов.
 * Вывести их на экран через пробел.
 * Закрыть поток ввода-вывода.
 */
public class Solution {

    public static void main(String[] args) {
        Map<Byte, Integer> letters = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream in = new FileInputStream(reader.readLine())) {
            byte[] buffer = new byte[in.available()];
            if (in.available() > 0) {
                in.read(buffer);
            }
            for (byte c : buffer) {
                int count = 0;
                for (byte c1 : buffer) {
                    if (c == c1) {
                        count++;
                    }
                }
                letters.put(c, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int maxByte = 0;
        for (Map.Entry<Byte, Integer> pair : letters.entrySet()) {
            if (pair.getValue() > maxByte) {
                maxByte = pair.getValue();
            }
        }
        for (Map.Entry<Byte, Integer> pair : letters.entrySet()) {
            if (pair.getValue().equals(maxByte)) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}