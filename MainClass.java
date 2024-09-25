//Brady Olson
//IT 179
//Shukri Abotteen
//Program04

package ilstu.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	public static void main(String args[])
	{
		//creating variables for later use in the code such as the repeat boolean for the try catch to stop any non integer numbers from being entered when prompted to give the player count.
		int playerCount = 0;
		Scanner input = new Scanner(System.in);
		boolean repeat = false;
		System.out.print("Welcome to Chutes and Ladders!"
				+ "\nHow many people will be playing today?\n");
		
		//do while to repeat the try/catch block to stop any unwanted inputs
		do
		{
			repeat = false;
			try {
		
				playerCount = input.nextInt();
				
			}catch(InputMismatchException e)
			{
				System.out.println("Please enter a number!");
				input.next();
				
				repeat = true;
			}
		}while(repeat == true);
		//creating the gameboard with the requested amount of players
		Game chutesNLadders = new Game(playerCount);
		//playing the game.
		chutesNLadders.play();
	}
}
