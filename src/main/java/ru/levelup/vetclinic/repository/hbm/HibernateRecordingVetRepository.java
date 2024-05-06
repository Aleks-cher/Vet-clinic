package ru.levelup.vetclinic.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.vetclinic.domain.Animals;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;

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
}
