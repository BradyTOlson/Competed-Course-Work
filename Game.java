//Brady Olson
//IT 179
//Shukri Abotteen
//Program04

package ilstu.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Game {
	//Square class that acts as the Nodes of the Doubly Linked List
	static class Square<E>
	{
		
		public E jumpVal;
		public E squareNum;
		public Square<E> next;
		public Square<E> prev;
		
		//creating constructors to create each game square
		public Square(E squareNum, E jumpVal, Square<E> prev)
		{
			this.squareNum = squareNum;
			this.jumpVal = jumpVal;
			this.prev = prev;
			this.next = null;
			
		}
		//creating constructors to create each game square
		public Square(E squareNum, E jumpVal)
		{
			this.squareNum = squareNum;
			this.jumpVal = jumpVal;
			this.prev = null;
			this.next = null;
			
		}
		
	}
	//Creating square references for the start and end of the game board and other variables to aid in the creation of the game
	Square<Integer> start;
	Square<Integer> end;
	int currentPlayer = 0;
	ArrayList<Square<Integer>> players;
	
	
	/**game contructor that creates the gameboard and makes connections betweens the squares. assigns jump values to each square using a random number generator to give the chance
	 * of a jump or chute happening on a given square to 25%. creates an arraylist and fills it with the number of players. generates jumpvalue using random number generator
	 * with a max ladder or chute being +-25
	 * does not allow chutes or ladders to generate within 10 squares of start or end 
	 * @param playerCount
	 */
	public Game(int playerCount)
	{
		Random rand = new Random();
		players = new ArrayList<Square<Integer>>();
		Square<Integer> curr = new Square<Integer>(1,0);
		start = curr;
		end = curr;
		int jumpDecider = 0;
		
		for(int i = 2; i<101; i++)
		{
			end.next = curr;
			Square<Integer> temp = curr;
			
			jumpDecider = rand.nextInt(4);
			if(jumpDecider == 3)
			{
				if(curr.squareNum>90 || curr.squareNum<11)
				{
					curr = new Square<Integer>(i, 0, temp);
				}else 
				{ 	
					int jump = jumpCalculator(curr);
					curr = new Square<Integer>(i, jump,temp);
					
					
				}
				
			}else
			{
				curr = new Square<Integer>(i,0,temp);
			}
			
			end = temp;
		
			
			
		}
		for(int i = 0; i < playerCount;i++)
		{
			players.add(start);
			
		}
		
	}
	
	
	/** a method that moves the current player based on the number they received in the dice roll
	 * returns a boolean value to determine who wins the game
	 * @param currentPlayer takes in the current player that is rolling the dice 
	 * @param moves variable that is how much the player rolled with the dice
	 * @return boolean value that is used to determine who wins the game
	 */
	public boolean move(int currentPlayer, int moves)
	{
		if(players.get(currentPlayer).squareNum + moves >= 100)
		{
			return true;
		}
		
		for(int i = 0; i < moves; i++)
		{
			players.set(currentPlayer, players.get(currentPlayer).next);
			
		}
		if(players.get(currentPlayer).jumpVal > 0)
		{
			int jumper = players.get(currentPlayer).jumpVal;
			for(int i = 0; i < jumper; i++)
			{
				players.set(currentPlayer, players.get(currentPlayer).next);
			}
			System.out.println("Player " + (currentPlayer + 1) + " has landed on a ladder and advanced " + jumper + " squares!");
		}else if(players.get(currentPlayer).jumpVal < 0)
		{
			int jumper = players.get(currentPlayer).jumpVal;
			for(int i = jumper; i < 0; i++)
			{
				players.set(currentPlayer, players.get(currentPlayer).prev);
			}
			System.out.println("Player " + (currentPlayer + 1) + " has landed on a chute and regressed " + jumper + " squares!");
		}
		
		return false;
	}
	
	
	
	/**
	 * play method runs the game this is where the dice roll function is and the logic being who wins the game.
	 */
	public void play()
	{
		Random rand = new Random();
		int dice = 0;
		Scanner input = new Scanner(System.in);
		
		while(players.get(currentPlayer).squareNum!=(100))
		{
			System.out.println("	Player " + (currentPlayer + 1) + 
					"\nPress any key to roll the die!");
			input.next();
			dice = rand.nextInt((6-1)+1)+1;
			System.out.println("Player " + (currentPlayer + 1) + " has rolled a " + dice + "!");
			if(move(currentPlayer,dice) )
			{
				System.out.println("Player " + (currentPlayer + 1) + " has won the game! "
						+ "\n  Congratulations!");
				break;
			}
			System.out.println("Player " + (currentPlayer + 1) + " is at square " + players.get(currentPlayer).squareNum);
			currentPlayer++;
			if(currentPlayer >= players.size())
			{
				currentPlayer = 0;
			}
			
		}
	}
	
	/**a method i created to make the game constructor less crowded. this method is the logic behind the jump values and does not allow the players to jump outside the game. 
	 * also limits max chutes or ladders to +-25. 
	 * @param curr takes the current square of the gameboard and assigns it a jump value
	 * @return an integer value that is used as the jump value for that square
	 */
	public int jumpCalculator(Square<Integer> curr)
	{
		Random rand = new Random();
		boolean col = rand.nextBoolean();
		int randomPos = 0;
		int randomNeg = 0;
		int upper = 100 - curr.squareNum;
		int lower = curr.squareNum;
		if(col)
		{
			while(randomPos == 0)
			{
				randomPos = rand.nextInt(upper);
				if(upper>25 && randomPos>25)
				{
					randomPos = 0;
				}
				
			}
			return randomPos;
			
		}else
		{
			while(randomNeg == 0)
			{
				randomNeg = -1 * rand.nextInt(lower);
				if(lower>25 && randomNeg<-25)
				{
					randomNeg = 0;
				}
			}
			return randomNeg;
		}
		
		
	}
	
}
