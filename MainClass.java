//Brady Olson
//Shukri Abotteen
//IT179
//Program02
package ilstu.edu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	//creating an array list that will be used in future code
	//creating a static arraylist to outside the class to be able to make a search List method
	static ArrayList<Patient> patientList = new ArrayList<Patient>();
	public static void main(String args[])
	{
		//creating variables to use in the mainclass code
		int choice = 0;
		String result = "";
		boolean repeat = false;
		String mainSymptom = "";
		String fName = "";
		String lName = "";
		String pcrResult = "";
		int age = 0;
		double temp = 0.0;
		int count = 0;
		int index = 0;
		int id = 0;
		//creating a patient regular patient object that can be used in mainclass code
		Patient temp3 = new RegularPatient(id, fName, lName, age, mainSymptom);
		//importing scanner
		Scanner input = new Scanner(System.in);
		
		
		//while loop that controls the code
		while(choice !=6)
			{
		
			//creating a do while loop that prompts the user to enter a number while the input is valid
			do
			{
				//creating the menu
				System.out.println("1. Admit a Patient"
						+ "\n2. Print Patient Information"
						+ "\n3. Submit a PCR Test Result"
						+ "\n4. Do Rounds"
						+ "\n5. Discharge Patient"
						+ "\n6. Exit");
				
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
			
			switch(choice)
			{
			case 1:
				//prompting user for information to admit a patient 
				System.out.println("Enter Patients First Name");
				fName = input.next();
				
				System.out.println("Enter Patients Last Name");
				lName = input.next();
				
				System.out.println("Enter Patients Age");
				//do while and try catch to catch any inputs that are not valid
				do {
					
					repeat=false;
					
					try {
						age = input.nextInt();
					} catch (InputMismatchException e) {
						// TODO Auto-generated catch block
						System.out.println("Enter a Valid Input.");
						input.next();
						repeat = true;
					} 
				} while (repeat == true);
				
				System.out.println("Is the patient PCR Positive or PCR Negative? ");
				
				do {
					result = input.next();
					
					if(!result.equalsIgnoreCase("Positive") 
							
							&& !result.equalsIgnoreCase("Negative"))
					{
						System.out.println("Please enter positive or negative.");
					}
				} while (!result.equalsIgnoreCase("Positive") 
						
						&& !result.equalsIgnoreCase("Negative"));
				
				if(result.equalsIgnoreCase("Positive"))
				{
					System.out.println("What is the Patients Temperature?");
					do {
						repeat = false;
						try {
							temp = input.nextDouble();
							
						} catch (InputMismatchException e) {
							// TODO Auto-generated catch block
							
							System.out.println("Enter a valid input");
							
							input.next();
							
							repeat=true;
						} 
					} while (repeat==true);
					
					temp3 = new Covid19Patient(count,fName,lName, age, temp);
					
				}else if(result.equalsIgnoreCase("Negative"))
				{
					System.out.println("What is the patients Main Symptom?");
					
					input.nextLine();
					
					mainSymptom = input.nextLine();
					//adding patient to the array list
					temp3 = new RegularPatient(count,fName,lName, age, mainSymptom);
				}
				
				System.out.println("Patient's ID: " + count);
				
				count++;
				
				patientList.add(temp3);
				
				
				break;
				
			case 2:
				//asking for patient id to print out the information 
				System.out.println("Please Enter the Patients ID");
				//do whole and try catch to catch any inputs that are not valid
				do {
					repeat=false;
					try {
						id = input.nextInt();
					} catch (InputMismatchException e) {
						// TODO Auto-generated catch block
						
						System.out.println("Enter a Valid Input.");
						
						input.next();
						
						repeat = true;
					} 
				} while (repeat==true);
				
				index = patientSearch(id);
				//if statement to catch to see if there is any patients admitted
				if(index<0)
				{
					System.out.println("Patient Not Found");
					break;
				}
				System.out.println(patientList.get(index));
				
				break;
				
			case 3:
				//prompting the user to enter id to submit a pcr test result
				System.out.println("Please Enter the Patients ID");
				
				//try catch and do while to catch any inputs that arent valid
				do {
					
					repeat=false;
					
					try {
						id = input.nextInt();
						
					} catch (InputMismatchException e) {
						// TODO Auto-generated catch block
						
						System.out.println("Enter a Valid Input.");
						
						input.next();
						
						repeat = true;
					} 
				} while (repeat==true);
				
				index = patientSearch(id);
				
				//if statement to make sure there is a patient 
				if(index<0)
				{
					System.out.println("Patient Not Found");
					break;
				}
				System.out.println("Is the test Postitive or Negative?");
				//do while to catch any mis inputs
				do {
					
					pcrResult = input.next();
					//if statement to take in the pcr test result
					if(!pcrResult.equalsIgnoreCase("positive")&&!pcrResult.equalsIgnoreCase("negative"))
					{
						System.out.println("Enter Positive or Negative!");
					}
					
				} while (!pcrResult.equalsIgnoreCase("positive")&&!pcrResult.equalsIgnoreCase("negative"));
				
				if(pcrResult.equalsIgnoreCase("positive"))
				{
					//asks the user to enter the patients temperature if the patient is pcr positive
					if(patientList.get(index) instanceof RegularPatient)
					{
						System.out.println("What is the patients Temperature?");
						//try catch and do while to catch any inputs that arent valid
						do {
							
							repeat = false;
							
							try {
								
								temp = input.nextDouble();
								
							} catch (InputMismatchException e) {
								// TODO Auto-generated catch block
								
								System.out.println("Enter a valid input");
								
								input.next();
								
								repeat=true;
							} 
						} while (repeat==true);
						
						System.out.println("Patient " + patientList.get(index).getID() + " is now a PCR positive patient.");
						
						//makes a new covid19 patient object that takes the data from the patient that got removed
						temp3 = new Covid19Patient(patientList.get(index).getID(),patientList.get(index).getfName(), patientList.get(index).getlName(),patientList.get(index).getAge(),temp);
						//removes the patient that was previously not a covid 19 patient
						patientList.remove(index);
						//adds the new covid 19 patient
						patientList.add(index, temp3);
					}	
				}else
				{	//if statement that discharges the covid 19 patient if they are no longer PCR positive
					if(patientList.get(index) instanceof Covid19Patient)
					{
						System.out.println("Your Patient will be discharged");
						
						patientList.remove(index);
					}
				}
				break;
				
			case 4: 
		
				//if statements that checks to see that there are patients in the hospital
				if (patientList.size()>0) {
					
					//variable that allows us to check that there are covid19patients in the hospital
					int pcrPatients = 0;
					
					//for loop that runs through patient list 
					for (Patient patient : patientList) {

						//if statement that checks to see if the patient is an instance of a covid19patient
						if (patient instanceof Covid19Patient) {
							
							System.out.println("Enter the temperature for patient " + patient.getID());
							
							//try catch and do while to catch any inputs that arent valid
							do {
								repeat = false;
								
								try {
									
									temp = input.nextDouble();
									
								} catch (InputMismatchException e) {
									// TODO Auto-generated catch block
									
									System.out.println("Enter a valid input");
									
									input.next();
									
									repeat = true;
								}
							} while (repeat == true);
							
							((Covid19Patient) patient).setTemp(temp);
							
							pcrPatients++;
						}

					}
					//checks to make sure there are covid19patients if not it tells the user no one in the hospital has covid19
					if(pcrPatients<1)
					{
						System.out.println("There are no PCR positive Patients in the hospital.");
					}
					//for loop that runs through the patientlist and prints the id and their treatment
					for (Patient patient : patientList) {
						
						System.out.println("Patient ID: " + patient.getID());
						
						System.out.println("Recommended Patient Treatment: " + patient.treat());
					} 
					//else statement that tells the user there are no patients in the hospital
				}else
				{
					System.out.println("There are no patients in this hospital");
				}
				break;
				
			case 5:
				//a discharge case that asks for the patients id 
				System.out.println("Enter the Patients ID");
				
				//try catch and do while to catch any inputs that arent valid
				do {
					repeat=false;
					
					try {
						
						id = input.nextInt();
						
					} catch (InputMismatchException e) {
						// TODO Auto-generated catch block
						
						System.out.println("Enter a Valid Input.");
						
						input.next();
						
						repeat = true;
					} 
				} while (repeat==true);
				
				index = patientSearch(id);
				
				if(index<0)
				{
					System.out.println("Patient Not Found");
					
					break;
				}
				if(patientList.get(index).getPcr() == false)
				{
					patientList.remove(index);
					
					System.out.println("The Patient has been Discharged.");
					
				}else
					System.out.println("The patient still has a positive PCR test therefore we cannot discharge them. Sorry for the inconvenience");
				
				break;
				
			case 6: 
				
				break;
				
			default: 
				System.out.println("Enter a valid number!");
				
				break;
			
			}
		}
	}
	
	//creating a patient search method that runs through the patient arraylist and finds the index at which the patient id is at
	//then returns the index or a -1 to signify no patient found
	public static int patientSearch(int id)
	{
		for(int i = 0; i<patientList.size(); i++)
		{
			
			if(id==patientList.get(i).getID())
			{
				return i;
			}
			
		}
		return -1;
	}
}	
