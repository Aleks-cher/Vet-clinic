package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.Payments;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.repository.PaymentRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernatePaymentRepository implements PaymentRepository {

    private final SessionFactory factory;

    @Override
    public List<Payments> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Payments", Payments.class)
                    .list();
        }
    }

    @Override
    public List<Payments> byCustomerPersonnelNumber(Customers customer) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Payments where customerPersonnelNumber= :ParamCustomer", Payments.class)
                    .setParameter("ParamCustomer", customer.getPersonnelNumber())
                    .list();
        }
    }
}
