package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.AnimalType;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;

import java.sql.Timestamp;
import java.util.List;

public interface AnimalRepository {

    List<Animals> all();

    Animals create(
            String personnelNumber,
            String animalName,
            String animalType,
            Timestamp date,
            Customers customer
    );

    Animals byPersonnelNumber(String personnelNumber);

    Animals byAnimalName(String animalName);

    List<Animals> byCustomerId(Customers customerPersonnelNumber);

    void remove(String personnelNumber);
}
