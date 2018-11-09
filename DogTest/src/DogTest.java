import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.georgeben.dog.Dog;
import com.georgeben.dog.IllegalWeightValueException;

public class DogTest {
	Dog myDog;
	
	@BeforeClass
	public static void before(){
		System.out.println("This is run before any test starts");
	}
	
	@AfterClass
	public static void after(){
		System.out.println("This is run after all test have finished");
	}
	
	@Before
	public void setUp(){
		System.out.println("This is run before each test");
		myDog = new Dog("Jimmy", "Beagle");
	}
	
	@After
	public void tearDown(){
		System.out.println("This is run after each test");
	}

	@Test
	public void createNewDog(){
		assertEquals("Error in creating a dog", "Jimmy", myDog.getName());
	}
	
	@Test
	public void feedDog(){
		myDog.eat();
		assertEquals("Error when eating", 10, myDog.getWeight());
		
	}
	
	@Test(expected = IllegalWeightValueException.class)
	public void setNegativeDogWeight() throws IllegalWeightValueException{
		myDog.setWeight(-20);
	}

}
