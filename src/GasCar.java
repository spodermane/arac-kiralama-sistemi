public class GasCar extends Car{
    private double fuelConsumption;
    public GasCar(int id,String brand,String model, double pricePerDay, double fuelConsumption) {
        super(id,brand,model,pricePerDay);
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public double calculateConsumption(int km ){
        return(fuelConsumption/ 100 ) *km;
    }
    @Override
    public double calculateRentalFee(int days){
        return pricePerDay * days;
    }
}