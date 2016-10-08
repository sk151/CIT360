package MVC;

// This Model does all the calculations
public class CalcModel {
    // Holds the value of the sum of the numbers
    // entered in the view
    private double result;
    
    // This method decides which operation to do depending on user input
    // and calls the appropriate function
    public void doMath(String firstNumber, String secondNumber, String operation) {
    	switch (operation){
        case "+": this.add(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)); break;
        case "-": this.substract(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)); break;
        case "*": this.multiply(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)); break;
        case "/": this.divide(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)); break;
        }
    }
    
    // Calculations
    
    public void add(double firstNumber, double secondNumber){
    	result = firstNumber + secondNumber;
    }
    
    public void substract(double firstNumber, double secondNumber){
    	result = firstNumber - secondNumber;
    }
    
    public void multiply(double firstNumber, double secondNumber){
    	result = firstNumber * secondNumber;
    }
    
    public void divide(double firstNumber, double secondNumber){
    	result = firstNumber / secondNumber;
    }
    
    public double getResult(){
        return result;
    }

}
