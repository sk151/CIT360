package MVC;

// The View and the Model don't know each other exists

public class CalcController {
       
    public CalcController(CalcView theView, CalcModel theModel) {
        
    	try{
        	//get the data from the View
            double firstNumber = theView.getFirstNumber();
            double secondNumber = theView.getSecondNumber();
            String operation = theView.getOperation();
            
            /* Nasty path for the controller.
             * At first, this part was here and not
             * in the Model. This wasn't a good use
             * of the pattern because this block is
             * Model's job to do while the Controller
             * should be just a connection between Model and View.
             
            switch (operation){
            case "+": theModel.add(firstNumber, secondNumber); break;
            case "-": theModel.substract(firstNumber, secondNumber); break;
            case "*": theModel.multiply(firstNumber, secondNumber); break;
            case "/": theModel.divide(firstNumber, secondNumber); break;
            }
            */
            
            //pass the data to the Model to do its magic
            theModel.doMath(firstNumber, secondNumber, operation);
            
            //get the result from the Model and pass it to the View
            theView.printResult(theModel.getResult());
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
