package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Vets;

import java.util.List;

public interface VetRepository {

    List<Vets> all();
}
