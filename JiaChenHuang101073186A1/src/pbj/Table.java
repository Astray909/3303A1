package pbj;

import java.util.*;
/**
 * Table class, create a table for ingredients to sit on
 * @author Jia Chen Huang
 * @version Jan 20, 2020
 *
 */
public class Table {

	//set status for chefs
	boolean chefOneEat = false;
	boolean chefTwoEat = false;
	boolean chefThreeEat = false;
	//create ingredient objects
	private Ingredient bread = new Ingredient("bread");
	private Ingredient peanutbutter = new Ingredient("peanutbutter");
	private Ingredient jam = new Ingredient("jam");
	//create necessary things
	private String ingredOnTable = "";
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient> ();
	
	//sets the number of times this program will run
	private int count = 1;
	private int iteration;

	/**
	 * constructor for table, configures the amount of iterations
	 * @param itr: number of iterations
	 */
	public Table(int itr)
	{
		iteration = itr;
	}

	/**
	 * appoint a chef with the remaining ingredient to make and eat a sandwich
	 * @param i: object to be put by the agent
	 */
	public synchronized void appoint(int i) {
		while (notEmpty() || !(count != iteration+1)) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		//sets up ingredient table, and put corresponding ingredients out
		buildIngred();
		putIngred(i);
		System.out.println(Thread.currentThread().getName() + " has put" + ingredOnTable + " on the table");
		notifyAll();//notifies all threads
	}

	/**
	 * determines if there is ingredient on the table, if there are, then assign corresponding chef to be able to eat
	 * @return true when not empty, false when empty
	 */
	public boolean notEmpty() {
		if (ingredients.contains(bread) && ingredients.contains(peanutbutter)) {
			chefThreeEat = true;
			return true;
		}
		if (ingredients.contains(bread) && ingredients.contains(jam)) {
			chefTwoEat = true;
			return true;
		}
		if (ingredients.contains(peanutbutter) && ingredients.contains(jam)) {
			chefOneEat = true;
			return true;
		}
		return false;
	}

	public void buildIngred()
	{
		//ingredients.clear();
		ingredients.add(bread);
		ingredients.add(peanutbutter);
		ingredients.add(jam);
	}

	/**
	 * put specified ingredient on the table
	 * @param i: index for specific ingredient
	 */
	private void putIngred(int i) {
		if (i == 1) {
			ingredients.remove(bread);
			ingredOnTable = " peanut butter and jam";
		}
		if (i == 2) {
			ingredients.remove(peanutbutter);
			ingredOnTable = " bread and jam";
		}
		if (i == 3) {
			ingredients.remove(jam);
			ingredOnTable = " bread and peanut butter";
		}
	}

	/**
	 * test to see if chefOne can eat, if they can, then eat
	 */
	public synchronized void chefOneEat() {
		while (!notEmpty() || !chefOneEat) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		eat();
	}

	/**
	 * test to see if chefTwo can eat, if they can, then eat
	 */
	public synchronized void chefTwoEat() {
		while (!notEmpty() || !chefTwoEat) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		eat();
	}

	/**
	 * test to see if chefThree can eat, if they can, then eat
	 */
	public synchronized void chefThreeEat() {
		while (!notEmpty() || !chefThreeEat) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		eat();
	}
	
	/**
	 * eat method: prints the current thread that made and ate the sandwich,
	 * increment counter and resets table, notifies all threads
	 */
	private void eat()
	{
		System.out.println(Thread.currentThread().getName() + " made and ate sandwich number " + count + "\n");
		count++;
		resetTable();
		notifyAll();
	}

	/**
	 * resets the table for the next run
	 */
	public void resetTable() {
		chefOneEat = false;
		chefTwoEat = false;
		chefThreeEat = false;
		ingredients.clear();
	}

}
