package src.main.java.com.kotov.thread.output_input9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Используя шаблон проектирования Wrapper (Decorator) расширить функциональность AmigoOutputStream.
 * В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
 * 1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
 * 2. Считайте строку.
 * 3. Если считанная строка равна "Д", то закрыть поток.
 * 4. Если считанная строка не равна "Д", то не закрывать поток.
 */
public class QuestionFileOutputStream implements AmigoOutputStream {

    private BufferedReader bufferedReader;

    private AmigoOutputStream amigoOutputStream;
    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.amigoOutputStream = amigoOutputStream;

    }

    @Override
    public void flush() throws IOException {
        amigoOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (bufferedReader.readLine().equals("Д")) {
            amigoOutputStream.close();
        }
    }
}