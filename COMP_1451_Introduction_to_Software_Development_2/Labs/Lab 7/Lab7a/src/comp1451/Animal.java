/**
 * 
 */
package comp1451;

/**
 * @author A00937175
 *
 */
public class Animal {

	private String name;
	private int ageInYears;

	/**
	 * @param name
	 * @param ageInYears
	 */
	public Animal(String name, int ageInYears) {
		super();
		this.name = name;
		this.ageInYears = ageInYears;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ageInYears
	 */
	public int getAgeInYears() {
		return ageInYears;
	}

	/**
	 * @param ageInYears the ageInYears to set
	 */
	public void setAgeInYears(int ageInYears) {
		this.ageInYears = ageInYears;
	}
	
	/**
	 * to string method
	 */
	public String toString() {
		return "name: " + name + "; age: " + ageInYears + " years;";
	}
}
