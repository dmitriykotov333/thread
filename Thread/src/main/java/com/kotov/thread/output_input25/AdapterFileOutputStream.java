package src.main.java.com.kotov.thread.output_input25;

import java.io.*;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;


    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {

        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }


    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
