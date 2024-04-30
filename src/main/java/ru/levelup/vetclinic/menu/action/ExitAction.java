package ru.levelup.vetclinic.menu.action;

import ru.levelup.vetclinic.menu.Action;

public class ExitAction implements Action {
    @Override
    public void execute() {
        System.out.println("Пока!");
    }
}
