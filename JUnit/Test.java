package JUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * This class uses JUnit to test AddNumbers
 */

public class Test {
	
	@Before // Setting everything up for testing
	public void inputData() {
		int number1 = 1;	
   		int number2 = 2;
  		AddNumbers addNumbers = new AddNumbers(number1, number2);
		System.out.println("Test object initialized.");
	}
	
	@Ignore // An old version of the test I'm ignoring this time
	public void testAddNumbers1() {
      		assertEquals(number1+number2,addNumbers.Add(number1, number2));
	
   	@Test // The current test
   	public void testAddNumbers2() {
      		assertEquals(3,addNumbers.Add(number1, number2));
		System.out.println("Testing.");
	}
	
	@After // Unnecessary here but this is where I'd free up expensive resources etc.
	public void cleanup() {
		AddNumbers = null;
		System.out.println("Test object initialized.");
	}
      
   }
}
