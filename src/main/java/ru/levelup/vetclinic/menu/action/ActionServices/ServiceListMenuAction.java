package ru.levelup.vetclinic.menu.action.ActionServices;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.ServiceRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateServiceRepository;

import java.util.List;

public class ServiceListMenuAction implements Action {

    private final ServiceRepository serviceRepository;

    public ServiceListMenuAction() {
        this.serviceRepository = new HibernateServiceRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        List<Services> service = serviceRepository.all();
        service.forEach(services -> System.out.println(services));
    }
}
