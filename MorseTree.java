package ilstu.edu;

import java.io.Serializable;
import java.util.InputMismatchException;

public class MorseTree<E> implements Serializable {

	protected class Node<E> implements Serializable {
		
		protected Node<E> left;
		protected Node<E> right;
		protected E data;
		
		public Node(E data)
		{
			this.data = data;
			left = null;
			right = null;
		}
		public Node()
		{
			left = null;
			right = null;
		}
		
	}
	
	public Node root;
	
	MorseTree(E data, MorseTree<E> leftTree, MorseTree<E> rightTree)
	{
		root = new Node<>(data);
		
		root.left = leftTree.root;
		root.right = rightTree.root;
	}
	
	MorseTree()
	{
		root = new Node("");
	}
	
	public void inorder(Node<E> root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }
	
	
	protected boolean addReturn(E morseCode, E letter)
	{
		String morse = (String) morseCode;
		Node temp = new Node(letter);
		
		if(root == null)
		{
			root = temp;
			return false;
		}else
		{
			add(morseCode, root, 0, letter);
		}
		 
		return true;
	}
	
	 protected Node<E> add(E data, Node <E> startRoot, int length,E letter)
	{
		String morse = (String) data;
		Node <E> curr = new Node<E>();
		curr = startRoot;
		boolean addReturn = false;
		
		 if (length == morse.length()) {
	           return curr;
	            
		 }
		try {
			
			if(morse.charAt(length)==('-'))
			{
				if(curr.right == null)
				{
					curr.right = new Node<E>((E) "");
				}
				startRoot.left = add(data, curr.right, length+1,letter);
				return root;
			}else {
				if(curr.left == null)
				{
					curr.left = new Node<E>((E) "");
				}
			Node<E> temp =  new Node<E>();
			startRoot.left = new Node<E>(letter);
			temp = add(data, curr.left,length+1,letter);
			return startRoot;
			}
			
		}catch(Exception e)
		{
			if(morse.charAt(length-1)==('-'))
			{
				curr.right = new Node<E>(letter); 
				return curr.right;
			}
			if(morse.charAt(length-1)==('.'))
			{
				curr.left = new Node<E>(letter); 
				return curr.left;
			}
			
		}
		return null;
		
	}
	
	public boolean decodeReturn(String item)
	{
		String morse = (String) item;
		System.out.println( decode((E) item, root, 0));
		return true;
			
	}
	public E decode(E item, Node <E> start, int x)
	{
		String morse = (String) item;
		if(x == morse.length())
		{
			return start.data;
		}
		
		try {
			
				if(morse.charAt(x)==('-'))
				{
					return decode(item, start.right, x+1);
				}
				if(morse.charAt(x)==('.'))
				{
					return decode(item, start.left, x+1);
				}
		}catch(IndexOutOfBoundsException e)
		{
		
			return start.data;
		}
		return null;
		
	}

}
