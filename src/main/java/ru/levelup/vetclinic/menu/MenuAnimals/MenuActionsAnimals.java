package ru.levelup.vetclinic.menu.MenuAnimals;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionAnimals.*;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsAnimals {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new AnimalListMenuAction());
        ACTION_MAP.put(2, new AnimalCreateMenuAction());
        ACTION_MAP.put(3, new AnimalUpdateMenuAction());
        ACTION_MAP.put(4, new AnimalByCustomerIdMenuAction());
        ACTION_MAP.put(5, new AnimalByAnimalNameMenuAction());
        ACTION_MAP.put(6, new AnimalRemoveMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
