package ru.levelup.vetclinic.menu.MenuRecordingVets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuRecordingVets {

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenuRecordingVets() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Вывести список всех записей к ветеринару");
        System.out.println("2. Добавить запись на прием к ветеринару");
        System.out.println("3. Вывести все записи на прием по дате");
        System.out.println("4. Найти записи на прием по персональному номеру ветеринара");
        System.out.println("5. Найти записи на прием по персональному номеру клиента");
        System.out.println("6. Найти записи на прием по персональному номеру питомца");
        System.out.println("7. Удалить запись на прием");
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
