package ru.levelup.vetclinic.menu.MenuAnimals;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuCustomers.MenuActionsCustomers;

public class StartMenuAnimal implements Action {
    @Override
    public void execute() {

        int actionCode = 0;
        do {
            ConsoleMenuAnimals.printGeneralMenuAnimals();
            actionCode = ConsoleMenuAnimals.readInt("Введите номер действия:");

            Action action = MenuActionsAnimals.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);

    }
}
