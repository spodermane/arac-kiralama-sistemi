public class Main {
    public static void main(String[] args) {

        // Envanter oluştur
        CarInventory inventory = new CarInventory();

        // Araçlar ekle
        ElectricCar tesla = new ElectricCar(1, "Tesla", "Model 3", 1200, 75);
        GasCar bmw = new GasCar(2, "BMW", "320i", 900, 7.5);

        inventory.addCar(tesla);
        inventory.addCar(bmw);

        // Müşteri oluştur
        Customer ali = new Customer(1, "Ali Yılmaz");

        // Araç kirala
        Rental rental = new Rental(100, tesla, ali, 5);

        // Ücreti gör
        System.out.println("Kiralama ücreti: " + rental.getTotalFee());

        // Ödeme yap
        Payment payment = new Payment(1, rental);
        System.out.println("Ödeme yapıldı: " + payment.getAmount());

        // Araç iade et
        rental.returnCar();

        // Müsait araçları göster
        System.out.println("Müsait Araçlar:");
        for (Car c : inventory.getAvailableCars()) {
            System.out.println(c.brand + " " + c.model);
        }
    }
}
