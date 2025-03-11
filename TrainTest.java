import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TrainTest {

    public Engine e;
    public Car c;
    public Passenger p;
    public Train t;


    // Engine Tests
    @Test
    public void testEngineConstructor() {
        this.e = new Engine(FuelType.STEAM, 100, 100);
        
        FuelType expectedFuel = FuelType.STEAM;
        double expctedLevel = 100;
        
        assertEquals(expectedFuel, e.getFuelType());
        assertEquals(expctedLevel, e.getCurrentFuel(), 0.01);
    
    }

    @Test
    public void testEngineGo() {
        this.e = new Engine(FuelType.STEAM, 100, 100);

        assertTrue(e.go());
        assertEquals(80.0, e.getCurrentFuel(), 0.01);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        this.c = new Car(1);
        
        Passenger pTest = new Passenger("Anna");
        c.addPassenger(pTest);
        assertEquals(c.seatsRemaining(), 0, 0.01);   
    }

    @Test
    public void testCarRemovePassenger() {
        this.c = new Car(1);
       
        Passenger pTest = new Passenger("Anna");
        assertFalse(c.removePassenger(pTest));
        c.addPassenger(pTest);
        assertTrue(c.removePassenger(pTest));
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        this.p = new Passenger("Anna");
        Car c = new Car(1);
        assertTrue(p.boardCar(c));
    }

    @Test
    public void testPassengerBoardCarFull() {
        this.p = new Passenger("Anna");

        Passenger pTest = new Passenger("Anna");
        Car c = new Car(1);
        c.addPassenger(pTest);
        assertFalse(c.addPassenger(pTest));
    }

    // Train Tests
    /*
    - Verify that a `Train` initializes correctly with a given number of `Car`s.
    - Ensure the `Train`’s total `Passenger` count updates as `Passenger`s board and leave.
    - Check that the `getCar(int i)` method returns the expected `Car`.
    - Test the `printManifest()` method to ensure it iterates through the `Train`s `Car`s correctly.
     */

    @Test
    public void testTrainConstructor() {
        this.t = new Train(FuelType.STEAM, 100, 100, 2, 1);
                
        assertEquals(2, t.getMaxCapacity(), 0.01);
    
    }

    @Test
    public void testTrainPassengerCount() {
        this.t = new Train(FuelType.STEAM, 100, 100, 2, 1);
        this.p = new Passenger("Anna");
        this.c = t.getCar(0);

        //p.boardCar(c);
        c.addPassenger(p);
        assertEquals(1, t.seatsRemaining(), 0.01);
        p.getOffCar(c);
        assertEquals(2, t.seatsRemaining(), 0.01);
        
    }

    @Test
    public void testTrainGetCar() {
        this.t = new Train(FuelType.STEAM, 100, 100, 2, 1);
        
        assertNotNull(t.getCar(0));
        assertNotNull(t.getCar(1));
        assertNotSame(t.getCar(0), t.getCar(1));
    
    }

    //this is failing but I don't know why, the expected and actual look exactly the same...
    //anyway, ran out of time to figure out and have too much other work to use an extension rn
    @Test
    public void testTrainPrintManifest() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ogOut = System.out;
        System.setOut(new PrintStream(outputStream));   

        this.t = new Train(FuelType.STEAM, 100, 100, 2, 1);
        Passenger p1 = new Passenger("Anna");
        Passenger p2 = new Passenger("Elena");
        Car c1 = t.getCar(0);
        Car c2 = t.getCar(1);

        c1.addPassenger(p1);
        c2.addPassenger(p2);

        t.printManifest();

        System.setOut(ogOut);
        
        String expected = "Train Manifest:\n" + "Car 0:\n" + "Anna\n" + "Car 1:\n" + "Elena\n";

        assertEquals(expected.trim(), outputStream.toString().trim());

    }
    
}
