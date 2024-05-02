package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.RecordingVets;

import java.util.List;

public interface RecordingVetsRepository {

    List<RecordingVets> all();
}
