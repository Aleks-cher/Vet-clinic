package ru.levelup.vetclinic.menu.MenuAnimals;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionAnimals.AnimalByAnimalNameMenuAction;
import ru.levelup.vetclinic.menu.action.ActionAnimals.AnimalByCustomerIdMenuAction;
import ru.levelup.vetclinic.menu.action.ActionAnimals.AnimalCreateMenuAction;
import ru.levelup.vetclinic.menu.action.ActionAnimals.AnimalListMenuAction;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsAnimals {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new AnimalListMenuAction());
        ACTION_MAP.put(2, new AnimalCreateMenuAction());
        ACTION_MAP.put(4, new AnimalByCustomerIdMenuAction());
        ACTION_MAP.put(5, new AnimalByAnimalNameMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
