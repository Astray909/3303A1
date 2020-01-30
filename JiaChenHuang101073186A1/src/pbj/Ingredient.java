package pbj;
/**
 * Ingredient class to create ingredient objects
 * @author Jia Chen Huang
 * @version Jan 20, 2020
 *
 */
public class Ingredient {
	private String name;

	/**
	 * builds a ingredient object, has a name
	 * @param name: name of the ingredient
	 */
	public Ingredient(String name) {
		this.name = name;
	}

	/**
	 * getter method, returns the name of the ingredient
	 * @return return name of the food
	 */
	public String getName() {
		return name;
	}
}
