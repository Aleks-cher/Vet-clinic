package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
}
