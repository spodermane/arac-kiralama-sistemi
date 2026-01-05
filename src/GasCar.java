public class GasCar extends Car{
    private double fuelConsumption;
    public GasCar(int id,String brand,String model, double pricePerDay) {
        super(id,brand,model,pricePerDay);
    }
    @Override
    public double calculateRentalFee(int days){
        return pricePerDay * days;
    }
}