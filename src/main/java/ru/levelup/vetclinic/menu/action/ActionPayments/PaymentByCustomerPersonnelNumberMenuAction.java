package ru.levelup.vetclinic.menu.action.ActionPayments;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Customers;
import ru.levelup.vetclinic.domain.Payments;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.menu.MenuCustomers.ConsoleMenuCustomers;
import ru.levelup.vetclinic.repository.CustomerRepository;
import ru.levelup.vetclinic.repository.PaymentRepository;
import ru.levelup.vetclinic.repository.hbm.HibernateCustomerRepository;
import ru.levelup.vetclinic.repository.hbm.HibernatePaymentRepository;

import java.util.List;

public class PaymentByCustomerPersonnelNumberMenuAction implements Action {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentByCustomerPersonnelNumberMenuAction() {
        this.paymentRepository = new HibernatePaymentRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void execute() {
        String customerPersonnelNumber = ConsoleMenuCustomers.readString("Введите персональный номер клиента");
        Customers customer = customerRepository.byPersonnelNumber(customerPersonnelNumber);
        List<Payments> paymentsList = paymentRepository.byCustomerPersonnelNumber(customer);
        paymentsList.forEach(payments -> System.out.println(payments));
    }
}
