//Brady Olson
//10/15/23
//The Polynomial class is the class that represents the polynomial as a whole it is 
//a big linked list where every node represents a singular term of the equation
package ilstu.edu;

import java.util.Scanner;

public class Polynomial {

	//if coefficients of 1 are explicitly stated so will exponents of 1 it only makes sense!!!!!!!!
	
	//Node class that represents each node of the linked list and holds a variable containing an 
	//object of type term and a pointer to the next node of the list
	private class Node
	{
		Term termData;
		Node next;

		
		/**default constructor for Node sets calling object to parameter object of type Term
		 * @param term an object that represents a term of a function and one node of the linked list
		 */
		public Node(Term term)
		{
			this.termData = term;
			next = null;
		}
	}
	//the head of a given linked list
	private Node termsHead;
	//the tail of a given linked list
	private Node termsTail;
	
	
	
	
	/**
	 * polynomial default constructor used to set termsHead and termsTail to null
	 */
	public Polynomial()
	{
		termsHead = null;
		termsTail = null;
	}
	
	/**Another polynomial constructor that has a parameter 
	 * of type string used to represent the polynomial
	 * it then breaks down the string into terms and inserts 
	 * those terms into the linked list to declare a polynomial
	 * 
	 * @param polynomial a linked list used to represent an entire 
	 * equation each node represents a term of the equation
	 */
	public Polynomial(String polynomial)
	{
		String signs = "";
		Scanner input = new Scanner(polynomial);
		int count = 0;
		while(input.hasNext())
		{
			
			String temp = input.next();
			if(count%2==0)
			{
				String [] tempArr = temp.split("[x^]");
				Term tempTerm = new Term();
				if(signs.equals("-")) 
				{
					if(tempArr.length<3)
					{
						tempTerm = new Term(-1*(Integer.parseInt(tempArr[0])),0);
						
					}else
					{
						tempTerm = new Term(-1*(Integer.parseInt(tempArr[0])),Integer.parseInt(tempArr[2]));
					}
				}else
				{
					if(tempArr.length<3)
					{
						tempTerm = new Term((Integer.parseInt(tempArr[0])),0);
						
					}else
					{
						tempTerm = new Term((Integer.parseInt(tempArr[0])),Integer.parseInt(tempArr[2]));
					}
				}
				this.addTermToPolynomial(tempTerm);
			
			}else
			{
				signs = temp;
			}
			count++;
			
		}
		
	}
	
	/** a method that takes an object of type term in the parameter 
	 * and then adds it to the end of the linked list if there is one 
	 * to add it to
	 * 
	 * @param term an object that represents one piece of a whole 
	 * polynomial represented by a linked list
	 */
	public void addTermToPolynomial(Term term)
	{
		Node temp = new Node(term);
		
		if(termsHead == null)
		{
			
			termsHead = temp;
			termsTail = temp;
		}else
		{
			
			termsTail.next = temp;
			termsTail = temp;
			
		}
		
	}
	
	/**a method that takes an object of type Polynomial in and returns an
	 *  object that is the sum of the calling object and of the parameter object
	 *  
	 * @param poly an object of type polynomial that represents the function as a whole 
	 * 
	 * @return an object of type polynomial that is the sum of the 
	 * calling object and the parameter object
	 */
	public Polynomial addPolynomial(Polynomial poly)
	{
		this.sorted();
		poly.sorted();
		Polynomial sum = new Polynomial();
		Node curr = sum.termsHead;
		Node temp1 = this.termsHead;
		Node temp2 = poly.termsHead;
		
		while(temp1 != null && temp2 != null)
		{
			if(temp1.termData.getExponent() > temp2.termData.getExponent())
			{
				sum.addTermToPolynomial(temp1.termData);
				temp1 = temp1.next;
			}else if(temp1.termData.getExponent() == temp2.termData.getExponent())
			{
				Term tempTerm = temp1.termData.addTerm(temp2.termData);
				if(tempTerm.getCoefficient() != 0)
				{
					sum.addTermToPolynomial(tempTerm);
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else
			{
				sum.addTermToPolynomial(temp2.termData);
				temp2 = temp2.next;
			}
			
		}
		if(temp1 != null)
		{
			sum.addTermToPolynomial(temp1.termData);
		}else if(temp2 != null)
		{
			sum.addTermToPolynomial(temp2.termData);
		}
		
		return sum;
	}



	/**
	 *a toString method that returns a string that is formatted adequately 
	 */
	@Override
	public String toString() 
	{
		String toString = "0";
		Node temp1 = termsHead;
		
		while(temp1 !=null)
		{
			
			if (temp1.next !=null) 
			{
				if (temp1.next.termData.getCoefficient() > 0) {
					toString += temp1.termData + " + ";
				} else {
					toString += temp1.termData + " ";
				} 
			}else
			{
				toString += temp1.termData;
			}
			temp1 = temp1.next;
		}
		
		return toString;
	}

	/**
	 * a private method that sorts the nodes in the linked list so that 
	 * when returned it provides all the terms in the polynomial in descending order 
	 */
	private void sorted()
	{
		Node curr = termsHead;
		Node index = null;
		
		Term temp;
		if(termsHead == null)
		{
			return;
		}else
		{
			while(curr != null)
			{
				index = curr.next;
				while(index != null)
				{
					if(curr.termData.getExponent() < index.termData.getExponent())
					{
						temp = curr.termData;
						curr.termData = index.termData;
						index.termData = temp;
					}
					index = index.next;
				}
				curr = curr.next;
			}
		}
		
	}	
	
}





