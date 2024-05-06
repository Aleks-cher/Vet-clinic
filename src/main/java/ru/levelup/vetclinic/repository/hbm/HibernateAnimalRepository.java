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
}
