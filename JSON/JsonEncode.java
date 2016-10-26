package JSON_QCJSON;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.*;

//This class populates a JSON object, serializes and deserializes it into a file
class JsonEncode {

   public static void main(String[] args){
	  //Creata a new object
      JSONObject bankObj1 = new JSONObject();
      String fileName = "JSON.bin";
      JSONParser parser = new JSONParser();
      
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
    	  System.out.println("Something went wrong");
      }
      
      //////////////////////////////////////////////////////////////////////////
      // Serialization
      
      // First, populating the object
      BankAccount harry = new BankAccount();
      harry.name = "Harry Potter";
      harry.acc_num = 4325;
      harry.balance = 10595763.10;
      harry.is_vip = true;
      
      // Using GSON to serialize the object and print it as string
      Gson myGson = new Gson();
      String jsonString = myGson.toJson(harry); 
      System.out.println("Serialized a BankAccount object into JSON:" + jsonString);
      
      // Deserializing the JSON back into a BankAccount object
	  try {
		  BankAccount harry1 = myGson.fromJson(jsonString, BankAccount.class);   
		  System.out.println("Deserialized JSON back into a BankAccount object:"
				  + "\n name: " + harry1.name
				  + "\n acc_num: " + harry1.acc_num
				  + "\n balance: " + harry1.balance
				  + "\n is vip: " + harry1.is_vip);  
	  } catch (Exception e) {
		  e.printStackTrace();
	}      
   }
}
