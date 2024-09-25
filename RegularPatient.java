//Brady Olson
//Shukri Abotteen
//IT179
//Program02
package ilstu.edu;

public class RegularPatient extends Patient{
	
	private String mainSymptom = "";
	
	
	

	/**a constructor that assembles the necessary data to create a regular patient object
	 * @param id patients id
	 * @param fName patients first name
	 * @param lName patients last name
	 * @param age patients age
	 * @param mainSymptom patients main symptom
	 */
	public RegularPatient(int id, String fName, String lName, int age, String mainSymptom)
		{
		super(id, fName, lName,age);
		this.mainSymptom = mainSymptom;
		}
	
	
	/**
	 *a treat method that takes the patients main symptom and then gives a treatment
	 *returns a string
	 */
	public String treat()
		{
			String treatment = "";
			if(mainSymptom.equalsIgnoreCase("coughing") || mainSymptom.equalsIgnoreCase("runny nose") 
				|| mainSymptom.equalsIgnoreCase("cough") || mainSymptom.equalsIgnoreCase("stuffy nose"))
			{
				treatment = "Amoxicillin";
			}else if(mainSymptom.equalsIgnoreCase("hypertension"))
			{
				treatment = "ACE inhibitors";
			}else
			{
				treatment = "IV Fluids";
			}
		
			return treatment;
			
		}
	
	/**
	 *a to string method that prints the patients necessary information
	 */
	public String toString()
	{
		String toString = "Id: " + super.getID()
			+ "\nFull Name: " + super.getfName() + " " + super.getlName()
			+ "\nAge: " + super.getAge() 
			+ "\nMain Symptom: " + mainSymptom
			+ "\nPCR Test: " + super.getPcr()
			+ "\nTreatment: " + treat();
		return toString;
	}

}
