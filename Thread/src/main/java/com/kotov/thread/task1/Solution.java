package src.main.java.com.kotov.thread.task1;


import src.main.java.com.kotov.thread.task1.common.ImageReader;

/**
 * Factory method pattern
 * 1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
 * 2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").
 */
public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(null);

    }
}
