package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.AnimalType;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.repository.ServiceRepository;

import java.math.BigDecimal;
import java.util.List;
@RequiredArgsConstructor
public class HibernateServiceRepository implements ServiceRepository {

    private final SessionFactory factory;
    @Override
    public List<Services> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Services", Services.class)
                    .list();
        }
    }

    @Override
    public Services create(String personnelNumber, String serviceName, BigDecimal price) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Services service = new Services(
                    null,
                    personnelNumber,
                    serviceName,
                    price
            );
            session.persist(service);
            tx.commit();
            return service;
        }
    }
}
