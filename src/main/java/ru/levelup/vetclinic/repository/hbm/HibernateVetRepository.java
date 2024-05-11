package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.repository.VetRepository;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
public class HibernateVetRepository implements VetRepository {

    private final SessionFactory factory;


    @Override
    public List<Vets> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Vets", Vets.class)
                    .list();
        }
    }

    @Override
    public Vets create(String personnelNumber, String lastName, String firstName, String middleName, String functionVet, Timestamp date) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Vets vet = new Vets(
                    null,
                    personnelNumber,
                    lastName,
                    firstName,
                    middleName,
                    functionVet,
                    date
            );
            session.persist(vet);
            tx.commit();
            return vet;
        }
    }

    @Override
    public void remove(String personnelNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("delete from vets where personnel_number= ?")
                    .setParameter(1, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }
}
