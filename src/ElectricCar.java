public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(int id, String brand, String model, double pricePerDay, int batteryCapacity) {
        super(id, brand, model, pricePerDay);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double calculateRentalFee(int days) {
        return pricePerDay * days;
    }
}
