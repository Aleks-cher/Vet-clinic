package ru.levelup.vetclinic.menu.action.ActionVets;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.Vets;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.menu.MenuVets.ConsoleMenuVets;
import ru.levelup.vetclinic.repository.VetRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateVetRepository;

public class VetUpdateMenuAction implements Action {

    private final VetRepository vetRepository;

    public VetUpdateMenuAction() {
        this.vetRepository = new HibernateVetRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String vetPersonnelNumber = ConsoleMenuVets.readString("Введите персональный номер ветеринара");
        Vets vet = vetRepository.byPersonnelNumber(vetPersonnelNumber);

        String lastName = ConsoleMenuVets.readString("Введите Фамилию ветеринара");
        String firstName = ConsoleMenuVets.readString("Введите Имя ветеринара");
        String middleName = ConsoleMenuVets.readString("Введите Отчество ветеринара");
        String functionVet = ConsoleMenuVets.readString("Введите должность ветеринара");

        vetRepository.update(vet.getPersonnelNumber(), lastName, firstName, middleName, functionVet);
        System.out.println("Информация ветеринара с персональным номером: " + vetPersonnelNumber + " обновлена!");
    }
}
