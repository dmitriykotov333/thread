package src.main.java.com.kotov.thread.output_input3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Set<Integer> list = new TreeSet<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            while (fileInputStream.available() > 0) {
               list.add(fileInputStream.read());
            }
            for (Integer s : list) {
                System.out.print(s + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
