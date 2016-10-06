package MVC;
import java.util.*;

/* This View only worries about showing and
 * delivering information to and from the user
 */

public class CalcView {
	Scanner scanner = new Scanner( System.in );
	String firstNumber;
	String operation;
	String secondNumber;
	
	//puts user dialog on the screen
	public CalcView() {
		System.out.println("First number:");
		firstNumber = scanner.nextLine();
		System.out.println("Operation (+, -, *, /):");
		operation = scanner.nextLine();
		System.out.println("Second number:");
		secondNumber = scanner.nextLine();
	}

	//getters for the data
    public double getFirstNumber(){
        return Double.parseDouble(firstNumber);
    }
    public double getSecondNumber(){
    	return Double.parseDouble(secondNumber);
    }
    public String getOperation(){
        return operation;
    }
    
    public void printResult(double result){
        System.out.println("Result:" + result);;
    }
}
