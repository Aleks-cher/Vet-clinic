package ru.levelup.vetclinic.repository;

import ru.levelup.vetclinic.domain.Customers;

import java.sql.Timestamp;
import java.util.List;

public interface CustomerRepository {

    List<Customers> all();

    Customers create(
            String personnelNumber,
            String lastName,
            String firstName,
            String middleName,
            String phoneNumber,
            Timestamp date
    );

    Customers byId(Integer customerId);
}
