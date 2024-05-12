package ru.levelup.vetclinic.menu.action.ActionServices;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuServices.ConsoleMenuServices;
import ru.levelup.vetclinic.repository.ServiceRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateServiceRepository;

import java.math.BigDecimal;

public class ServiceUpdateMenuAction implements Action {

    private final ServiceRepository serviceRepository;

    public ServiceUpdateMenuAction() {
        this.serviceRepository = new HibernateServiceRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String servicePersonnelNumber = ConsoleMenuServices.readString("Введите персональный номер услуги");
        Services service = serviceRepository.byPersonnelNumber(servicePersonnelNumber);

        String serviceName = ConsoleMenuServices.readString("Введите наименование услуги");
        BigDecimal price = ConsoleMenuServices.readBigDecimal("Введите цену услуги");

        serviceRepository.update(service.getPersonnelNumber(), serviceName, price);
        System.out.println("Информация услуги с персональным номером: " + servicePersonnelNumber + " обновлена!");
    }
}
