package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;

public class AnimalByAnimalNameMenuAction implements Action {

    private final AnimalRepository animalRepository;

    public AnimalByAnimalNameMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String animalName = ConsoleMenuAnimals.readString("Введите кличку питомца");
        Animals animal = animalRepository.byAnimalName(animalName);
        if (animal == null) {
            System.out.println("Питомец по кличке: " + animalName + " не найден!");
        } else {
            System.out.println(animal);
        }
    }
}
