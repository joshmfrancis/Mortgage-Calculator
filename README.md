Created: 03/03/2022

This is a program that I wrote for an assignment with a partner, that I tweaked to be used as a GUI using JavaFX. 

This program asks for a loan amount, number of years the loan is held for, and the amount of money borrowed, and spits out a nice list of interest rates ranging from 1% below what was entered and 1% above what was entered in intervals of .5%, Then it calculates the monthly payment, total payment, overpayment in dollars, and overpayment in percent for the "5" interest rate. 

Here is a quick test of the program:
![image](https://user-images.githubusercontent.com/104415326/167321511-02f5cb17-382c-499d-88f9-255874c43757.png)

Use Cases:

- This program would be useful for implementing a UI that allows for a user to find out what they would be paying for a mortgage. 

Problems:

 - This program breaks when entering anything other than an a double or an integer. 
 - There are also some errors with the tab spacing in the output. 

Possible Work Arounds:

 - Check to see if the input in the textbox is a string. If it is then prompt the user to enter it again when you hit calculate it.
 - Use trial and error to figure out how to fix some of the tab spacing errors. 
