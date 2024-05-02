package ru.levelup.vetclinic.menu.MenuPayments;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuServices.ConsoleMenuServices;
import ru.levelup.vetclinic.menu.MenuServices.MenuActionsServices;

public class StartMenuPayment implements Action {
    @Override
    public void execute() {

        int actionCode = 0;
        do {
            ConsoleMenuPayments.printGeneralMenuPayments();
            actionCode = ConsoleMenuPayments.readInt("Введите номер действия:");

            Action action = MenuActionsPayments.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);
    }
}
