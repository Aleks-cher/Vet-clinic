package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.repository.CustomerRepository;

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
}
