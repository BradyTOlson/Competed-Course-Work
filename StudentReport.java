package ilstu.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class StudentReport {

	private String fileName = "";
	private double [][] grades;
	private String [] students; 
	private String [] gradedItems;
	private static final DecimalFormat round = new DecimalFormat("0.00");
	private boolean initialized = false;
	
	/**
	 * a default constructor used in the MainClass
	 */
	public StudentReport() 
	{
		
	}
	
	/**
	 * a getter that returns a boolean value to see if the arrays have been initialized
	 * 
	 * @return initialized
	 */
	public boolean getInitialized()
	{
		return initialized;
	}
	
	/**
	 * a studentReport constructor that initializes the arrays by running through the file given and filling out how many spots it will need to fill.
	 * 
	 * @param fileName
	 */
	public StudentReport(String fileName)
	{
		this.fileName = fileName;
		int rowCount = -1;
		int columnCount = -1;
		
		
		//try catch to catch errors when opening the document 
		try									   						
		{			
				
			String line = "";
			File f = new File(fileName);  						
			FileReader file = new FileReader(f);
			BufferedReader read = new BufferedReader(file);
			
			initialized = true;
			
			//while loop that runs through document submitted 
			while ((line = read.readLine())!=null)								
			{		
				
				
				Scanner input = new Scanner(line);
				input.useDelimiter(",");
			
			//if statement that avoids needless counting
				if(rowCount == 0)
				{
					while(input.hasNext())
					{
						columnCount++;
						input.next();
					}	
				}
				rowCount++;
			}
			gradedItems = new String[columnCount];
			students = new String[rowCount];
			grades = new double[rowCount][columnCount];
		} catch (FileNotFoundException ife)							
		{															
			System.out.println("Unable to open file.");				
							
		} catch (InputMismatchException misexc)						
		{															
			System.out.println("Invalid data type.");	
		} catch (IOException e) {
	
			e.printStackTrace();
		}

//		gradedItems = new String[columnCount];
//		students = new String[rowCount];
//		grades = new double[rowCount][columnCount];
		
	}
	
	/**
	 * a read file method that reads a grades file and stores the information in the arrays
	 */
	public void readFile()
	{	
		
		int count = 0;
		int lineNum = 0;
		
		//try catch that catches any errors when running through the program
		try									   						
		{			
				
			String line = "";
			File f = new File(fileName);  						
			FileReader file = new FileReader(f);
			BufferedReader read = new BufferedReader(file);
			
			//while loop that runs through the document given
			while ((line = read.readLine())!=null)								
			{	
				
				Scanner input = new Scanner(line);
				input.useDelimiter(",");
				//if statement that allows the students array to be filled in correctly
				if(lineNum !=0)
				{
					students[lineNum-1] = input.next();
				}else
				{
					input.next();
				}

				count = 0;
				//while loop that iterates through the individual items in each row
				while(input.hasNext())
				{
						
					if(lineNum == 0)
					{
						gradedItems[count] = input.next();
					}else
					{
						grades[lineNum-1][count] = input.nextDouble();
					}
						
						
					count++;
						
						
						
				}	
				lineNum++;
			}	
		} catch (FileNotFoundException ife)							
		{															
			System.out.println("Please enter a valid file name.");				
					
		} catch (InputMismatchException misexc)						
		{															
			System.out.println("Invalid data type.");	
		} catch (IOException e) {
	
			e.printStackTrace();
		}
			
		
	}
	
	/**
	 * a write file method that returns index so that in main class I can see 
	 * if the correct name was entered 
	 * 
	 * @param studentName
	 * @return index
	 */
	public int writeFile(String studentName)
	{
		int index = -1;
		
		for(int i = 0; i <students.length; i++)	
		{
			if(studentName.equalsIgnoreCase(students[i]))
			{
				index = i;
			}
		}
		
		//if statement that figures out of index is = -1
		if(index==-1)
		{
			return index;
		}
		 
		//try catch that catches any errors 
		try									   						
		{									   		
			
			PrintWriter outfile = new PrintWriter(new FileWriter(studentName + ".txt"));
			
			//for loop that runs through the questions array
			
			outfile.println(studentName + "'s Report Card");
			
			int sum = 0;
			
			for(int i = 0; i<gradedItems.length; i++)
			{
				sum += grades[index][i];
				outfile.println(gradedItems[i] + ": " + grades[index][i]);
				
			}
			
			//if statement that determines what letter grade is printed on the report card
			outfile.println("Total: " + sum);
			if(sum >= 90)
			{
				outfile.println("Letter Grade: A");
			}else if(sum >= 80)
			{
				outfile.println("Letter Grade: B");
			}else if(sum >= 70)
			{
				outfile.println("Letter Grade: C");
			}else if(sum >= 60)
			{
				outfile.println("Letter Grade: D");
			}else
			{
				outfile.println("Letter Grade: F");
			}
			
			
			
			outfile.close();
		} catch (FileNotFoundException ife)							
		{															
			System.out.println("Unable to open file.");				
			System.out.println("Closing the program.");				
		} catch (InputMismatchException misexc)						
		{															
				System.out.println("Invalid data type.");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The report card was made Successfully!");
		return index;
		
	}
	
		/**
		 * a method that prints the names of all known students
		 */
		public void printStudents()
		{
			for(int i = 0; i < students.length; i++)
			{
				System.out.println(students[i]);
			}
		}
		/**
		 * a method that prints the stats of all the students 
		 */
		public void printStats()
		{
			double sum = 0;
			double currentStudent = 0;
			double highestGrade = 0;
			double lowestGrade = 500;
			for(int i = 0; i < grades.length; i++)
			{
			
				
				currentStudent = 0;
				for(int j = 0; j < gradedItems.length; j++)
				{
					currentStudent += grades[i][j];
					sum += grades[i][j];
					
				}
				//decides which student has the highest grade in the class
				if(currentStudent>highestGrade)
				{
					highestGrade = currentStudent;
				}
				//decides which student has the lowest grade in the class
				if(currentStudent<lowestGrade)
				{
					lowestGrade = currentStudent;
				}
				
			}
			System.out.println("The class average is: " + round.format(sum/(students.length)));
			System.out.println("The lowest score was: " + lowestGrade);
			System.out.println("The highest score was: " + highestGrade);
		}
}

	

