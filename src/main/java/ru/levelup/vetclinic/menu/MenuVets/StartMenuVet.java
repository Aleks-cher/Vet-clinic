package ru.levelup.vetclinic.menu.MenuVets;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuAnimals.MenuActionsAnimals;

public class StartMenuVet implements Action {
    @Override
    public void execute() {

        int actionCode = 0;
        do {
            ConsoleMenuVets.printGeneralMenuVets();
            actionCode = ConsoleMenuVets.readInt("Введите номер действия:");

            Action action = MenuActionsVets.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);
    }
}
