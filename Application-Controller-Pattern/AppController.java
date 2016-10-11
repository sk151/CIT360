package application_controller_pattern;
import java.util.HashMap;
import application_controller_pattern.AppControllerTarget;

public class AppController {
	/*Create a hash map with dice
	 * according to the list printed to the user
	 * (1st option means we're rolling a d4 etc.)
	 */
	public static HashMap<Integer, Integer> diceMap = new HashMap<Integer, Integer>();
	public static void populateDiceMap(){
		diceMap.put(1, 4);
		diceMap.put(2, 6);
		diceMap.put(3, 8);	
		diceMap.put(4, 10);
		diceMap.put(5, 20);
	}
	
	/*Handle user's request and roll the die
	 *that the user picked
	 */
	public static void handleRequest(int command){
                AppControllerTarget.Handler.roll(diceMap.get(command));
    }
}
