public class Passenger {
    
    //attributes
    private String name;

    //constructor
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return Passenger's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Call addPassenger to board the car
     * @param c Car to board
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this)){
            System.out.println(this.name + " has boarded the car.");
        } else {
            System.out.println("No room in this car.");
        }
    }
    

    /**
     * Call removePassenger to get off the car
     * @param c Car to get off
     */ 
    public void getOffCar(Car c) {
        if (c.removePassenger(this)){
            System.out.println(this.name + " has left the car.");
        } else {
            System.out.println("Passenger not in car.");
        }
    }


    public static void main(String[] args){
        //to test code
        System.out.println("Testing Passenger class");
        Passenger p = new Passenger("Alice");
        Car c = new Car(3);
        p.boardCar(c);
        p.getOffCar(c);
        p.getOffCar(c);
    }

}
