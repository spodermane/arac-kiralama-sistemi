import java.util.ArrayList;
import java.util.List;

public class CarInventory{
    private List<Car> cars = new ArrayList<>();
    public void addCar(Car car){
        cars.add(car);
    }
    public void removeCar(int id) {
        cars.removeIf(car -> car.id == id);
    }
    public List<Car> getAvailableCars(){
        List<Car> list = new ArrayList<>();
        for (Car car:cars){
            if(car.isAvailable()){
                list.add(car);
            }
        }
        return list;
    }
    public Car getCarById(int id){
        for(Car car: cars){
            if(car.id == id) return car;
        }
        return null;
    }
}