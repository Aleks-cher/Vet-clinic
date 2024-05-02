package ru.levelup.vetclinic.menu.MenuPayments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuPayments {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuPayments() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех платежей");
        System.out.println("2. Найти платежи по ID клиента");
        System.out.println("3. Найти платежи по Фамилии");
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
