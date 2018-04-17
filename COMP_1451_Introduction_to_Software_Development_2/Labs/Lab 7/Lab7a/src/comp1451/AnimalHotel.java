/**
 * 
 */
package comp1451;

import java.util.ArrayList;

/**
 * @author A00937175
 *
 */
public class AnimalHotel {
	
	private ArrayList<Animal> animals;

	/**
	 * Constructor
	 */
	public AnimalHotel() {
		animals = new ArrayList<Animal>();
	}

	/**
	 * Add animal to hotel
	 * @param theAnimal the animal to add
	 */
	public void addAnimal(Animal theAnimal) {
		if (theAnimal != null) {
			animals.add(theAnimal);
		}
	}
	
	/**
	 * display info of each animal in hotel
	 */
	public void displayInfo() {
		for (Animal theAnimal : animals) {
			System.out.println(theAnimal);
		}
	}
}
