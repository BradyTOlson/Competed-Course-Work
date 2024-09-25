package ilstu.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	static MorseTree tree = new MorseTree();
	
	public static void buildTree()
	{
		String letter = "";
		String morse = "";
		
		
		//try catch to catch errors when opening the document 
		try									   						
		{			
				
			String line = "";
			Scanner input = new Scanner("Decoder.txt");				
			
			input.next();
			
			//while loop that runs through document submitted 
			while (input.hasNext())								
			{		
				
				tree.addReturn(input.next(),input.next());
				input.nextLine();
			
			}
		}  catch (InputMismatchException misexc)						
		{															
			System.out.println("Invalid data type.");	
		}
	}
	
	public static void decode(String s)
	{
		String [] morseCode = s.split(" ", 0);
		
		for(int i = 0; i < morseCode.length; i++)
		{
			System.out.println(tree.decodeReturn(morseCode[i]));
		}
	}
	
	
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		String code = "";
		buildTree();
		System.out.println("Please Enter an Encoded Message");
		
		code = input.next();
		
		System.out.println(tree.decodeReturn(code));
		
	}
}
