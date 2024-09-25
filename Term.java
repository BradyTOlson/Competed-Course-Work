//Brady Olson
//10/15/23
//This is the term class that functions as a node in the linked list of polynomials 
//each node of the list a term of the polynomial 
package ilstu.edu;

public class Term {
	//coefficient variable that acts as the coefficient of the term
	private int coefficient = 0;
	
	//exponent term the variable that acts as an exponent for the term
	private int exponent = 0;
	
	
	/**
	 * a constructor that creates a term object and initializes the variables coefficient and exponent
	 * 
	 * @param coefficient the variable that acts as the coefficient of the term
	 * @param exponent the variable that acts as an exponent for the term
	 */
	public Term(int coefficient, int exponent)
	{
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
	
	/**
	 * default term constructor that does not take any parameters or return anything
	 */
	public Term()
	{
		
	}
	
	/**
	 * getter for coefficients that returns the coefficient 
	 * 
	 * @return coefficient variable that acts as the coefficient of the term
	 */
	public int getCoefficient() {
		
		return coefficient;
		
	}
	
	/**getter for exponents that returns the variable exponent 
	 * @return exponent the variable that acts as an exponent for the term
	 */
	public int getExponent() {
		
		return exponent;
		
	}
	
	/**
	 *a toString method that returns a String formatted in a proper manner to fit 
	 *the criteria and look good
	 */
	public String toString()
	{
		String toString = coefficient + "x^" + exponent;
		if(exponent == 0)
		{
			toString = "" + coefficient;
		}
		return toString;
	}
	
	/**addTerm method that returns the sum of the calling object of 
	 * type term and the intake object of type term 
	 * @param poly a term object that gets added to the calling 
	 * object and returned as an object of type term 
	 * @return an object of type term that is the sum of the calling object and intake object
	 */
	public Term addTerm(Term poly)
	{
		Term temp = new Term();
		if(this.exponent == poly.getExponent())
		{
			temp.setCoefficient(this.coefficient + poly.getCoefficient());
			temp.setExponent(poly.getExponent());
			return temp;
			
		}
		return null;
	}

	/**setter for coefficients that sets the coefficient to the parameter int 
	 * @param coefficient variable that acts as the coefficient of the term
	 */
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	/**setter for exponents that sets the coefficient to the parameter int
	 * @param exponent term the variable that acts as an exponent for the term
	 */
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
}
