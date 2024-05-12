package ru.levelup.vetclinic.menu.action.ActionServices;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuServices.ConsoleMenuServices;
import ru.levelup.vetclinic.repository.ServiceRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateServiceRepository;

public class ServiceRemoveMenuAction implements Action {

    private final ServiceRepository serviceRepository;

    public ServiceRemoveMenuAction() {
        this.serviceRepository = new HibernateServiceRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String servicePersonnelNumber = ConsoleMenuServices.readString("Введите персональный номер услуги");
        serviceRepository.remove(servicePersonnelNumber);
        System.out.println("Услуга с персональным номером: " + servicePersonnelNumber + " удалена!");
    }
}
