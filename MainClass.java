//Brady Olson
//10/15/23
//The MainClass that is used to actually run the Polynomial 
//Adder it gives the code a platform to perform on
package ilstu.edu;

import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{	//
		Scanner input = new Scanner(System.in);
		String choice = "";
		String poly = "";
		
		System.out.println(" Welcome to the Polynomial Addition Program");
		
		//while loop that runs through the program and lets the user work the interface
		while(!(choice.equalsIgnoreCase("n")))
		{	
			
			//formatting for the rules and opening screen
			System.out.println("**************************************************");
			System.out.println("   ENTER THE POLYNOMIAL IN STANDARD FORMAT"
					+ "\n	     123x^123"
					+ "\n	ONLY USE VARIABLE 'X'"
					+ "\nEXPLICITLY DEFINE EXPONENTS AND COEFFICIENTS OF 1"
					+ "\n	EX: x SHOULD LOOK LIKE 1x^1");
					
			System.out.println("**************************************************\n\n");
			//prompting user to enter polynomials
			System.out.println("Please enter your first polynomial");
			poly = input.nextLine();
			
			Polynomial temp1 = new Polynomial(poly);
			
			System.out.println("Please enter your second polynomial");
			poly = input.nextLine();
			
			Polynomial temp2 = new Polynomial(poly);
			//adding the polynomials
			System.out.println("The sum is: " + temp1.addPolynomial(temp2));
			
			System.out.println("Would you like to add two more Polynomials? y/n");
			//do while to make sure the user enters only accepted values
			do
			{	
				choice = input.next();
				if(!(choice.equalsIgnoreCase("y")) && !(choice.equalsIgnoreCase("n")))
				{
					System.out.println("Enter a y or n");
				}
				
			}while(!(choice.equalsIgnoreCase("y")) && !(choice.equalsIgnoreCase("n")));
			
			input.nextLine();
		}
		System.out.println("Thank you for using the Polynomial Addition Program");
		
	}
}
