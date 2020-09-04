package src.main.java.com.kotov.thread.file1;

import java.io.*;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 1. На вход метода main() подаются два параметра.
 * Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
 * 2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
 * 3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
 * Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
 * 3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
 * 3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
 * Все файлы имеют расширение txt.
 * В качестве разделителя пути используй "/".
 * Для создания файлов используй конструктор File(String pathname).
 */
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFile = new File(args[1]);
        TreeSet<File> lower50 = new TreeSet<>();
        File allFilesContent = new File(resultFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFile, allFilesContent);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(allFilesContent))) {
            Stack stack = new Stack();
            stack.push(path);
            while (!stack.empty()) {
                File elt = (File) stack.pop();
                if (elt.isDirectory()) {
                    for (File file1 : elt.listFiles()) { //pushStack
                        stack.push(file1);
                    }
                }
                if (elt.isFile()) {
                    if (elt.length() > 50) {
                        FileUtils.deleteFile(elt);
                    } else {
                        lower50.add(elt);
                    }
                }
            }

            TreeMap<String, File> fileAndPath = new TreeMap<>();
            for (File f : lower50) {
                fileAndPath.put(f.getName(), f);
            }
            for (Map.Entry<String, File> pair : fileAndPath.entrySet()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pair.getValue()));
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    out.write((s + "\n").getBytes());
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
        }
    }
}
