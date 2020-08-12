package src.main.java.com.kotov.thread.task9;


/**
 * Singleton паттерн - синхронизация в статическом блоке.
 * Внутри класса OurPresident в статическом блоке создайть синхронизированный блок.
 * Внутри синхронизированного блока инициализировать president.
 */

public class Solution {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident);
    }
}
