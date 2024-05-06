package ru.levelup.vetclinic.menu.MenuServices;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionServices.ServiceListMenuAction;
import ru.levelup.vetclinic.menu.action.ActionServices.ServiseCreateMenuAction;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsServices {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new ServiceListMenuAction());
        ACTION_MAP.put(2, new ServiseCreateMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
