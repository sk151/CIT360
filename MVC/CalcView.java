package MVC;
import java.util.*;

/* This View only worries about showing and
 * getting information to and from the user
 */

public class CalcView {
	Scanner scanner = new Scanner( System.in );
	String firstNumber;
	String operation;
	String secondNumber;
	
	//puts user dialog on the screen
	//and gets the input from user
	public CalcView() {
		System.out.println("First number:");
		firstNumber = scanner.nextLine();
		System.out.println("Operation (+, -, *, /):");
		operation = scanner.nextLine();
		System.out.println("Second number:");
		secondNumber = scanner.nextLine();
	}

	//getters for the controller to access user input
    public String getFirstNumber(){
        return firstNumber;
    }
    public String getSecondNumber(){
        return secondNumber;
    }
    public String getOperation(){
        return operation;
    }
    
    //prints the value of "result" that gets passed to it
    public void printResult(double result){
        System.out.println("Result:" + result);;
    }
}
