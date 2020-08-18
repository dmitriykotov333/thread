package src.main.java.com.kotov.thread.output_input13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Программа запускается с одним из следующих наборов параметров:
 * -e fileName fileOutputName
 * -d fileName fileOutputName
 *
 * где:
 * fileName - имя файла, который необходимо зашифровать/расшифровать.
 * fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
 * -e - ключ указывает, что необходимо зашифровать данные.
 * -d - ключ указывает, что необходимо расшифровать данные.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream iStream = new FileInputStream(args[1]);
        FileOutputStream oStream = new FileOutputStream(args[2]);
        byte[] array = new byte[iStream.available()];
        iStream.read(array);
        iStream.close();
        for (byte element: array) {
            if (args[0].equals("-e")) {
                oStream.write(element + 1);
            }
            if (args[0].equals("-d")) {
                oStream.write(element - 1);
            }
        }
        oStream.close();
    }

}
