package ru.levelup.vetclinic.menu.action.ActionVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuVets.ConsoleMenuVets;
import ru.levelup.vetclinic.repository.VetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VetCreateMenuAction implements Action {

    private final VetRepository vetRepository;

    public VetCreateMenuAction() {
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String personnelNumber = ConsoleMenuVets.readString("Введите персональный номер ветеринара");
        String lastName = ConsoleMenuVets.readString("Введите Фамилию ветеринара");
        String firstName = ConsoleMenuVets.readString("Введите Имя ветеринара");
        String middleName = ConsoleMenuVets.readString("Введите Отчество ветеринара");
        String functionVet = ConsoleMenuVets.readString("Введите должность ветеринара");
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());

        Vets vet = vetRepository.create(personnelNumber, lastName, firstName, middleName, functionVet, date);
        System.out.println("Ветеринар: " + vet + " добавлен!");
    }
}
