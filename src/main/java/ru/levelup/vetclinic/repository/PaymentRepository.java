package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Payments;

import java.util.List;

public interface PaymentRepository {

    List<Payments> all();
}
