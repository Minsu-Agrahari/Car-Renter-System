public class Car{

    private String id;
    private String model;
    private String carBrand;
    private double basePrice;
    private boolean isAvaliable;

    Car(){
        
    }
    // Constructor to set the value of 
    // id, model, carBrand, basePrice, isAvaliable
    Car(String id, String model, String carBrand, double basePrice, boolean isAvaliable){
        this.id = id;
        this.model = model;
        this.carBrand = carBrand;
        this.basePrice = basePrice;
        this.isAvaliable = isAvaliable;
    }

    // Creating getter and setter for the private variable...
    // Get Methods
    public String getId(){
        return id;
    }
    public String getModel(){
        return model;
    }
    public String getCarBrand(){
        return carBrand;
    }
    public boolean isAvaliable(){
        return isAvaliable;
    }
    public double getBasePrice(){
        return basePrice;
    }

    public double calculatePrice(int rentalDays){
        return rentalDays * basePrice;
    }

    public void rentCar(){
        isAvaliable = false;
    }
    public void returnCar(){
        isAvaliable = true;
    }

}