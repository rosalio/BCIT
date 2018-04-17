/**
 * 
 */
package comp1451;

/**
 * @author A00937175
 *
 */
public class Cat extends Animal {
	
	private int meowFrequencyPerMinute;

	/**
	 * @param name
	 * @param ageInYears
	 */
	public Cat(String name, int ageInYears, int meowFrequencyPerMinute) {
		super(name, ageInYears);
		this.meowFrequencyPerMinute = meowFrequencyPerMinute;
	}

	/**
	 * @return the meowFrequencyPerMinute
	 */
	public int getMeowFrequencyPerMinute() {
		return meowFrequencyPerMinute;
	}

	/**
	 * @param meowFrequencyPerMinute the meowFrequencyPerMinute to set
	 */
	public void setMeowFrequencyPerMinute(int meowFrequencyPerMinute) {
		this.meowFrequencyPerMinute = meowFrequencyPerMinute;
	}

	/**
	 * to string method
	 */
	public String toString() {
		return "Cat Info --- " + super.toString() + " meow frequency per minute: "
		+ meowFrequencyPerMinute;
	}
}
