package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.repository.AnimalRepository;

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
}
