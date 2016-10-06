package MVC;

// This Model does all the calculations
public class CalcModel {
    // Holds the value of the sum of the numbers
    // entered in the view
    private double result;
    
    public void doMath(double firstNumber, double secondNumber, String operation) {
    	switch (operation){
        case "+": this.add(firstNumber, secondNumber); break;
        case "-": this.substract(firstNumber, secondNumber); break;
        case "*": this.multiply(firstNumber, secondNumber); break;
        case "/": this.divide(firstNumber, secondNumber); break;
        }
    }
    
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
