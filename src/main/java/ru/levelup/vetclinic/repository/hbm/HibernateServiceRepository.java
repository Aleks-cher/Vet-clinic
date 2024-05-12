package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.AnimalType;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.domain.Vets;
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

    @Override
    public void remove(String personnelNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("delete from services where personnel_number= ?")
                    .setParameter(1, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }

    @Override
    public Services byPersonnelNumber(String personnelNumber) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Services where personnelNumber= :paramPersonnelNumber", Services.class)
                    .setParameter("paramPersonnelNumber", personnelNumber)
                    .uniqueResult();
        }
    }

    @Override
    public void update(String personnelNumber, String serviceName, BigDecimal price) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("update services set service_name= ?, price= ? " +
                            "where personnel_number= ?")
                    .setParameter(1, serviceName)
                    .setParameter(2, price)
                    .setParameter(3, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }
}
