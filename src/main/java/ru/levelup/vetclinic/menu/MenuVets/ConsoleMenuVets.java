package ru.levelup.vetclinic.menu.MenuVets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuVets {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuVets() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех ветеринаров");
        System.out.println("2. Добавить нового ветеринара");
        System.out.println("3. Обновить информацию о ветеринаре");
        System.out.println("4. Удалить ветеринара");
        System.out.println("0. Вернуться в главное меню");
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
