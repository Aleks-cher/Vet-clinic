package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AnimalCreateMenuAction implements Action {

    private final AnimalRepository animalRepository;

    private final CustomerRepository customerRepository;

    public AnimalCreateMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String personnelNumber = ConsoleMenuAnimals.readString("Введите персональный номер питомца");
        String animalName = ConsoleMenuAnimals.readString("Введите кличку питомца");
        String animalType = ConsoleMenuAnimals.readString("Введите тип питомца: CAT, DOG, PARROT, TURTLE, RAT, HAMSTER, SNAKE, RACCOON, FERRET, BIRD");
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        int customerId = ConsoleMenuAnimals.readInt("Введите ID клиента");
        Customers customer = customerRepository.byId(customerId);

        Animals animal = animalRepository.create(personnelNumber, animalName, animalType, date, customer);
        System.out.println("Питомец: " + animal + " добавлен!");
    }
}
