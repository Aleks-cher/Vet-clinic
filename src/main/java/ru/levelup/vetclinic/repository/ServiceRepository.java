package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.domain.Vets;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceRepository {

    List<Services> all();

    Services create(
            String personnelNumber,
            String serviceName,
            BigDecimal price
    );

    void remove(String personnelNumber);

    Services byPersonnelNumber(String personnelNumber);

    void update(String personnelNumber, String serviceName, BigDecimal price);
}
