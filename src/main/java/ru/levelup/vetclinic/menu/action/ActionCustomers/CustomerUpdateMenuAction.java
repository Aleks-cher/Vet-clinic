package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

public class CustomerUpdateMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerUpdateMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        Customers customer = customerRepository.byPersonnelNumber(customerPersonnelNumber);

        String lastName = ConsoleMenuCustomers.readString("Введите Фамилию клиента");
        String firstName = ConsoleMenuCustomers.readString("Введите Имя клиента");
        String middleName = ConsoleMenuCustomers.readString("Введите Отчество клиента");
        String phoneNumber = ConsoleMenuCustomers.readString("Введите номер телефона клиента");

        customerRepository.update(customer.getPersonnelNumber(), lastName, firstName, middleName, phoneNumber);
        System.out.println("Информация клиента с персональным номером: " + customerPersonnelNumber + " обновлена!");
    }
}
