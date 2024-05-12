package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuRecordingVets.ConsoleMenuRecordingVets;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.VetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

import java.util.List;

public class RecordingVetListByVetPersonnelNumberMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;
    private final VetRepository vetRepository;

    public RecordingVetListByVetPersonnelNumberMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String vetPersonnelNumber = ConsoleMenuRecordingVets.readString("Введите персональный номер ветеринара");
        Vets vet = vetRepository.byPersonnelNumber(vetPersonnelNumber);
        List<RecordingVets> recordingVetlist = recordingVetsRepository.byVetPersonnelNumber(vet);
        recordingVetlist.forEach(recordingVets -> System.out.println(recordingVets));


    }
}
