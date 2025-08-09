public class Main {
    public static void main(String[] args){
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Car Details enter
        Car car1 = new Car("C001", "Toyota", "Camry", 60.0, true);
        Car car2 = new Car("C002", "Honda", "Accord", 70.0, true);
        Car car3 = new Car("C003", "Mahindra", "Thar", 120.0, true);
        
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
