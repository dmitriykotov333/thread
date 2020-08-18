package src.main.java.com.kotov.thread.output_input20;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли имя файла.
 * Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
 * Программа запускается с одним параметром: id (int).
 * Закрыть потоки.
 * <p>
 * В файле данные разделены пробелом и хранятся в следующей последовательности:
 * id productName price quantity
 * где id - int.
 * productName - название товара, может содержать пробелы, String.
 * price - цена, double.
 * quantity - количество, int.
 * <p>
 * Информация по каждому товару хранится в отдельной строке.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();

        BufferedReader filereader = new BufferedReader(new FileReader(filename));


        String str = filereader.readLine();
        int id = Integer.parseInt(args[0]);
        while (!str.equals("")) {
            if (Integer.parseInt(str.split(" ")[0]) == id) {
                System.out.println(str);
                break;
            }
            str = filereader.readLine();
        }
        filereader.close();
    }
}