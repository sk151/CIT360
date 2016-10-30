package TomcatServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import com.google.gson.Gson;

/*
 * This servlet takes input from the user
 */
@WebServlet("/TomcatServlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		 PrintWriter myOutput = response.getWriter();
		 
		 //Create a new JSON object
	      JSONObject bankObj1 = new JSONObject();
        
        // This is for testing purposes
	      System.out.println("acc-num:" + request.getParameter("acc_num"));
	      System.out.println("name:" + request.getParameter("name"));
	      
        // Getting user input from the forms
	      String tName = request.getParameter("name");
	      Integer tAcc_num = Integer.parseInt(request.getParameter("acc_num"));
	      Double tBalance = Double.parseDouble(request.getParameter("balance"));
	      Boolean tIs_vip = Boolean.parseBoolean(request.getParameter("is_vip"));
	      	      
	      //A happy path to put values into the object one by one
	      try {
		      bankObj1.put("name", tName);
		      bankObj1.put("acc_num", tAcc_num);
		      bankObj1.put("balance", tBalance);
		      bankObj1.put("is_vip_client", tIs_vip);
		      myOutput.println("Added Harry Potter's account:" + bankObj1);
	      }
	      catch (Exception e) {
	    	  myOutput.println("Something went wrong with the happy path.");
	    	  e.printStackTrace();
	      }
	      	      
	      //A nasty path to populate an object:
	      try {
	    	  bankObj1.put("name", request.getParameter("name"));
		      bankObj1.put("acc_number", request.getParameter("acc_num"));
		      bankObj1.put("balance", request.getParameter("balance"));
		      bankObj1.put("is_vip_client", request.getParameter("is_vip"));
	          System.out.println("Added Ron Weasley's account:" + bankObj1);
	      }
	      catch (Exception e) {
	    	  myOutput.println("Something else went wrong with the nasty path.");
	      }
	      
	      // Using GSON to serialize the object and print it as string
	      Gson myGson = new Gson();
	      String jsonString = myGson.toJson(bankObj1); 
	      myOutput.println("Serialized a BankAccount object into JSON:" + jsonString);
	      
	      // Deserializing the JSON back into a BankAccount object
		  try {
			  BankAccount bankObj2 = myGson.fromJson(jsonString, BankAccount.class);   
			  myOutput.println("Deserialized JSON back into a BankAccount object:"
					  + "\n name: " + harry1.name
					  + "\n acc_num: " + harry1.acc_num
					  + "\n balance: " + harry1.balance
					  + "\n is vip: " + harry1.is_vip);  
		  } catch (Exception e) {
			  e.printStackTrace();
		}
		myOutput.println("All done!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
