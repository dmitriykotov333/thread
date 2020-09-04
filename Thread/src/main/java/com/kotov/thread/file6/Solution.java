package src.main.java.com.kotov.thread.file6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
 * Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
 * Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
 * Используй только классы и методы из пакета java.nio.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        Path resultFile = Paths.get(downloadDirectory + "/" + urlString.substring(urlString.lastIndexOf("/") + 1));
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tempFile);
        Files.move(tempFile, resultFile);
        return resultFile;
    }
}
