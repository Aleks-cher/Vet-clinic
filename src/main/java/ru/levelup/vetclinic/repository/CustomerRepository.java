package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Customers;

import java.util.List;

public interface CustomerRepository {

    List<Customers> all();
}
