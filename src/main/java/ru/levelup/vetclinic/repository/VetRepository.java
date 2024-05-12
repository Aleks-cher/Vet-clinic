package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.Vets;

import java.sql.Timestamp;
import java.util.List;

public interface VetRepository {

    List<Vets> all();

    Vets create(
            String personnelNumber,
            String lastName,
            String firstName,
            String middleName,
            String functionVet,
            Timestamp date
    );

    void remove(String personnelNumber);

    void update(String personnelNumber, String lastName, String firstName, String middleName, String functionVet);

    Vets byPersonnelNumber(String personnelNumber);
}
