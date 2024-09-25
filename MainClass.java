package ilstu.edu;

import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		String fileName = "";
		String studentName = "";
		StudentReport students = new StudentReport();
		int choice = 0;
		Scanner input = new Scanner(System.in);
		
		
		//while loop that presents the user with a UI of choices
		while(choice !=5)
		{
			System.out.println("Enter 1 to process a class file: \n"
					+ "Enter 2 to print a list of all students: \n"
					+ "Enter 3 to generate a report card for a specific student: \n"
					+ "Enter 4 to display statistics: \n"
					+ "Enter 5 to Exit: \n");
			boolean repeat = false;
			//a do while loop that continuously repeats until the proper input is entered
			do
			{
				repeat = false;
				//a try catch that catches any misinputs
				try {
					choice = input.nextInt();
				} catch (Exception e) {
					System.out.println("Please enter a valid number!");
					input.next();
					repeat = true;
				}
			}while(repeat == true);
			//a switch statement that runs through the choices that are given
			switch(choice)
			{
			case 1:
				System.out.println("Enter the file name: ");
				fileName = input.next();
				students = new StudentReport(fileName);
				students.readFile();
				break;
				
			case 2:
				//if statement that makes sure the file has been inputted first
				if(students.getInitialized()==true)
				{
					students.printStudents();
				}else
					System.out.println("Please input the file first.");
				break;		
				
			case 3:
				//if statement that makes sure the file has been inputted first
				if(students.getInitialized()==true)
				{
					System.out.println("Enter the name of the student: ");
					input.nextLine();
					studentName = input.nextLine();
					//if statement that checks to make sure the students name is in the array
					if(students.writeFile(studentName)==-1)
					{
						System.out.println("This is an invalid Name. Check the name before submitting.");
					}
					
					
				}else
					System.out.println("Please input the file first.");
				break;
				
			case 4: 
				//if statement that makes sure the file has been inputted first
				if(students.getInitialized()==true)
				{
					students.printStats();
				}else
					System.out.println("Please input the file first.");
				break;
				
			case 5:
				
				break;
				//default case that makes sure a valid number is inputted
			default: 
				System.out.println("Enter a valid number!");
				break;
				
			}
			
		}
		
	
	}
}
 