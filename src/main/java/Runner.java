import java.lang.invoke.TypeDescriptor;
import java.util.ArrayList;
import java.util.List;

public class Runner {
   

    public interface Storage{
        public Car get(int index);
        public void set(int index, Car car);
        public void add(Car car);
    }
    public class Car{
        private String make, model, year; 
        Car(String make, String model, String year){
            this.make = make; 
            this.model = model; 
            this.year = year; 
        }

        public String toString(){
            return this.make + " " + this.model + " " + this.year;
        }
    }

    public class Garage implements Storage{
        private List<Car> cars = new ArrayList<>(); 

        @Override
        public Runner.Car get(int index) {
            try{
                return cars.get(index);
            }catch (Exception e){
                System.out.println(e);
            }
            return null;
        }
        @Override
        public void set(int index, Runner.Car car) {
            try{
                cars.set(index, car);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(this.cars);
        }
        @Override
        public void add(Runner.Car car) {
            this.cars.add(car);
            System.out.println(this.cars);
        }
    }

    public static void main(String[] args) {
        //https://stackoverflow.com/questions/9560600/what-causes-error-no-enclosing-instance-of-type-foo-is-accessible-and-how-do-i
        Runner r = new Runner();
        Garage garage = r.new Garage();
    
        garage.add(r.new Car("Toyota","Camry","2022"));
        garage.add(r.new Car("BMW","M3","2021"));
        garage.add(r.new Car("Mercedes","GLE","2022"));
        garage.set(1, r.new Car("Honda","Civic","1999"));
        System.out.println(garage.get(1));

    }
}
