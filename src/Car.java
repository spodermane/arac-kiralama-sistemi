public abstract class Car implements IRentable {

    protected int id;
    protected String brand;
    protected String model;
    protected double pricePerDay;
    protected boolean isAvailable = true;

    public Car(int id, String brand, String model, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public abstract double calculateConsumption(int km);
    public abstract double calculateRentalFee(int days);
}
