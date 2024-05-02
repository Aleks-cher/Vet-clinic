package ru.levelup.vetclinic.menu.MenuRecordingVets;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuVets.ConsoleMenuVets;
import ru.levelup.vetclinic.menu.MenuVets.MenuActionsVets;

public class StartMenuRecordingVet implements Action {
    @Override
    public void execute() {

        int actionCode = 0;
        do {
            ConsoleMenuRecordingVets.printGeneralMenuRecordingVets();
            actionCode = ConsoleMenuRecordingVets.readInt("Введите номер действия:");

            Action action = MenuActionsRecordingVets.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);
    }
}
