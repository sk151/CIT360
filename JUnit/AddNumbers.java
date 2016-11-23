package JUnit;
/*
 * This is the class I'll be testing with JUnit, 
 * it just adds two numbers that are passed to it.
*/
public class AddNumbers {

    private int result;

    //@param numbers to be added
    public  AddNumbers(int number1, int number2){
        this.result = number1 + number2;
        return result;
    }
      
   // prints the result
    public int printResult(){
        System.out.println(result);
    }   
} 
