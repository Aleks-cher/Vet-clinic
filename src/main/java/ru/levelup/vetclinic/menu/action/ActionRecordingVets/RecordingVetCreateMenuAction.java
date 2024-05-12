package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.*;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuAnimals.ConsoleMenuAnimals;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuServices.ConsoleMenuServices;
import ru.levelup.vetclinic.menu.MenuVets.ConsoleMenuVets;
import ru.levelup.vetclinic.repository.*;
import ru.levelup.vetclinic.repository.hbm.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RecordingVetCreateMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;
    private final CustomerRepository customerRepository;
    private final AnimalRepository animalRepository;
    private final VetRepository vetRepository;
    private final ServiceRepository serviceRepository;

    public RecordingVetCreateMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
        this.animalRepository = new HibernateAnimalRepository(HibernateConfiguration.getFactory());
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
        this.serviceRepository = new HibernateServiceRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        Customers customer = customerRepository.byPersonnelNumber(customerPersonnelNumber);
        String animalPersonnelNumber = ConsoleMenuAnimals.readString("Введите персональный номер питомца");
        Animals animal = animalRepository.byPersonnelNumber(animalPersonnelNumber);
        String vetPersonnelNumber = ConsoleMenuVets.readString("Введите персональный номер ветеринара");
        Vets vet = vetRepository.byPersonnelNumber(vetPersonnelNumber);
        String servicePersonnelNumber = ConsoleMenuServices.readString("Введите персональный номер услуги");
        Services service = serviceRepository.byPersonnelNumber(servicePersonnelNumber);
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());

        RecordingVets recordingVet = recordingVetsRepository.create(customer, animal, vet, service, date);
        System.out.println("Запись на прием к ветеринару: " + recordingVet + " добавлена!");
    }
}
