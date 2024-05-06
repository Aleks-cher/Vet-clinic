package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.repository.VetRepository;

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
}
