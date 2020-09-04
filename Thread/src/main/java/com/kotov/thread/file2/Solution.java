package src.main.java.com.kotov.thread.file2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
 * Используй очередь, рекурсию не используй.
 * Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
 * Путь должен быть абсолютный.
 */
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        File file = new File(root);


        Collections.addAll(queue, file.listFiles());

        while (!queue.isEmpty()) {
            File currentFile = queue.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(queue, currentFile.listFiles());
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
//        ArrayList<String> list = new ArrayList<>(getFileTree("D:\\IdeaProjects\\CarFix\\src\\main\\java"));
        for (String s : getFileTree("D:")) {
            System.out.println(s);
        }
    }
}
