package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.repository.AnimalRepository;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateAnimalRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;

import java.util.List;

public class RecordingVetListByAnimalPersonnelNumberMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;
    private final AnimalRepository animalRepository;

    public RecordingVetListByAnimalPersonnelNumberMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String animalPersonnelNumber = ConsoleMenuAnimals.readString("Введите персональный номер питомца");
        Animals animal = animalRepository.byPersonnelNumber(animalPersonnelNumber);
        List<RecordingVets> recordingVetsList = recordingVetsRepository.byAnimalPersonnelNumber(animal);
        recordingVetsList.forEach(recordingVets -> System.out.println(recordingVets));
    }
}
