package ru.levelup.vetclinic.menu.action.ActionVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuVets.ConsoleMenuVets;
import ru.levelup.vetclinic.repository.VetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

public class VetRemoveMenuAction implements Action {

    private final VetRepository vetRepository;

    public VetRemoveMenuAction() {
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        Integer password = ConsoleMenuAnimals.readInt("Введите пароль");
        if (password == 23472) {
        String vetPersonnelNumber = ConsoleMenuVets.readString("Введите персональный номер ветеринара");
        vetRepository.remove(vetPersonnelNumber);
        System.out.println("Ветеринар с персональным номером: " + vetPersonnelNumber + " удален!");
        } else {
            System.out.println("Пароль не верный");
        }
    }
}
