package src.main.java.com.kotov.thread.output_input22;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Читайте с консоли имена файлов.
 * Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
 * Закрыть потоки.
 */
public class Solution {
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
            try (BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(fileNmae))) {

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
