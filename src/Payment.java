import java.time.LocalDateTime;


public class Payment {
    private int paymentId;
    private Rental rental;
    private double amount;
    private LocalDateTime paidAt;

    public Payment(int paymentId,Rental rental){
        this.paymentId = paymentId;
        this.rental = rental;
        this.amount = rental.getTotalFee();
        this.paidAt = LocalDateTime.now();
    }
    public double getAmount(){
        return amount;
    }
}
