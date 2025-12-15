public class Rental {
    private  int rentalId;
    private Car car;
    private Customer customer;
    private int days;
    private boolean isReturned = false;

    public Rental(int rentalId,Car car, Customer customer, int days){
        this.rentalId = rentalId;
        this.car = car;
        this.customer = customer;
        this.days = days;

        car.setAvailable(false); // arac artik kirada
    }
    public double getTotalFee(){
        return car.calculateRentalFee(days);
    }
    public void returnCar(){
        car.setAvailable(true);
        isReturned = true;
    }
}
