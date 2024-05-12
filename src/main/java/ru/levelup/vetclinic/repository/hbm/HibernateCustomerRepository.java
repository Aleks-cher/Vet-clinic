package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.repository.CustomerRepository;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
public class HibernateCustomerRepository implements CustomerRepository {

    private final SessionFactory factory;

    @Override
    public List<Customers> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Customers", Customers.class)
                    .list();
        }
    }

    @Override
    public Customers create(String personnelNumber, String lastName, String firstName, String middleName, String phoneNumber, Timestamp date) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Customers customer = new Customers(
                    null,
                    personnelNumber,
                    lastName,
                    firstName,
                    middleName,
                    phoneNumber,
                    date
            );
            session.persist(customer);
            tx.commit();
            return customer;
        }
    }

    @Override
    public Customers byId(Integer customerId) {
        try (Session session = factory.openSession()) {
            return session.get(Customers.class, customerId);
        }
    }

    @Override
    public Customers byLastName(String lastName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Customers where lastName= :paramlastName", Customers.class)
                    .setParameter("paramlastName", lastName)
                    .uniqueResult();
        }
    }

    @Override
    public void update(String personnelNumber, String lastName, String firstName, String middleName, String phoneNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("update customers set last_name= ?, first_name= ?, middle_name= ?, phone_number= ? " +
                            "where personnel_number= ?")
                    .setParameter(1, lastName)
                    .setParameter(2, firstName)
                    .setParameter(3, middleName)
                    .setParameter(4, phoneNumber)
                    .setParameter(5, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }

    @Override
    public Customers byPersonnelNumber(String personnelNumber) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Customers where personnelNumber= :paramPersonnelNumber", Customers.class)
                    .setParameter("paramPersonnelNumber", personnelNumber)
                    .uniqueResult();
        }
    }

    @Override
    public void remove(String personnelNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery("delete from customers where personnel_number= ?")
                    .setParameter(1, personnelNumber)
                    .executeUpdate();
            tx.commit();
        }
    }


}
