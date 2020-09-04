package src.main.java.com.kotov.thread.serializable2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Сделай так, чтобы сериализация класса Java была возможной.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static class Java implements Serializable{
        public List<User> users = new ArrayList<>();
    }
}
