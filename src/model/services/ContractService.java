package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractService {


    private OnlinePaymentService onlinePaymentService;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void proccessContract(Contract contract, int months) {

        for (int i = 0; i < months; i++) {
            LocalDate nextPayment = contract.getDate().plusMonths((i + 1));
            double valuePerMonth = contract.getTotalValue() / months;

            double valuerT = valuePerMonth + onlinePaymentService.interest(valuePerMonth, (i+1)) + onlinePaymentService.paymentFee(valuePerMonth);
            contract.setInstallment(new Installment(nextPayment, valuerT));

            System.out.println(contract.getInstallment().getDueDate().format(dtf) + " - " + contract.getInstallment().getAmount());
        }

    }
}
