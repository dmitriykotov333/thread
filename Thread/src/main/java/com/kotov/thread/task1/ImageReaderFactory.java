package src.main.java.com.kotov.thread.task1;


import src.main.java.com.kotov.thread.task1.common.BmpReader;
import src.main.java.com.kotov.thread.task1.common.ImageTypes;
import src.main.java.com.kotov.thread.task1.common.JpgReader;
import src.main.java.com.kotov.thread.task1.common.PngReader;
import src.main.java.com.kotov.thread.task1.common.ImageReader;

public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader imageReader;

        if (imageTypes == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (imageTypes == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (imageTypes == ImageTypes.PNG) {
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
