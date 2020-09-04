package src.main.java.com.kotov.thread.caesar_cipher;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Шифр Цезаря
 * это просто сдвиг вправо по алфавиту на key букв.
 **/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Ifmmp-!xpsme\"");
        System.out.println(decode(reader, -1));  //Hello, world!
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (reader != null) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = bufferedReader.readLine();
            for (char c : string.toCharArray()) {
                sb.append((char) (c + key));
            }
            return sb.toString();
        }
        return "";
    }
}
