import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class EngineTest {

    public Engine e;

    @Before
    public void setup(){
        this.e = new Engine(FuelType.STEAM, 100, 100);
    }

    @Test
    public void testConstructor(){
        //Verify that the `Engine` constructor initializes correctly 
        //with the given `FuelType` and fuel level.
        
        FuelType expectedFuel = FuelType.STEAM;
        double expctedLevel = 100;
        
        assertEquals(expectedFuel, e.getFuelType());
        assertEquals(expctedLevel, e.getCurrentFuel(), 0.01);

    }

    @Test
    public void testGo(){
        //Test the `go()` method to ensure that fuel consumption 
        //reduces the fuel level correctly.
        
        assertTrue(e.go());
        assertEquals(80.0, e.getCurrentFuel(), 0.01);
    }


}



/*
 * 
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class MyClassTest {

    public MyClassToTest  x;

    @Before
    public void setup(){
        this.x = new MyClassToTest ();
    }
    
    @Test
    public void testToCaps() {
        String testString = "anna";
        String expectedString = "ANNA";
        assertEquals(expectedString, x.toCaps(testString));
    }

    @Test
    public void testGetMeThree(){
        assertEquals(3, x.getMeThree());
    }

}
 */