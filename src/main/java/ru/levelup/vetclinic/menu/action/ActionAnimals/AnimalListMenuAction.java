package ru.levelup.vetclinic.menu.action.ActionAnimals;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;

import java.util.List;

public class AnimalListMenuAction implements Action {

    private final AnimalRepository animalRepository;

    public AnimalListMenuAction() {
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        List<Animals> animal = animalRepository.all();
        animal.forEach(animals -> System.out.println(animals));
    }
}
