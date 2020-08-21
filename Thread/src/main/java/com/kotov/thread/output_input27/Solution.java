package src.main.java.com.kotov.thread.output_input27;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Адаптировать Scanner к PersonScanner.
 * Классом-адаптером является PersonScannerAdapter.
 * В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.
 *
 * Данные в файле хранятся в следующем виде:
 * Иванов Иван Иванович 31 12 1950
 * Петров Петр Петрович 31 12 1957
 *
 * В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] line = fileScanner.nextLine().split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(line[5]),
                    Integer.parseInt(line[4]) - 1, Integer.parseInt(line[3]));

            return new Person(line[1], line[2], line[0], calendar.getTime());

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
