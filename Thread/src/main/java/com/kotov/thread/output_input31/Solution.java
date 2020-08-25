package src.main.java.com.kotov.thread.output_input31;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Считать с консоли 2 имени файла.
 * Вывести во второй файл все числа, которые есть в первом файле.
 * Числа выводить через пробел.
 * Закрыть потоки.
 *
 * Пример тела файла:
 * 12 text var2 14 8ю 1
 *
 * Результат:
 * 12 14 1
 */
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
            for (String temp : fileReader.readLine().split("\\s"))
            {
                Pattern p = Pattern.compile("^[0-9]+$");
                Matcher m = p.matcher(temp);
                if (m.find())
                {
                    fileWriter.write(temp);
                    fileWriter.write(' ');
                }
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
