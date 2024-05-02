package ru.levelup.vetclinic.menu.MenuServices;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuRecordingVets.ConsoleMenuRecordingVets;
import ru.levelup.vetclinic.menu.MenuRecordingVets.MenuActionsRecordingVets;

public class StartMenuService implements Action {
    @Override
    public void execute() {

        int actionCode = 0;
        do {
            ConsoleMenuServices.printGeneralMenuServices();
            actionCode = ConsoleMenuServices.readInt("Введите номер действия:");

            Action action = MenuActionsServices.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);
    }
}
