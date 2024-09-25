//Brady Olson
//Shukri Abotteen
//IT179
//Program02
package ilstu.edu;

abstract class Patient {

	private int id = 0;
	private String fName = "";
	private String lName = "";
	private int age = 0;
	private boolean pcr = false;
	
	/** 
	 * gets all the necessary data to create a patient object
	 * @param id patients id
	 * @param fName patients first name
	 * @param lName patients last name
	 * @param age patients age
	 */
	public Patient(int id, String fName, String lName, int age)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		
	}
	
	/**
	 * a getter that retrieves the PCR results of a patient
	 * @return pcr
	 */
	public boolean getPcr()
	{
		return pcr;
	}
	
	/**
	 * set pcr that sets the pcr results for a patient
	 * @param pcr
	 */
	public void setPcr(boolean pcr)
	{
		this.pcr = pcr;
	}
	
	/**a getter for id that retrieves the patients id
	 * @return id
	 */
	public int getID()
	{
		return id;
	}
	
	/**a setter to set a patients id
	 * @param id
	 */
	public void setID(int id)
	{
		this.id = id;
	}

	/**a getter that gets the patients first name
	 * @return fname 
	 */
	public String getfName() {
		return fName;
	}

	/**a setter to set a patients first name
	 * @param fName
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**a getter for the patients last name
	 * @return lname
	 */
	public String getlName() {
		return lName;
	}

	/**a setter that sets the patients last name
	 * @param lName
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**a getter that gets the patients age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**a setter for the patients age 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**abstract treat method
	 * @return
	 */
	public abstract String treat();
	
	/**
	 *abstract toString method
	 */
	public abstract String toString();
	
	
}
