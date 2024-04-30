package ru.levelup.vetclinic.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenu {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вызвать меню работы с клиентами");
        System.out.println("2. Вызвать меню работы с питомцами");
        System.out.println("3. Вызвать меню работы с ветеринарами");
        System.out.println("4. Вызвать меню для записи к ветеринару");
        System.out.println("5. Вызвать меню услуг");
        System.out.println("6. Вызвать меню работы с платежами");
        System.out.println("0. Выход");
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
