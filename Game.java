package ilstu.edu;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game {
	class Card<E>
	{
		public int cardVal;
		public Card next;
		public Card prev;
		public String  suit;
		private int size = 0;
		
		public Card(int cardVal, Card<E> prev, String suit)
		{ 
			this.cardVal = cardVal;
			this.suit = suit;
			
		}
		
		
	}
	public class Player{
		private Card[] cardsHeld;
		private String name;
		
		public Player(String name, Card[] cardsHeld)
		{
			this.name = name;
			this.cardsHeld = cardsHeld;
		}
		
		public Player(String name)
		{
			this.name = name;
		}
		
	}
	
	public Stack<Card<Integer>> faceDown;
	public Stack<Card<Integer>> faceUp;
	public Queue<Player> playerQue;
	Scanner input = new Scanner(System.in);
	private Card<Integer> head;
	private Card<Integer> tail;
	
	Random numGen = new Random();
	
	
	public Game(String[] names)
	{
		playerQue = new LinkedList<Player>();
		for(int i = 0; i < names.length;i++)
		{
			playerQue.add(new Player(names[i]));
		}
		deckInitializer();
		
		shuffle();
		
	}
	
	public void deckInitializer()
	{
		Card<Integer> curr = new Card<Integer>(1, null, "Heart");
		
		head = curr;
		tail = curr;
		int count = 1;
		int suitNum = 0;
		
		for(int i = 0; i < 40; i++)
		{
			if(count >= 10)
				count = 1;
			suitNum = i / 10;
		
			curr = new Card<Integer>(count,tail,"");
			
			tail.next = curr;
			switch(suitNum)
			{
			case 0:
				curr.suit = "Diamond";
			case 1:
				curr.suit = "Heart";
			case 2:
				curr.suit = "Club";
			case 3:
				curr.suit = "Spade";
			}
			count++;
			tail = curr;
		}
	}
	

	
	public void shuffle()
	{
		int ranNum; 
		int count = 41;
		faceDown =  new Stack<Card<Integer>>();
		Card<Integer> curr;
		for(int i = 0; i < 40; i++)
		{
			curr = head;
			ranNum =numGen.nextInt(count);
			for(int j = 0; j < ranNum; j++)
			{
				curr = curr.next;
			}

			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			
			faceDown.push(curr);
			count--;
		}
	}
	public void gameSimulator()
	{
		Player curr = playerQue.peek();
		 while(!gameWon())
		 {
			 playerQue.peek().drawCard(faceUp, faceDown);
			 
		 }
	}
	
	public void deal(int playerCount)
	{
		for(int i = 0; i < playerCount*4; i++)
		{
			playerQue.peek().cardsHeld[i] = faceDown.pop();
			playerQue.offer(playerQue.poll());
		}
		
	}
	
	public boolean gameWon()
	{
		return false;
	}
	

}
