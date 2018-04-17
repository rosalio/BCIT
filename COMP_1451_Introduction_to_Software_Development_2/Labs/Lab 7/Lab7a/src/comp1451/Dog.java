/**
 * 
 */
package comp1451;

/**
 * @author A00937175
 *
 */
public class Dog extends Animal {

	private boolean chaseSquirrels;

	/**
	 * @param name
	 * @param ageInYears
	 */
	public Dog(String name, int ageInYears, boolean chaseSquirrels) {
		super(name, ageInYears);
		this.chaseSquirrels = chaseSquirrels;
	}

	/**
	 * @return the chaseSquirrels
	 */
	public boolean isChaseSquirrels() {
		return chaseSquirrels;
	}

	/**
	 * @param chaseSquirrels the chaseSquirrels to set
	 */
	public void setChaseSquirrels(boolean chaseSquirrels) {
		this.chaseSquirrels = chaseSquirrels;
	}
	
	/**
	 * to string method
	 */
	public String toString() {
		String str = "Dog Info --- " + super.toString();
		str += chaseSquirrels ? " It chases squirrels." : " It does not chase squirrels.";
		
		return str;
	}

}
