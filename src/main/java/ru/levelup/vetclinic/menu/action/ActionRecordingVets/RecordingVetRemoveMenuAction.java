package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuRecordingVets.ConsoleMenuRecordingVets;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;

public class RecordingVetRemoveMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;

    public RecordingVetRemoveMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        Integer recordingVetId = ConsoleMenuRecordingVets.readInt("Введите ID записи на прием");
        recordingVetsRepository.remove(recordingVetId);
        System.out.println("Запись на прием с ID: " + recordingVetId + " удалена!");
    }
}
