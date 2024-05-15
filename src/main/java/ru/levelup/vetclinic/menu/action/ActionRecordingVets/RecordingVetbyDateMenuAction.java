package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuRecordingVets.ConsoleMenuRecordingVets;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

import java.sql.Timestamp;
import java.util.List;

public class RecordingVetbyDateMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;

    public RecordingVetbyDateMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        Timestamp date = ConsoleMenuRecordingVets.readDate("Введите дату");
        List<RecordingVets> recordingVetsList = recordingVetsRepository.byDate(date);
        recordingVetsList.forEach(recordingVets -> System.out.println(recordingVets));
    }
}
