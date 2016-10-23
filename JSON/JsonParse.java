package JSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


//This class will try to parse strings into a JSON object
class JsonParse {

   public static void main(String[] args){
	  //Createing a parser
      JSONParser parser = new JSONParser();
      
      //I forgot that you have to use \" in order to have " as part of the string so this would be a nasty path:
      //String s1 = "{"acc_number":4325,"balance":1.05957631E7,"name":"Harry Potter","is_vip_client":true}";
      //Happy path with the right input:
      String s = "["
      			+ "{"
      				+ "\"acc_number\":4325,"
      				+ "\"balance\":1.05957631E7,"
      				+ "\"name\":\"Harry Potter\","
      				+ "\"is_vip_client\":true"
      			+ "},"
      			+ "{"
      				+ "\"acc_number\":5210,"
      				+ "\"balance\":30.05,"
      				+ "\"name\":\"Ronald Weasley\","
      				+ "\"is_vip_client\":false"
      			+ "}"
      			+ "]";
		
      try{
         Object obj = parser.parse(s);
         JSONArray array = (JSONArray)obj;
		 
         //Displaying different parts of the parsed object
         System.out.println("1st element of the array:");
         System.out.println(array.get(0));
         System.out.println();
         
         System.out.println("2nd element of the array:");
         System.out.println(array.get(1));
         System.out.println();

         //Happy and nasty paths to parse different strings into JSON 
         try {
			s = "{hello?]";
			 obj = parser.parse(s);
			 System.out.println(obj);
		 } catch (Exception e) {
			System.out.println("bad choice of brackets");
		 }

         try {
        	 s = "[hello:world]";
             obj = parser.parse(s);
             System.out.println(obj);
 		 } catch (Exception e) {
 			System.out.println("didn't use quotation marks");
 		 }
         
         //This one parses fine
         s = "[1,,,2,,,,,,]";
         obj = parser.parse(s);
         System.out.println(obj);
         
         //Not this one
         try {
        	 s = "[1,2+3,{4*5}]";
             obj = parser.parse(s);
             System.out.println(obj);
 		 } catch (Exception e) {
 			System.out.println("the parser can't do math");
 		 }
         
      }catch(ParseException pe){
         System.out.println(pe);
      }
   }
}
