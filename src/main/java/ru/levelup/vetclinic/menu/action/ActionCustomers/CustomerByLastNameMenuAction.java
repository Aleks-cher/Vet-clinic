package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

public class CustomerByLastNameMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerByLastNameMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String customerLastName = ConsoleMenuCustomers.readString("Введите Фамилию клиента");
        Customers customer = customerRepository.byLastName(customerLastName);
        if (customer == null) {
            System.out.println("Клиент с Фамилией: " + customerLastName + " не найден!");
        } else {
            System.out.println(customer);
        }
    }
}
