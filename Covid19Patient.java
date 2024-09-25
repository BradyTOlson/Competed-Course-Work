//Brady Olson
//Shukri Abotteen
//IT179
//Program02
package ilstu.edu;

public class Covid19Patient extends Patient{
private double temperature = 0.0;

	/**
	 * a constructor for a covid19 patient 
	 * @param id patients id 
	 * @param fName patients first name
	 * @param lName patients last name
	 * @param age patients age 
	 * @param temp patients temperature
	 */
	public Covid19Patient(int id, String fName, String lName, int age, double temp)
		{
		super(id, fName, lName, age);
		temperature = temp;
		super.setPcr(true);
		}
	
	/**a get temp method that gives the patients temp
	 * @return temperature
	 */
	public double getTemp()
		{
			return temperature;
		}
	
	/**
	 * a set temp method that allows the user to set the patients temp
	 * @param temp
	 */
	public void setTemp(double temp)
		{
			temperature = temp;
		}
	
	/**
	 *a treatment method that takes the patients 
	 *main symptom and gives a treatment
	 *
	 *returns a string
	 */
	public String treat()
	{
		String treatment = "";
		if(temperature>40)
		{
			treatment = "Dexamethasone";
		}else if(temperature>36.5 && super.getAge()>59)
		{
			treatment = "Paxlovid";
		}else 
		{
			treatment = "Fluids and Acetaminophen";
		}
		
		return treatment;
	}
	
	/**
	 *a toString method that prints out the information for the patient
	 *
	 *returns a string
	 */
	public String toString()
	{
		String toString = "Id: " + super.getID()
			+ "\nFull Name: " + super.getfName() + " " + super.getlName()
			+ "\nAge: " + super.getAge() 
			+ "\nTemperature: " + temperature
			+ "\nPCR Test: " + super.getPcr()
			+ "\nTreatment: " + treat();
		return toString;
	}

}
