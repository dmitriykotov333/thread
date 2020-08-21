package src.main.java.com.kotov.thread.output_input27;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
