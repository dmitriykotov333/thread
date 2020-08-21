package src.main.java.com.kotov.thread.output_input25;

import java.io.IOException;

public interface AmigoStringWriter {
    void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}
