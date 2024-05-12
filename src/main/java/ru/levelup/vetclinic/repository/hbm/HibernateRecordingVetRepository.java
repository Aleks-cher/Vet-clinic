package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.*;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;

import java.sql.Timestamp;
import java.util.List;
@RequiredArgsConstructor
public class HibernateRecordingVetRepository implements RecordingVetsRepository {

    private final SessionFactory factory;
    @Override
    public List<RecordingVets> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from RecordingVets", RecordingVets.class)
                    .list();
        }
    }

    @Override
    public RecordingVets create(Customers customer, Animals animal, Vets vet, Services service, Timestamp date) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            RecordingVets recordingVet = new RecordingVets(
                    null,
                    customer,
                    animal,
                    vet,
                    service,
                    date
            );
            session.persist(recordingVet);
            tx.commit();
            return recordingVet;
        }
    }

    @Override
    public List<RecordingVets> byVetPersonnelNumber(Vets vetPersonnelNumber) {
        try (Session session = factory.openSession()) {
//            return session.createNativeQuery("select from recording_vets where vet_personnel_number= ?")
//                    .setParameter(1, vetPersonnelNumber)
//                    .list();
            return session.createQuery("from RecordingVets where vet= :paramVet", RecordingVets.class)
                    .setParameter("paramVet", vetPersonnelNumber)
                    .list();
        }
    }

    @Override
    public List<RecordingVets> byCustomerPersonnelNumber(Customers customerPersonnelNumber) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from RecordingVets where customer= :paramCustomer", RecordingVets.class)
                    .setParameter("paramCustomer", customerPersonnelNumber)
                    .list();
        }
    }

    @Override
    public List<RecordingVets> byAnimalPersonnelNumber(Animals animalPersonnelNumber) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from RecordingVets where animal= :paramAnimal", RecordingVets.class)
                    .setParameter("paramAnimal", animalPersonnelNumber)
                    .list();
        }
    }

    @Override
    public void remove(Integer recordingVetsId) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("delete from recording_vets where id= ?")
                    .setParameter(1, recordingVetsId)
                    .executeUpdate();
            tx.commit();
        }
    }
}
