package src.main.java.com.kotov.thread.output_input33;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли 2 имени файла.
 * Первый Файл содержит текст.
 * Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.
 *
 * Результат вывести во второй файл.
 *
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
            StringBuilder stringBuilder=new StringBuilder("");
            while(fileReader.ready()){
                stringBuilder.append(fileReader.readLine());
            }
            bufferedWriter.write(stringBuilder.toString().replaceAll("\\p{Punct}","").replace(System.lineSeparator(),""));
            fileReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
