package ru.levelup.vetclinic.menu.action.ActionServices;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuServices.ConsoleMenuServices;
import ru.levelup.vetclinic.repository.ServiceRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateServiceRepository;

import java.math.BigDecimal;

public class ServiseCreateMenuAction implements Action {

    private final ServiceRepository serviceRepository;

    public ServiseCreateMenuAction() {
        this.serviceRepository = new HibernateServiceRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String personnelNumber = ConsoleMenuServices.readString("Введите персональный номер услуги");
        String serviceName = ConsoleMenuServices.readString("Введите наименование услуги");
        BigDecimal price = ConsoleMenuServices.readBigDecimal("Введите цену услуги");

        Services service = serviceRepository.create(personnelNumber, serviceName, price);
        System.out.println("Услуга: " + service + " добавлена");
    }
}
