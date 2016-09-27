package application_controller_pattern;
//import java.util.HashMap;
import java.util.Scanner;


public class AppControllerExample {

	public static void main(String[] args) {
		
		/*Ask user for input and then 
		 *send the input to the controller which,
		 *in its turn, sends back the information
		 *that the user needs
		 */
		Scanner myscanner = new Scanner(System.in);
		System.out.println("Select the die you want to roll:"
				+ "\n 1. 4-sided"
				+ "\n 2. 6-sided"
				+ "\n 3. 8-sided"
				+ "\n 4. 10-sided"
				+ "\n 5. 20-sided"
				+ "\n");
		int input = myscanner.nextInt();
		
		/*Send input to the controller
		 *to deal with. To make it more simple,
		 *I made the controller do the die rolling too
		 */
		//AppController mycontroller = new AppController();
		//mycontroller.roll(input);	
		AppController.roll(input);	
		myscanner.close();
	}

}

