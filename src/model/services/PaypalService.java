package model.services;

public class PaypalService implements OnlinePaymentService{

    double juros;
    public double interest(double amount, int months){
        juros = amount * (0.01 * months);
        return juros;
    }
    public double paymentFee(double amount) {
        return (amount + juros) * 0.02;
    }
}
