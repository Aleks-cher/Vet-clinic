package ru.levelup.vetclinic.menu.MenuCustomers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuCustomers {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuCustomers() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех клиентов");
        System.out.println("2. Добавить нового клиента");
        System.out.println("3. Обновить информацию о клиенте");
        System.out.println("4. Найти клиента по Фамилии");
        System.out.println("5. Найти клиента по персональному номеру");
        System.out.println("6. Удалить клиента");
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
