package HttpUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//This class makes a request to a server, reads the reply and closes the connection
public class Connect {
	  public static void main(String[] args) {
		  //This is unnecessary but wouldn't hurt to do before starting a connection.
	      HttpURLConnection myConnection = null;
	      OutputStreamWriter outStreamWriter = null;
	      BufferedReader bufReader  = null;
	      StringBuilder stringBuilder = null;
	      String myString = null;	    
	      URL myURL = null;
	      
	      //Nasty path would be not putting this in a "try" block since 
	      //we can't always guarantee a connection and the desired output
	      try {
	    	  /* Happy path is to set a URL to a server that
	    	   * I know exactly what is coming from it and
	    	   * preferably one that I have set up.
	    	   * A nasty path would be guessing what's coming from some other URL
	    	   * myURL = new URL("http://www.youtube.com");
	    	   */
	          myURL = new URL("http://localhost");
	          myConnection = null;
	        
	          //Open a connection and start reading
	          myConnection = (HttpURLConnection)myURL.openConnection(); 
	          myConnection.setRequestMethod("GET"); 
	          myConnection.setDoOutput(true); 
	          myConnection.setReadTimeout(10000);                     
	          myConnection.connect(); 
	        
	          /* Read the result from the server
	           * and use a string builder to append 
	           * more input from the string.
	           */
	          bufReader  = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
	          stringBuilder = new StringBuilder();
	          
	          /* Nasty path to read input:
	           * myString = bufReader.read();
	           * The input wouldn't be all we're looking for.
	           */
	          
	          // Happy path for reading input:
	          while ((line = bufReader.readLine()) != null)
	          {
	        	  stringBuilder.append(line + '\n');
	          }
	        
	          System.out.println(sb.toString());
	                    
	      } catch (Exception ex) {
	          e.printStackTrace();
	      }
	      
	      //Happy path is to close the connection after I'm done.
 	      myConnection.disconnect();
	      
	  }
	}
}
