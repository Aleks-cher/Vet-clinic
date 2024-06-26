package ru.levelup.vetclinic.menu.action.ActionCustomers;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;

public class CustomerRemoveMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerRemoveMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String password = ConsoleMenuAnimals.readString("Вы действительно хотите удалить клиента? напишите 'Да'");
        if (password.equals("Да")) {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        customerRepository.remove(customerPersonnelNumber);
        System.out.println("Клиент с персональным номером: " + customerPersonnelNumber + " удален!");
        } else {
            System.out.println("Действие откланено!");
        }
    }
}
