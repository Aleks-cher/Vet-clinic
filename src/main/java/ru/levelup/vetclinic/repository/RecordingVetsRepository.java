package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.*;

import java.sql.Timestamp;
import java.util.List;

public interface RecordingVetsRepository {

    List<RecordingVets> all();

    RecordingVets create(
            Customers customer,
            Animals animal,
            Vets vet,
            Services service,
            Timestamp date
    );

    List<RecordingVets> byVetPersonnelNumber(Vets vetPersonnelNumber);

    List<RecordingVets> byCustomerPersonnelNumber(Customers customerPersonnelNumber);

    List<RecordingVets> byAnimalPersonnelNumber(Animals animalPersonnelNumber);

    void remove(Integer recordingVetsId);
}
