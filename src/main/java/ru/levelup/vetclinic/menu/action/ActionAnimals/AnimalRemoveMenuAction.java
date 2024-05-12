package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;

public class AnimalRemoveMenuAction implements Action {

    private final AnimalRepository animalRepository;

    public AnimalRemoveMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        Integer password = ConsoleMenuAnimals.readInt("Введите пароль");
        if (password == 23472) {
            String animalPersonnelNumber = ConsoleMenuAnimals.readString("Введите персональный номер питомца");
            animalRepository.remove(animalPersonnelNumber);
            System.out.println("Питомец с персональным номером: " + animalPersonnelNumber + " удален!");
        } else {
            System.out.println("Пароль не верный");
        }
    }
}
