package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

import java.util.List;

public class CustomerListMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerListMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        List<Customers> customer = customerRepository.all();
        customer.forEach(customers -> System.out.println(customers));
    }
}
