/*
* This class adds two numbers
*/
public class AddNumbers {

    private int result;

    //@param numbers to be added
    public AddNumbers(int number1, int number2){
        this.result = number1 + number2;
    }
      
   // prints the result
    public String printResult(){
        System.out.println(result);
        return result;
    }   
}
