package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Services;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceRepository {

    List<Services> all();

    Services create(
            String personnelNumber,
            String serviceName,
            BigDecimal price
    );
}
