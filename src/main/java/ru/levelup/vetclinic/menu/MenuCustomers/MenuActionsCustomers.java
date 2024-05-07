package ru.levelup.vetclinic.menu.MenuCustomers;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionCustomers.*;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsCustomers {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new CustomerListMenuAction());
        ACTION_MAP.put(2, new CustomerCreateMenuAction());
        ACTION_MAP.put(3, new CustomerUpdateMenuAction());
        ACTION_MAP.put(4, new CustomerByLastNameMenuAction());
        ACTION_MAP.put(5, new CustomerByPersonnelNumberMenuAction());
        ACTION_MAP.put(6, new CustomerRemoveMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
