package pbj;

import java.util.*;
/**
 * java Class Agent, this class creates object that assigns which ingredients to use
 * @author Jia Chen Huang
 * @version Jan 20, 2020
 *
 */
public class Agent extends Thread {

	private Table table;

	/**
	 * builds agent object
	 * @param table
	 */
	public Agent(Table table) {
		this.table = table;
	}

	/**
	 * when the thread is run, a random number between 1 and 3 is generated, then call table's appoint
	 * function
	 */
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(700);//sleeps thread for 700ms, so outputs appear at a slower pace
			} catch (InterruptedException e) {
			}
			int rand = (int)(Math.random() * ((3 - 1) + 1)) + 1;//generate a random number between 1 and 3
			table.appoint(rand);//calls appoint method in table, put ingredients on table
		}
	}
}
