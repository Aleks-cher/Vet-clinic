package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

import java.util.List;

public class AnimalByCustomerIdMenuAction implements Action {

    private final AnimalRepository animalRepository;
    private final CustomerRepository customerRepository;

    public AnimalByCustomerIdMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        int customerId = ConsoleMenuCustomers.readInt("Введите ID клиента");
        Customers customer = customerRepository.byId(customerId);
        List<Animals> animal = animalRepository.byCustomerId(customer);
        animal.forEach(animals -> System.out.println(animals));
    }
}
