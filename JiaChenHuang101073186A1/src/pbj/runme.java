package pbj;
import java.util.Scanner;
/**
 * the main class, to test and run the program
 * @author Jia Chen Huang
 * @version Jan 20 2020
 *
 */
public class runme {

	/**
	 * main functions: creates threads for chefs, angent, and the table
	 * @param args
	 */
	public static void main(String[] args) {

		//create threads for agent and three chefs
		Thread chefOne, chefTwo, chefThree, agent;
		
		/**
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of iterations you desire: ");
		int itr = input.nextInt();
		System.out.println(itr + " sandwich will be made and eaten.\n");
		*/
		//sets the number of sandwiches made, if want user configurable iterations, enable the grayed out code above
		Table table = new Table(20);//runs the program 20 times
		//Table table = new Table(itr);//runs the program as configurable
		
		System.out.println("20 sandwiches will be made and eaten\n");
		
		//initializes threads for chefs and agent
		agent = new Thread(new Agent(table), "The Agent");

		chefOne = new Thread(new chef(table), "Chef One");
		chefTwo = new Thread(new chef(table), "Chef Two");
		chefThree = new Thread(new chef(table), "Chef Three");
		
		//start the threads
		agent.start();

		chefOne.start();
		chefTwo.start();
		chefThree.start();
	}

}
