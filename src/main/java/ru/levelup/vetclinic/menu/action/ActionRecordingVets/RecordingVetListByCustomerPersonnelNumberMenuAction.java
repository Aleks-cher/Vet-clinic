package ru.levelup.vetclinic.menu.action.ActionRecordingVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.RecordingVets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.RecordingVetsRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateRecordingVetRepository;

import java.util.List;

public class RecordingVetListByCustomerPersonnelNumberMenuAction implements Action {

    private final RecordingVetsRepository recordingVetsRepository;
    private final CustomerRepository customerRepository;

    public RecordingVetListByCustomerPersonnelNumberMenuAction() {
        this.recordingVetsRepository = new HibernateRecordingVetRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        Customers customer = customerRepository.byPersonnelNumber(customerPersonnelNumber);
        List<RecordingVets> recordingVetsList = recordingVetsRepository.byCustomerPersonnelNumber(customer);
        recordingVetsList.forEach(recordingVets -> System.out.println(recordingVets));
    }
}
