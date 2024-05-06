package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomerCreateMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerCreateMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String personnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        String lastName = ConsoleMenuCustomers.readString("Введите Фамилию клиента");
        String firstName = ConsoleMenuCustomers.readString("Введите Имя клиента");
        String middleName = ConsoleMenuCustomers.readString("Введите Отчество клиента");
        String phoneNumber = ConsoleMenuCustomers.readString("Введите номер телефона клиента");
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());

        Customers customer = customerRepository.create(personnelNumber, lastName, firstName, middleName, phoneNumber, date);
        System.out.println("Клиент: " + customer + " добавлен!");
    }


}
