package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;

import java.util.List;

public class RecordingVetListMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;

    public RecordingVetListMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        List<RecordingVets> recordingVetsList = recordingVetsRepository.all();
        recordingVetsList.forEach(recordingVets -> System.out.println(recordingVets));
    }
}
