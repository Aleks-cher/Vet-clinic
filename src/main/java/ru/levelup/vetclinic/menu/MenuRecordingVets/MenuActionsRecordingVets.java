package ru.levelup.vetclinic.menu.MenuRecordingVets;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionRecordingVets.RecordingVetCreateMenuAction;
import ru.levelup.vetclinic.menu.action.ActionRecordingVets.RecordingVetListByVetPersonnelNumberMenuAction;
import ru.levelup.vetclinic.menu.action.ActionRecordingVets.RecordingVetListMenuAction;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsRecordingVets {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new RecordingVetListMenuAction());
        ACTION_MAP.put(2, new RecordingVetCreateMenuAction());
        ACTION_MAP.put(4, new RecordingVetListByVetPersonnelNumberMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
