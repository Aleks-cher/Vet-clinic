package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Services;

import java.util.List;

public interface ServiceRepository {

    List<Services> all();
}
