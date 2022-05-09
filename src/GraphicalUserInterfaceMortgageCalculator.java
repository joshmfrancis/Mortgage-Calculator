// Names: Joshua Francis, Jordan Golliday
// Course: CSC 135
// Project: MidtermExtra_Francis_Golliday
// File Name: GraphicalUserInterfaceMortgageCalculator.java

// This program calculates the mortgage for a user and prints information that 
// might be useful to them. It asks for annual interest rate, number of years 
// held, and amount of money borrowed in a GUI. It outputs the loan amount, 
// number of years, range of interest rates, and has 4 different iterations 
// of all of the information inputted in the same GUI. 

// Imports that we used 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.text.DecimalFormat;


public class GraphicalUserInterfaceMortgageCalculator extends Application {

    // Where the user will input the data when prompted
    // This is in the top class, because it is used in two other classes
    TextField fieldAnnualIntRate = new TextField();
    TextField fieldYearsHeld = new TextField();
    TextField fieldMoneyBorrowed = new TextField();
    
    // Modified variables based on the basic variables
    // for the iterations of the outputs (Grouped that way)
    double minusOneAnnualIntRate, minusPointFiveAnnualIntRate, 
    plusPointFiveAnnualIntRate, plusOneAnnualIntRate;
        
    double minusOneMonthlyIntRate, minusPointFiveMonthlyIntRate, 
    plusPointFiveMonthlyIntRate, plusOneMonthlyIntRate;
        
    double minusOneMonthlyPayment, minusPointFiveMonthlyPayment, 
    plusPointFiveMonthlyPayment, plusOneMonthlyPayment;
    
    // Other variables that needed to be created
    double monthlyIntRate, monthlyPayment;
    
    // Creates 7 Strings for use of the output when combined by the 
    // 'public void processButtonPress(ActionEvent event)' class
    String s1, s2, s3, s4, s5, s6, s7;
    
    // Creates an output for use of the GridPane and the user to read
    Text output = new Text("");
    
    // Formatters for all of the data that is processed
    DecimalFormat dollarFmt = new DecimalFormat("$0.00");
    DecimalFormat loanDollarFmt = new DecimalFormat("$0.##");
    DecimalFormat percentageFmt = new DecimalFormat("0.00%");
    DecimalFormat intRateRangePecrentageFmt = new DecimalFormat("0.0#%");
    DecimalFormat yearFmt = new DecimalFormat("0.#");
        
    @Override
    public void start(Stage primaryStage) {

        // Creates a button that when clicked will run 
        // 'public void processButtonPress(ActionEvent event)'
        Button calc = new Button("Calculate");
        calc.setOnAction(this::processButtonPress);
        
        // Sets the text that the user will read what to input
        Text textAnnualIntRate = new Text("Annual Interest Rate:");
        Text textYearsHeld = new Text("Amount of Years Held:");
        Text textMoneyBorrowed = new Text("Amount of money borrowed:");
        
        // GridPane that handles all of the information displaying, 
        // button, and output for the reader to see.
        GridPane inputGrid = new GridPane();
        inputGrid.setVgap(5);
        inputGrid.setHgap(40);
        inputGrid.add(textAnnualIntRate, 0, 0);
        inputGrid.add(textYearsHeld, 0, 1);
        inputGrid.add(textMoneyBorrowed, 0, 2);
        inputGrid.add(fieldAnnualIntRate, 1, 0);
        inputGrid.add(fieldYearsHeld, 1, 1);
        inputGrid.add(fieldMoneyBorrowed, 1, 2);
        inputGrid.add(calc, 0, 3);
        inputGrid.setAlignment(Pos.TOP_CENTER);
        inputGrid.setStyle("-fx-background-color: white");
        inputGrid.add(output, 0, 4);
        
        // Creates the scene with the GridPane and sets size
        Scene scene = new Scene(inputGrid, 800, 320);

        // Titles the stage and sets other needed start properties
        primaryStage.setTitle("GUI Mortgage Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void processButtonPress(ActionEvent event) {

        // Grabs the input from the user 
        // and converts them to doubles for the program to compute
        double annualIntRate = Double.parseDouble(fieldAnnualIntRate.getText());
        double yearsHeld = Double.parseDouble(fieldYearsHeld.getText());
        double moneyBorrowed = Double.parseDouble(fieldMoneyBorrowed.getText());
        
        // Modifies the 'annualIntRate' to accomidate the iterations
        // and places them in their respective variables
        minusOneAnnualIntRate = annualIntRate - 1;
        minusPointFiveAnnualIntRate = annualIntRate -0.5;
        plusPointFiveAnnualIntRate = annualIntRate + 0.5;
        plusOneAnnualIntRate = annualIntRate + 1;
        
        // Math to determine the 'monthlyIntRate' based on the 'annualIntRate'
        monthlyIntRate = ((annualIntRate / 100) / 12);
        
        // Math to determine the 'monthlyIntRate' for the iterations
        // based on the 'annualIntRate' iterations
        minusOneMonthlyIntRate = ((minusOneAnnualIntRate/100)/12);
        minusPointFiveMonthlyIntRate = ((minusPointFiveAnnualIntRate/100)/12);
        plusPointFiveMonthlyIntRate = ((plusPointFiveAnnualIntRate/100)/12);
        plusOneMonthlyIntRate = ((plusOneAnnualIntRate/100)/12);
        
        // Math to determine the 'monthlyPayment' 
        // based on 'monthlyIntRate', 'moneyBorrowed', and 'yearsHeld'
        
        // Data for the normal iteration
        monthlyPayment = (monthlyIntRate * moneyBorrowed) 
        / (1-(1/(Math.pow(1+monthlyIntRate, (12*yearsHeld)))));
        
        // Math to determine the 'monthlyPayment' for the iterations based on 
        // 'monthlyIntRate' iterations, 'moneyBorrowed', and 'yearsHeld' 
        // (THE REST OF THE ITERATIONS)
        
        // Data for the -1 iteration
        minusOneMonthlyPayment = (minusOneMonthlyIntRate * moneyBorrowed)
        / (1-(1/(Math.pow(1+minusOneMonthlyIntRate, (12*yearsHeld)))));
        
        // Data for the -0.5 iteration
        minusPointFiveMonthlyPayment = (minusPointFiveMonthlyIntRate * 
        moneyBorrowed) / (1-(1/(Math.pow(1+minusPointFiveMonthlyIntRate, 
        (12*yearsHeld)))));
        
        // Data for the +0.5 iteration
        plusPointFiveMonthlyPayment = (plusPointFiveMonthlyIntRate * 
        moneyBorrowed) / (1-(1/(Math.pow(1+plusPointFiveMonthlyIntRate, 
        (12*yearsHeld)))));
        
        // Data for the +1 iteration
        plusOneMonthlyPayment = (plusOneMonthlyIntRate * moneyBorrowed)
        / (1-(1/(Math.pow(1+plusOneMonthlyIntRate, (12*yearsHeld)))));
        
        // First String
        // 'Loan Amount', 'Number of years', and 'Range of 
        // interest rates' for the user to read, The other string parts display 
        // more information.
        String s1 = ("******************************\n" +
        "Loan Amount: " + loanDollarFmt.format(moneyBorrowed) + "\n" +
        "Number of years: " + yearFmt.format(yearsHeld) + "\n" +
        "Range of interest rates: " + intRateRangePecrentageFmt.format
        (minusOneAnnualIntRate/100) + " - " + intRateRangePecrentageFmt.format
        (plusOneAnnualIntRate/100) + "\n" + 
        "******************************" +"\n");
        
        // Second String
        // taglines for the data displayed below it
        String s2 = ("Interest Rate\t\tMonthly Payment\t\tTotal Payment" 
        + "\t\t$ Overpayment\t\t% Overpayment" +"\n");
        
        // Data for the -1 interest rate iteration
        String s3 = (minusOneAnnualIntRate + "%\t\t\t\t" + dollarFmt.format
        (minusOneMonthlyPayment) + ""
                + "\t\t\t\t" + dollarFmt.format
        ((minusOneMonthlyPayment * 12 * yearsHeld)) + "\t\t" + dollarFmt.format
        (((minusOneMonthlyPayment * 12 * yearsHeld) - moneyBorrowed))+"\t\t\t\t" 
        + percentageFmt.format((((minusOneMonthlyPayment * 12 * yearsHeld) 
        - moneyBorrowed) / moneyBorrowed)) +"\n");
        
        // Data for the -0.5 interest rate iteration
        String s4 = (minusPointFiveAnnualIntRate + "%\t\t\t\t" + 
        dollarFmt.format(minusPointFiveMonthlyPayment) + "\t\t\t\t" + 
        dollarFmt.format((minusPointFiveMonthlyPayment * 12 * yearsHeld)) + 
        "\t\t" + dollarFmt.format(((minusPointFiveMonthlyPayment * 12 * 
        yearsHeld)) - moneyBorrowed) + "\t\t\t\t" + percentageFmt.format
        ((((minusPointFiveMonthlyPayment * 12 * yearsHeld) - moneyBorrowed) 
        / moneyBorrowed)) +"\n");
        
        // Data for the normal iteration
        String s5 = (annualIntRate + "%\t\t\t\t" + dollarFmt.format
        (monthlyPayment) + "\t\t\t\t" + dollarFmt.format
        ((monthlyPayment * 12 * yearsHeld)) + "\t\t" + dollarFmt.format
        (((monthlyPayment * 12 * yearsHeld) - moneyBorrowed)) + "\t\t\t\t" 
        + percentageFmt.format((((monthlyPayment * 12 * yearsHeld) 
        - moneyBorrowed) / moneyBorrowed)) +"\n");
        
        // Data for the +0.5 interest rate iteration
        String s6 = (plusPointFiveAnnualIntRate + "%\t\t\t\t" + 
        dollarFmt.format(plusPointFiveMonthlyPayment) + "\t\t\t\t" + 
        dollarFmt.format((plusPointFiveMonthlyPayment * 12 * yearsHeld)) + 
        "\t\t" + dollarFmt.format(((plusPointFiveMonthlyPayment * 12 *yearsHeld) 
        - moneyBorrowed)) + "\t\t\t\t" + percentageFmt.format
        ((((plusPointFiveMonthlyPayment * 12 * yearsHeld) - moneyBorrowed) 
        / moneyBorrowed)) +"\n");
        
        // Data for the +1 interest rate iteration
        String s7 = (plusOneAnnualIntRate + "%\t\t\t\t" + dollarFmt.format
        (plusOneMonthlyPayment) + "\t\t\t\t" + dollarFmt.format
        ((plusOneMonthlyPayment * 12 * yearsHeld)) + "\t\t" + dollarFmt.format
        (((plusOneMonthlyPayment * 12 * yearsHeld) - moneyBorrowed))+"\t\t\t\t" 
        + percentageFmt.format((((plusOneMonthlyPayment * 12 * yearsHeld) 
        - moneyBorrowed) / moneyBorrowed)) +"\n");
        
        // Sets the output (Contais all of the data) (seen in the GridPane) 
        // by combining all of the above 7 Strings.
        output.setText(s1 + s2 + s3 + s4 + s5 + s6 + s7);
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
