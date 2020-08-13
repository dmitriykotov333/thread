package src.main.java.com.kotov.thread.output_input9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        AmigoOutputStream amigoOutputStream = new Amigo();
        AmigoOutputStream amigoOutputStream1 = new QuestionFileOutputStream(amigoOutputStream);
        try {
            amigoOutputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
