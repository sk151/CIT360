package JUnit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
 * This class runs the JUnit test
 */
 
public class MainClass {

   public static void main(String[] args) {
   
      Result myResult = JUnitCore.runClasses(Test.class);
      
      // A happy path to show test results:
      
      for (Failure failure : myResult.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(myResult.wasSuccessful());
      
      // A nasty path to get the results:
      
      try {
         if (myResult.getFailures()=null){
            System.out.println("Test succeeded.");
         }
         else {
            System.out.println(myResult.getFailures());
         }
      }
      catch (exception e) {
        System.out.println("Nasty path didn't work.");
      }
   }
} 
