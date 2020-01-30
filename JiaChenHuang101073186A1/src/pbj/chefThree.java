package pbj;
/**
 * creats chef one who has bread
 * @author Jia Chen Huang
 * @version Jan 20, 2020
 *
 */
public class chefThree extends Thread {

	private Table table;
	/**
	 * creates chefThree object
	 * @param table
	 */
	public chefThree(Table table) {
		this.table = table;
	}

	/**
	 * runs when thread is called, invoke eat()
	 */
	public void run() {
		while (true) {
			table.chefThreeEat();

			try {
				Thread.sleep(700);//sleeps the thread for 700ms, so outputs will appear in a slower pace
			} catch (InterruptedException e) {}
		}
	}
}
