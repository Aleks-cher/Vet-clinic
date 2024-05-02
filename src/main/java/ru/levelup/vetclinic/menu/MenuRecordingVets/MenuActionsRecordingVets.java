package ru.levelup.vetclinic.menu.MenuRecordingVets;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsRecordingVets {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
