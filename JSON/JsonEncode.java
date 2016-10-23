package JSON;
import org.json.simple.JSONObject;

//This class adds values to a JSON object line by line

class JsonAdd {

   public static void main(String[] args){
	    //Create a new object
      JSONObject bankObj1 = new JSONObject();
      
      //A happy path to put values into the object one by one
      bankObj1.put("name", "Harry Potter");
      bankObj1.put("acc_number", new Integer(4325));
      bankObj1.put("balance", new Double(10595763.10));
      bankObj1.put("is_vip_client", new Boolean(true));
      System.out.println("Added Harry Potter's account:" + bankObj1);
      
      //A nasty path for it.
      //Wasn't expecting it to work but apparently it recognizes the data types.
      try {
    	  bankObj1.put("name", "Ronald Weasley");
          bankObj1.put("acc_number", 5210);
          bankObj1.put("balance", 30.05);
          bankObj1.put("is_vip_client", false);
          System.out.println("Added Ron Weasley's account:" + bankObj1);
      }
      catch (Exception e) {
    	  System.out.println("something went wrong");
      }     
   }
}
