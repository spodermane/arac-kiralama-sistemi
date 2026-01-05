public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(int id, String brand, String model, double pricePerDay) {
        super(id, brand, model, pricePerDay);
    }

    @Override
    public double calculateRentalFee(int days) {
        return pricePerDay * days;
    }
}
