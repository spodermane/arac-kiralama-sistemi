public class ElectricCar extends Car {
    private int batteryCapacity;
    private double energyConsumption;

    public ElectricCar(int id, String brand, String model, double pricePerDay, int batteryCapacity,double energyConsumption) {
        super(id, brand, model, pricePerDay);
        this.batteryCapacity = batteryCapacity;
        this.energyConsumption = energyConsumption;
    }

    @Override
    public double calculateConsumption(int km) {
        return (energyConsumption / 100) * km;
    }

    @Override
    public double calculateRentalFee(int days) {
        return pricePerDay * days;
    }
}
