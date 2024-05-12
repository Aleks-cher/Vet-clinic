package ru.levelup.vetclinic.menu.action.ActionVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.VetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

import java.util.List;

public class VetListMenuAction implements Action {

    private final VetRepository vetRepository;

    public VetListMenuAction() {
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        List<Vets> vetsList = vetRepository.all();
        vetsList.forEach(vets -> System.out.println(vets));
    }
}
