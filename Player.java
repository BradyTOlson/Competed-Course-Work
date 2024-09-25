package ilstu.edu;

import java.util.Stack;

import ilstu.edu.Game.Card;

public class Player {

	public Card[] cards;
	public String playerName;
	int playerCount;
	
	public Player(String playerName, Card[] initialCard )
	{
		this.playerName = playerName;
		
		this.cards = initialCard;
	}
	
	public boolean cardDecider(Stack<Card> faceUp)
	{
		if(winByAdditionFU(faceUp) || winBySuitFU(faceUp))
		{
			return true;
		}
		return false;
	}	
	
	
	public void drawCard(Stack<Card> faceUp, Stack<Card> faceDown)
	{
		int totalSum = 0;
		int spade = 0, club = 0, heart = 0, diamond = 0;
		
		if(cardDecider(faceUp))
		{
			for(int i = 0; i < cards.length; i++)
			{
			totalSum += this.cards[i].cardVal;
			
			
			}
			for(int i = 0; i < cards.length; i++)
			{
				if((totalSum - this.cards[i].cardVal) + faceUp.peek().cardVal == 23)
				{
					this.cards[i] = faceUp.pop();
					
				}
				if(this.cards[i].suit.equals("Heart"))
				{
					heart++;
				}else if(this.cards[i].suit.equals("Diamond"))
				{
					diamond++;
				}else if(this.cards[i].suit.equals("Club"))
				{
					club++;
				}else
				{
					spade++;
				}
				
			}
			if(heart>2 && faceUp.peek().suit.equals("Heart"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Heart"))
					{
						this.cards[i] = faceUp.pop();
					}
				
				}
			}if(diamond>2 && faceUp.peek().suit.equals("Diamond"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Diamond"))
					{
						this.cards[i] = faceUp.pop();
					}
					
				}
			}if(club>2 && faceUp.peek().suit.equals("Club"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Club"))
					{
						this.cards[i] = faceUp.pop();
					}
				
				}
			}if(spade>2 && faceUp.peek().suit.equals("Spade"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Spadet"))
					{
						this.cards[i] = faceUp.pop();
					}
				
				}
				
			}
		}
		else
		{
			for(int i = 0; i < cards.length; i++)
			{
			totalSum += this.cards[i].cardVal;
			
			
			}
			for(int i = 0; i < cards.length; i++)
			{
				if((totalSum - this.cards[i].cardVal) + faceDown.peek().cardVal == 23)
				{
					this.cards[i] = faceDown.pop();
					
				}
				if(this.cards[i].suit.equals("Heart"))
				{
					heart++;
				}else if(this.cards[i].suit.equals("Diamond"))
				{
					diamond++;
				}else if(this.cards[i].suit.equals("Club"))
				{
					club++;
				}else
				{
					spade++;
				}
				
			}
			if(heart>2 && faceDown.peek().suit.equals("Heart"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Heart"))
					{
						this.cards[i] = faceDown.pop();
					}
				
				}
			}if(diamond>2 && faceUp.peek().suit.equals("Diamond"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Diamond"))
					{
						this.cards[i] = faceDown.pop();
					}
					
				}
			}if(club>2 && faceDown.peek().suit.equals("Club"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Club"))
					{
						this.cards[i] = faceDown.pop();
					}
				
				}
			}if(spade>2 && faceDown.peek().suit.equals("Spade"))
			{
				for(int i = 0; i < cards.length;i++)
				{
					if(!this.cards[i].suit.equals("Spadet"))
					{
						this.cards[i] = faceDown.pop();
					}
				
				}
				
			}
		}
	}

	
	public void throwCard(Card card, Stack<Card> faceUp)
	{
		for(int i = 0; i < cards.length; i++)
		{
			if(cards[i].equals(card))
			{
				faceUp.push(cards[i]);
				cards[i] = null;
			}
		}
	}
	
	public boolean winByAdditionFU(Stack<Card> faceUp)
	{
		int totalSum = 0;
		int spade = 0, club = 0, heart = 0, diamond = 0;
		for(int i = 0; i < this.cards.length; i++)
		{
		totalSum += this.cards[i].cardVal;
		
		
		}
		for(int i = 0; i < cards.length; i++)
		{
			if((totalSum - this.cards[i].cardVal) + faceUp.peek().cardVal == 23)
			{
				this.cards[i] = faceUp.pop();
				return true;
	
			}	
		}
		return false;
	}
	
	public boolean winByAdditionFD(Stack<Card> faceDown)
	{
		int totalSum = 0;
		for(int i = 0; i < this.cards.length; i++)
		{
		totalSum += this.cards[i].cardVal;
		
		
		}
		for(int i = 0; i < cards.length; i++)
		{
			if((totalSum - this.cards[i].cardVal) + faceDown.peek().cardVal == 23)
			{
				this.cards[i] = faceDown.pop();
				return true;
	
			}	
		}
		return false;
	}
	public boolean winBySuitFU(Stack<Card> faceUp)
	{
		int spade = 0, club = 0, heart = 0, diamond = 0;
		for(int i = 0; i < cards.length; i++)
		{
			
			if(this.cards[i].suit.equals("Heart"))
			{
				heart++;
			}else if(this.cards[i].suit.equals("Diamond"))
			{
				diamond++;
			}else if(this.cards[i].suit.equals("Club"))
			{
				club++;
			}else
			{
				spade++;
			}
			
		}
		if(heart>2 && faceUp.peek().suit.equals("Heart"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Heart"))
				{
					this.cards[i] = faceUp.pop();
				}
			
			}
		}if(diamond>2 && faceUp.peek().suit.equals("Diamond"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Diamond"))
				{
					this.cards[i] = faceUp.pop();
				}
				
			}
		}if(club>2 && faceUp.peek().suit.equals("Club"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Club"))
				{
					this.cards[i] = faceUp.pop();
				}
			
			}
		}if(spade>2 && faceUp.peek().suit.equals("Spade"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Spadet"))
				{
					this.cards[i] = faceUp.pop();
				}
			
			}
			
		}
		return false;
	}
	public boolean winBySuitFD(Stack<Card> faceDown)
	{
		int spade = 0, club = 0, heart = 0, diamond = 0;
		for(int i = 0; i < cards.length; i++)
		{
			
			if(this.cards[i].suit.equals("Heart"))
			{
				heart++;
			}else if(this.cards[i].suit.equals("Diamond"))
			{
				diamond++;
			}else if(this.cards[i].suit.equals("Club"))
			{
				club++;
			}else
			{
				spade++;
			}
			
		}
		if(heart>2 && faceDown.peek().suit.equals("Heart"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Heart"))
				{
					this.cards[i] = faceDown.pop();
				}
			
			}
		}if(diamond>2 && faceDown.peek().suit.equals("Diamond"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Diamond"))
				{
					this.cards[i] = faceDown.pop();
				}
				
			}
		}if(club>2 && faceDown.peek().suit.equals("Club"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Club"))
				{
					this.cards[i] = faceDown.pop();
				}
			
			}
		}if(spade>2 && faceDown.peek().suit.equals("Spade"))
		{
			for(int i = 0; i < cards.length;i++)
			{
				if(!this.cards[i].suit.equals("Spadet"))
				{
					this.cards[i] = faceDown.pop();
				}
			
			}
			
		}
		return false;
	}
}		
	
		

