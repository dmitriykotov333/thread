package src.main.java.com.kotov.thread.task1;


import org.junit.Test;
import org.junit.Test;
import src.main.java.com.kotov.thread.task1.common.ImageReader;
import src.main.java.com.kotov.thread.task1.common.ImageTypes;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SolutionTest {
    @Test
    public void whenFormatBmp() {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.BMP);
        String result = reader.getFormat();
        assertThat(result, is("Bmp image"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFormatIsNull() {
        ImageReader reader = ImageReaderFactory.getImageReader(null);
        String result = reader.getFormat();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Неизвестный тип картинки");
        assertThat(result, is(illegalArgumentException));
    }



}