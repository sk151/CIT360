package JUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * This class uses JUnit to test AddNumbers
 */

public class Test {
	
   int number1 = 1;	
   int number2 = 2;
   AddNumbers addNumbers = new AddNumbers(number1, number2);

   @Test
   public void testAddNumbers() {
      assertEquals(3,addNumbers.Add(number1, number2));
      
   }
}
