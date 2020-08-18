package src.main.java.com.kotov.thread.output_input21;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Читайте с консоли имена файлов, пока не будет введено слово "exit".
 * Передайте имя файла в нить ReadThread.
 * Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
 * где параметр String - это имя файла, параметр Integer - это искомый байт.
 * Закрыть потоки.
 */
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        String files;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(files = bufferedReader.readLine()).equals("exit")) {
                Thread th = new ReadThread(files);
                th.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> m : resultMap.entrySet()) {
            System.out.println(m.getKey() + " - " + m.getValue());
        }
    }

    public static class ReadThread extends Thread {
        private String fileNmae;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileNmae = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            HashMap<Byte, Integer> map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            byte res = Byte.MIN_VALUE;
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileNmae))) {
                byte[] bytes = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bytes);


                for (byte b : bytes) {
                    if (map.containsKey(b)) {
                        int count = map.get(b) + 1;
                        map.put(b, count);
                    } else {
                        map.put(b, 1);
                    }
                }

                for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        res = entry.getKey();
                    }
                }
                synchronized (this) {
                    resultMap.put(fileNmae, (int) res);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
