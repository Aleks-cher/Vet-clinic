package ru.levelup.vetclinic.menu;

import ru.levelup.vetclinic.menu.MenuAnimals.StartMenuAnimal;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuCustomers.StartMenuCustomer;
import ru.levelup.vetclinic.menu.MenuRecordingVets.StartMenuRecordingVet;
import ru.levelup.vetclinic.menu.MenuVets.StartMenuVet;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActions {
    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new StartMenuCustomer());
        ACTION_MAP.put(2, new StartMenuAnimal());
        ACTION_MAP.put(3, new StartMenuVet());
        ACTION_MAP.put(4, new StartMenuRecordingVet());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
