package src.main.java.com.kotov.thread.file7;


import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.
 *
 * Первым делом считай путь к папке с консоли.
 * Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
 * Затем посчитай и выведи следующую информацию:
 *
 * Всего папок - [количество папок в директории и поддиректориях]
 * Всего файлов - [количество файлов в директории и поддиректориях]
 * Общий размер - [общее количество байт, которое хранится в директории]
 *
 * Используй только классы и методы из пакета java.nio.
 *
 * Квадратные скобки [ ] выводить на экран не нужно.
 */
public class Solution extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Path path = Paths.get(bufferedReader.readLine());
            SimpleFile simpleFile = new SimpleFile();
            if (Files.isDirectory(path)) {
                Files.walkFileTree(path, simpleFile);

                System.out.println("Всего папок - " + (simpleFile.getTotalFolders()-1));
                System.out.println("Всего файлов - " + simpleFile.getTotalFiles());
                System.out.println("Общий размер - " + simpleFile.getTotalSize());
            } else {
                System.out.println(String.format("%s - не папка", path.toAbsolutePath().toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SimpleFile extends SimpleFileVisitor<Path> {
        private int totalFolders;
        private int totalFiles;
        private long totalSize;
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            totalFolders += 1;
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFiles += 1;
            totalSize = totalSize + attrs.size();
            return CONTINUE;
        }

        public int getTotalFolders() {
            return totalFolders;
        }

        public int getTotalFiles() {
            return totalFiles;
        }

        public long getTotalSize() {
            return totalSize;
        }
    }
}
