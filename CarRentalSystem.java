import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class CarRentalSystem {
    
    // CREATEING ARRAYLIST TO STORE DATA...
    private ArrayList<Car> carsList;
    private ArrayList<Customer> customersList;
    private ArrayList<Rental> rentalsList;

    CarRentalSystem(){
    
        carsList = new ArrayList<>();
        customersList = new ArrayList<>();
        rentalsList = new ArrayList<>();
    
    }

    public void addCar(Car car){
    
        carsList.add(car);
    
    }

    public void addCustomer(Customer customer){
    
        customersList.add(customer);
    
    }

    public void rentalCar(Car car, Customer customer, int days){
        
        if(car.isAvaliable()){
            car.rentCar();
            rentalsList.add(new Rental(car, customer, days));
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("... Car rented Successfully... ");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        }else{
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("... Cars is not availabe for rent ... ");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        }

    }

    public void returnCar(Car car) {
    Rental rentalToRemove = null;

    for (Rental rent : rentalsList) {
        if (rent.getCar() == car) {  // Same object reference
            rentalToRemove = rent;
            break;
        }
    }

    if (rentalToRemove != null) {
        rentalsList.remove(rentalToRemove);
        car.returnCar(); // mark it as available

        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("... Car returned successfully!...");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    } else {
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("... Car was not rented ...");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
}

    public void menu() {
        Scanner in = new Scanner (System.in);

        while(true){
            
            System.out.println("\n==== Car Rental System ====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            
            System.out.print("\n -> Enter Your Choices :- ");
            int choice = in.nextInt();
            in.nextLine(); // consume the newline

            if(choice == 1){
                System.out.print("\n==== Rent a Car ====\n");
                System.out.print(" -> Enter your name :- ");
                String customerName = in.nextLine();

                System.out.println("\n==== Available Cars are as followed ====");
                for(Car car : carsList){
                    System.out.println(" -> " + car.getId() + " - " + car.getCarBrand() + " - " + car.getModel() + " - " + car.getBasePrice() + " - " +car.isAvaliable());
                }

                System.out.print("\n -> Enter the car ID you want to rent :- ");
                String carId = in.nextLine();

                // Check the if the Select Car id is Present in the DataBase
                boolean carPresent = false;
                for(Car car : carsList){
                    if(carId.equals(car.getId())){
                        carPresent = true;
                        break;
                    }
                }

                if(carPresent){
                    System.out.print(" -> Enter the number of days for rental :- ");
                    int rentalDays = in.nextInt();
                    in.nextLine(); // Consume newLine

                    Customer newCustomer = new Customer(customerName, "CUS"+(customersList.size() + 1));
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for(Car car: carsList){
                        if(car.getId().equals(carId) && car.isAvaliable()){
                            selectedCar = car;
                            break;
                        }
                    }

                    if(selectedCar != null){
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        
                        System.out.println("\n == Rental Information ==\n");
                        System.out.println(" -> Customer ID: "+newCustomer.getId());
                        System.out.println(" -> Customer ID: "+newCustomer.getName());
                        System.out.println(" -> Car: "+selectedCar.getCarBrand() + " " + selectedCar.getCarBrand());
                        System.out.println(" -> Rental Days: "+rentalDays);
                        System.out.printf(" -> Total Price $%.2f:- ", totalPrice);

                        System.out.print("\n\n -> Confirm rental (Y/N)... ");
                        String confirm = in.nextLine();

                        if(confirm.equalsIgnoreCase("Y")){
                            // selectedCar.rentCar();
                            rentalCar(selectedCar, newCustomer, rentalDays);
                        }else{
                            System.out.println("\n...Rental canceled... ");
                        }
                    }else{
                        System.out.println("\n...Invalid car selected or car not available for rent... ");
                    }
                }else{
                    System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println(" ...Enter the Correct Car-ID ...");
                    System.out.println("\n =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                }

                

            }else if(choice == 2){

                System.out.println("\n==== Return a Car ====");
                System.out.print(" -> Enter the car Id you want to return: ");
                String carId = in.nextLine();

                Car carToReturn = null;
                for(Car carStatus : carsList){
                    // System.out.println("-----------"+carStatus.getId());
                    if(carStatus.getId().equals(carId)){
                        carToReturn = carStatus;
                        // System.out.println("---");
                        break;
                    }
                }
                
                // System.out.println("--- "+carToReturn.getId());

                if(carToReturn != null){
                    // System.out.println("----");
                    // returnCar(carToReturn);
                    Customer customer = null;
                    for(Rental rental : rentalsList){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();

                            carToReturn.returnCar();
                            rentalsList.remove(rental);
                            break;
                        }
                    }

                    if(customer != null){
                        System.out.println("...Car returned Successfully by " + customer.getName() + "...");
                    }else{
                        System.out.println("...Invalid car Id or Car is not rented... ");
                    }
                }

            }else if(choice == 3){
                break;
            }else{
                System.out.println("... Invalid choice. Please enter a vaild option... ");
            }
        }

        System.out.println("\n ... Thank you for using the Car rented System ... ");
    }
}


