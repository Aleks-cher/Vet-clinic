package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;

public class AnimalUpdateMenuAction implements Action {

    private final AnimalRepository animalRepository;

    public AnimalUpdateMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String animalPersonnelNumber = ConsoleMenuAnimals.readString("Введите персональный номер питомца");
        Animals animal = animalRepository.byPersonnelNumber(animalPersonnelNumber);

        String animalName = ConsoleMenuAnimals.readString("Введите кличку питомца");
        String animalType = ConsoleMenuAnimals.readString("Введите тип питомца: CAT, DOG, PARROT, TURTLE, RAT, HAMSTER, SNAKE, RACCOON, FERRET, BIRD");

        animalRepository.update(animal.getPersonnelNumber(), animalName, animalType);
        System.out.println("Информация питомца с персональным номером: " + animalPersonnelNumber + " обновлена!");
    }
}
