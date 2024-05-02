package ru.levelup.vetclinic.menu.MenuCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.ConsoleMenu;
import ru.levelup.vetclinic.menu.MenuActions;

public class StartMenuCustomer implements Action {
    @Override
    public void execute() {
//        HibernateConfiguration.initializeSessionFactory();

        int actionCode = 0;
        do {
            ConsoleMenuCustomers.printGeneralMenuCustomers();
            actionCode = ConsoleMenuCustomers.readInt("Введите номер действия:");

            Action action = MenuActionsCustomers.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);

//        HibernateConfiguration.getFactory().close();
    }
}
