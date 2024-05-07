package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

public class CustomerByPersonnelNumberMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerByPersonnelNumberMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        Customers customer = customerRepository.byPersonnelNumber(customerPersonnelNumber);
        if (customer == null) {
            System.out.println("Клиент с персональным номером: " + customerPersonnelNumber + " не найден!");
        } else {
            System.out.println(customer);
        }
    }
}
