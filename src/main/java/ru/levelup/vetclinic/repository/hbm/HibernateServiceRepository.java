package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Services;
import ru.levelup.vetclinic.repository.ServiceRepository;

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
}
