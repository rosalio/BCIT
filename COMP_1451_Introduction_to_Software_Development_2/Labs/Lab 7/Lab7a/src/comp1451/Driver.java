/**
 * 
 */
package comp1451;

/**
 * @author A00937175
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnimalHotel animalHotel = new AnimalHotel();
		Cat cat1 = new Cat("AAA", 1, 10);
		Cat cat2 = new Cat("BBB", 2, 5);
		Dog dog1 = new Dog("CCC", 3, true);
		Dog dog2 = new Dog("DDD", 4, false);
		
		animalHotel.addAnimal(cat1);
		animalHotel.addAnimal(cat2);
		animalHotel.addAnimal(dog1);
		animalHotel.addAnimal(dog2);
		
		animalHotel.displayInfo();
	}
}
