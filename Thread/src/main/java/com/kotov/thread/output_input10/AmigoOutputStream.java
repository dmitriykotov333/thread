package src.main.java.com.kotov.thread.output_input10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1 Изменить класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream.
 * 2 При вызове метода close() должны выполняться следующая последовательность действий:
 * 2.1 Вызвать метод flush().
 * 2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
 * 2.3 Закрыть поток методом close().
 */
public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";


    FileOutputStream fileOutputStream;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        fileOutputStream.write("JavaRush © All rights reserved.".getBytes());
        fileOutputStream.close();
    }
}
