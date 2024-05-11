package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.AnimalType;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.repository.AnimalRepository;

import java.sql.Timestamp;
import java.util.List;
@RequiredArgsConstructor
public class HibernateAnimalRepository implements AnimalRepository {

    private final SessionFactory factory;
    @Override
    public List<Animals> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Animals", Animals.class)
                    .list();
        }
    }

    @Override
    public Animals create(String personnelNumber, String animalName, String animalType, Timestamp date, Customers customer) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Animals animal = new Animals(
                    null,
                    personnelNumber,
                    animalName,
                    AnimalType.valueOf(animalType),
                    date,
                    customer
            );
            session.persist(animal);
            tx.commit();
            return animal;
        }
    }

    @Override
    public Animals byPersonnelNumber(String personnelNumber) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Animals where personnelNumber= :paramPersonnelNumber", Animals.class)
                    .setParameter("paramPersonnelNumber", personnelNumber)
                    .uniqueResult();
        }
    }

    @Override
    public Animals byAnimalName(String animalName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Animals where animalName= :paramAnimalName", Animals.class)
                    .setParameter("paramAnimalName", animalName)
                    .uniqueResult();
        }
    }

    @Override
    public List<Animals> byCustomerId(Customers customerId) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Animals where customer= :ParamCustomer", Animals.class)
                    .setParameter("ParamCustomer", customerId)
                    .list();
        }
    }

    @Override
    public void remove(String personnelNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("delete from animals where personnel_number= ?")
                    .setParameter(1, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }
}
