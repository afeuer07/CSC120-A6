public class Engine implements EngineRequirements {

    //attributes
    private FuelType f;  
    private double curFuel;
    private double maxFuel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param curFuel Engine's current fuel level
     * @param maxFuel Engine's maximum fuel level
     */
    public Engine(FuelType f, double curFuel, double maxFuel) {
        this.f = f;
        this.curFuel = curFuel;
        this.maxFuel = maxFuel;
    }

    /**
     * Getter for fuel type
     * @return Engine's fuel type
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * Getter for maximum fuel level
     * @return Engine's maximum fuel level
     */
    public double getMaxFuel() {
        return this.maxFuel;
    }

    /**
     * Getter for current fuel level
     * @return Engine's current fuel level
     */
    public double getCurrentFuel() {
        return this.curFuel;
    }

    /**
     * Refuel the engine
     */
    public void refuel() {
        this.curFuel = this.maxFuel;
        return;
    }

    /**
     * Start the engine, consume fuel
     * @return true if the engine starts, false otherwise
     */
    public Boolean go() {
        //use a timer and spend a certain amt of fuel per second? 
        //for now, just consume half of fuel
        if (this.curFuel == 0) {
            return false;
        } else{
            this.curFuel -= this.maxFuel/5;
            System.out.println("Engine started! Fuel level: " + this.curFuel + "/" + this.maxFuel);
            return true;
        }
        
    }

    /**
     * String representation of the engine
     * @return String of my.Engine's attributes
     */
    public String toString() {
        return ("Engine has fuel type " + this.f + " and fuel level " + curFuel + "/" + maxFuel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC,100.,100.);
        System.out.println(myEngine);

        while(myEngine.go()){
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
     
}