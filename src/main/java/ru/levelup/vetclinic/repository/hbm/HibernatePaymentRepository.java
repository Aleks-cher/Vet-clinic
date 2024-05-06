package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
