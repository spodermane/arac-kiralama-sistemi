import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Customer> customers = new ArrayList<>();
        List<Rental> rentals = new ArrayList<>();
        CarInventory inventory = new CarInventory();

        Customer loggedInCustomer = null;
        boolean running = true;

        while (running) {

            /* Login / Register menüsü*/
            if (loggedInCustomer == null) {

                System.out.println("\n=== ARAÇ KİRALAMA SİSTEMİ ===");
                System.out.println("1 - Kayıt Ol");
                System.out.println("2 - Giriş Yap");
                System.out.println("0 - Çıkış");
                System.out.print("Seçim: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    // kayıt ol
                    case 1 -> {
                        System.out.print("Ad Soyad: ");
                        String fullName = scanner.nextLine();

                        System.out.print("Kullanıcı adı: ");
                        String username = scanner.nextLine();

                        System.out.print("Şifre: ");
                        String password = scanner.nextLine();

                        boolean exists = false;
                        for (Customer c : customers) {
                            if (c.getUsername().equals(username)) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists) {
                            System.out.println(" Bu kullanıcı adı zaten mevcut.");
                        } else {
                            Customer customer = new Customer(
                                    customers.size() + 1,
                                    fullName,
                                    username,
                                    password
                            );
                            customers.add(customer);
                            System.out.println(" Kayıt başarılı.");
                        }
                    }

                    // Giris Yap
                    case 2 -> {
                        System.out.print("Kullanıcı adı: ");
                        String username = scanner.nextLine();

                        System.out.print("Şifre: ");
                        String password = scanner.nextLine();

                        for (Customer c : customers) {
                            if (c.getUsername().equals(username)
                                    && c.getPassword().equals(password)) {
                                loggedInCustomer = c;
                                break;
                            }
                        }

                        if (loggedInCustomer != null) {
                            System.out.println(" Hoş geldin, " + loggedInCustomer.getFullName());
                        } else {
                            System.out.println(" Hatalı giriş.");
                        }
                    }

                    case 0 -> {
                        running = false;
                        System.out.println("Sistem kapatıldı.");
                    }

                    default -> System.out.println(" Geçersiz seçim.");
                }
            }

            /* ana menü */
            else {

                System.out.println("\n=== ANA MENÜ ===");
                System.out.println("1 - Araç Ekle");
                System.out.println("2 - Araç Sil");
                System.out.println("3 - Müsait Araçları Listele");
                System.out.println("4 - Araç Kirala");
                System.out.println("5 - Araç İade Et");
                System.out.println("6 - Çıkış Yap");
                System.out.print("Seçim: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    // Araç Ekleme / Silme - Müsat Araçları Görüntüleme - Araç Kiralama - Araç İade
                    case 1 -> {
                        try {
                            System.out.println("1 - GasCar");
                            System.out.println("2 - ElectricCar");
                            System.out.print("Araç tipi: ");
                            int type = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Araç ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Marka: ");
                            String brand = scanner.nextLine();

                            System.out.print("Model: ");
                            String model = scanner.nextLine();

                            System.out.print("Günlük fiyat: ");
                            double price = scanner.nextDouble();

                            if (type == 1) {
                                inventory.addCar(new GasCar(id, brand, model, price));
                            } else if (type == 2) {
                                inventory.addCar(new ElectricCar(id, brand, model, price));
                            } else {
                                System.out.println("Geçersiz araç tipi.");
                                break;
                            }

                            System.out.println("Araç eklendi.");

                        } catch (InputMismatchException e) {
                            System.out.println("Hatalı giriş. Sayısal değer giriniz.");
                            scanner.nextLine();
                        }
                    }

                    case 2 -> {
                        try {
                            System.out.print("Silinecek araç ID: ");
                            int id = scanner.nextInt();
                            inventory.removeCar(id);
                            System.out.println("Araç silindi.");

                        } catch (InputMismatchException e) {
                            System.out.println("Hatalı giriş. Araç ID sayı olmalı.");
                            scanner.nextLine();
                        }
                    }

                    case 3 -> {
                        System.out.println("\n--- Müsait Araçlar ---");
                        for (Car car : inventory.getAvailableCars()) {
                            System.out.println(
                                    car.getId() + " | " +
                                            car.getBrand() + " " +
                                            car.getModel()
                            );
                        }
                    }

                    case 4 -> {
                        try {
                            System.out.print("Kiralanacak araç ID: ");
                            int carId = scanner.nextInt();

                            Car car = inventory.getCarById(carId);

                            if (car != null && car.isAvailable()) {
                                System.out.print("Kaç gün?: ");
                                int days = scanner.nextInt();

                                Rental rental = new Rental(
                                        rentals.size() + 1,
                                        car,
                                        loggedInCustomer,
                                        days
                                );

                                rentals.add(rental);
                                System.out.println("Kiralama başarılı.");
                                System.out.println("Toplam ücret: " + rental.getTotalFee());
                            } else {
                                System.out.println("Araç müsait değil.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Hatalı giriş. Sayı giriniz.");
                            scanner.nextLine();
                        }
                    }

                    case 5 -> {
                        try {
                            System.out.print("İade edilecek kiralama ID: ");
                            int rentalId = scanner.nextInt();

                            boolean found = false;
                            for (Rental r : rentals) {
                                if (r.getRentalId() == rentalId && !r.isReturned()) {
                                    r.returnCar();
                                    System.out.println("Araç iade edildi.");
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("Kiralama bulunamadı.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Hatalı giriş. Kiralama ID sayı olmalı.");
                            scanner.nextLine();
                        }
                    }

                    // Çıkıs Yap
                    case 6 -> {
                        loggedInCustomer = null;
                        System.out.println("🚪 Çıkış yapıldı.");
                    }

                    default -> System.out.println("Geçersiz seçim.");

                }
            }
        }

        scanner.close();
    }
}
