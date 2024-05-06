package ru.levelup.vetclinic.menu.MenuServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleMenuServices {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuServices() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех услуг");
        System.out.println("2. Добавить новую услугу");
        System.out.println("3. Обновить услугу");
        System.out.println("4. Удалить услугу");
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

    public static BigDecimal readBigDecimal(String message) {return BigDecimal.valueOf(Long.parseLong(readString(message)));}
}
