import java.util.ArrayList;

public class Train implements TrainRequirements{
   
    //attributes
    private Engine engine;
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int allCapacity;
    private int allSeatsLeft;
    
    /**
     * Constructor for Train
     * @param cap Train's capacity
     */
    public Train(FuelType f, double curFuel, double maxFuel, int cars, int cap){
        this.engine = new Engine(f, curFuel, maxFuel);
        this.allCapacity = 0;
        this.allSeatsLeft = 0;
        for (int i = 0; i < cars; i++){
            Car car = new Car(cap);
            this.cars.add(car);
            this.allCapacity += car.getCapacity();
            this.allSeatsLeft += car.seatsRemaining();
        }

    }

    /**
     * Getter for engine
     * @return Train's engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Getter for car
     * @param i index of car
     * @return Train's car at index i
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * Returns total capacity of all cars in the train
     * @return Train's capacity
     */
    public int getMaxCapacity(){
        this.allCapacity = 0;
        for (int i = 0; i < cars.size(); i++){
            this.allCapacity += cars.get(i).getCapacity();
        }
        return this.allCapacity;
    }

    /**
     * Returns total seats remaining in all cars in the train
     * @return Train's seats remaining
     */
    public int seatsRemaining(){
        this.allSeatsLeft = 0;
        for (int i = 0; i < cars.size(); i++){
            this.allSeatsLeft += cars.get(i).seatsRemaining();
        }
        return this.allSeatsLeft;
    }

    /**
     * Print list of all passengers aboard the train
     */
    public void printManifest(){
        System.out.println("Train Manifest:");
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + i + ":");
            cars.get(i).printManifest();
        }
    }


    public static void main(String[] args){
        // Testing Train class
        System.out.println("Testing Train class");
    
        Train t = new Train(FuelType.STEAM, 100, 100, 3, 3);
        Car c = t.getCar(0);
        Passenger p = new Passenger("Alice");
    
        System.out.println("Adding Alice to car 0");
        p.boardCar(c);  
        t.printManifest();  
        System.out.println("Seats Remaining: " + t.seatsRemaining());
        System.out.println("Removing Alice from car 0");
        p.getOffCar(c);  
        t.printManifest();  
        System.out.println("Seats Remaining: " + t.seatsRemaining());
    }
    

}
