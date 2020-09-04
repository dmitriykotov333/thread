package src.main.java.com.kotov.thread.properties;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
 * fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
 * Нужно обеспечить корректное чтение свойств.
 * При возникновении ошибок должен возвращаться пустой объект.
 * Метод main не участвует в тестировании.
 * <p>
 * Подсказка: возможно тебе понадобится File.separator.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            if (fileName.contains(".xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileReader(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
