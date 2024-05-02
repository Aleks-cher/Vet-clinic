package ru.levelup.vetclinic.menu;

import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuCustomers.StartMenuCustomer;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActions {
    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new StartMenuCustomer());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
