package src.main.java.com.kotov.thread.output_input19;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Программа запускается с одним параметром - именем файла, который содержит английский текст.
 * Посчитать частоту встречания каждого символа.
 * Отсортировать результат по возрастанию кода ASCII.
 *
 * Пример:
 * ','=44, 's'=115, 't'=116.
 *
 * Вывести на консоль отсортированный результат:
 * [символ1] частота1
 * [символ2] частота2
 * Закрыть потоки.
 *
 * Пример вывода:
 * , 19
 * - 7
 * f 361
 */
public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(args[0]))) {
            byte[] data = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(data);
            char[] c = new String(data).toCharArray();
            for (char b : c) {
                if (map.containsKey(b)) {
                    int val = map.get(b) + 1;
                    map.put(b, val);
                } else {
                    map.put(b, 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}