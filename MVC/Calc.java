package MVC; 

public class Calc {
    public static void main(String[] args) {
        CalcView theView = new CalcView();
        CalcModel theModel = new CalcModel();
        //Create the controller and pass the view and the model for it to connect
        CalcController theController = new CalcController(theView,theModel);
    }
}
