package ru.levelup.vetclinic;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.ConsoleMenu;
import ru.levelup.vetclinic.menu.MenuActions;

public class VetClinicApplication {

    public static void main(String[] args) {
        HibernateConfiguration.initializeSessionFactory();

        int actionCode = 0;
        do {
            ConsoleMenu.printGeneralMenu();
            actionCode = ConsoleMenu.readInt("Введите номер действия:");

            Action action = MenuActions.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);

        HibernateConfiguration.getFactory().close();
    }
}
