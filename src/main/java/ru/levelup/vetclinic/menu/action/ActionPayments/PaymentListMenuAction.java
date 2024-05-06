package ru.levelup.vetclinic.menu.action.ActionPayments;

import ru.levelup.vetclinic.config.HibernateConfiguration;
import ru.levelup.vetclinic.domain.Payments;
import ru.levelup.vetclinic.menu.Action;
import ru.levelup.vetclinic.repository.PaymentRepository;
import ru.levelup.vetclinic.repository.hbm.HibernatePaymentRepository;

import java.util.List;

public class PaymentListMenuAction implements Action {

    private final PaymentRepository paymentRepository;

    public PaymentListMenuAction() {
        this.paymentRepository = new HibernatePaymentRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        List<Payments> payment = paymentRepository.all();
        payment.forEach(payments -> System.out.println(payments));
    }
}
