package ru.levelup.vetclinic.menu.MenuAnimals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuAnimals {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuAnimals() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех питомцев");
        System.out.println("2. Добавить нового питомца");
        System.out.println("3. Обновить информацию о питомце");
        System.out.println("4. Найти питомца по ID клиента");
        System.out.println("5. Найти питомца по кличке");
        System.out.println("6. Удалить питомца");
        System.out.println("0. Вернуться в предыдущее меню");
    }

    public static String readString(String message) {
        try {
            System.out.println(message);
            return CONSOLE_READER.readLine();
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static int readInt(String message) {
        return Integer.parseInt(readString(message));
    }
}
