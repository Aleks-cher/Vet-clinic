package ru.levelup.vetclinic.menu.MenuPayments;

import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.action.ActionPayments.PaymentByCustomerPersonnelNumberMenuAction;
import ru.levelup.vetclinic.menu.action.ActionPayments.PaymentListMenuAction;
import ru.levelup.vetclinic.menu.action.ExitAction;

import java.util.HashMap;
import java.util.Map;

public class MenuActionsPayments {

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new PaymentListMenuAction());
        ACTION_MAP.put(2, new PaymentByCustomerPersonnelNumberMenuAction());
    }



    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
