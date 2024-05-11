package ru.levelup.vetclinic.menu.MenuVets;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionVets.VetCreateMenuAction;
import ru.levelup.vetclinic.menu.action.ActionVets.VetListMenuAction;
import ru.levelup.vetclinic.menu.action.ActionVets.VetRemoveMenuAction;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsVets {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new VetListMenuAction());
        ACTION_MAP.put(2, new VetCreateMenuAction());
        ACTION_MAP.put(4, new VetRemoveMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
