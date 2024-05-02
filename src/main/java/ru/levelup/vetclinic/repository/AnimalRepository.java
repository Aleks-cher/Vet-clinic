package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Animals;

import java.util.List;

public interface AnimalRepository {

    List<Animals> all();
}
