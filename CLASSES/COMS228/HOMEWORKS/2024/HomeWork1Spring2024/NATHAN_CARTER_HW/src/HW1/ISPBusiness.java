package HW1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author nccarter
 *
 *         The ISPBusiness class performs simulation over a grid plain with
 *         cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * 
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//for all, update
		for (int i = 0; i <= tOld.getLength() - 1; i++) {
			for (int j = 0; j <= tOld.getWidth() - 1; j++) {
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		// for all calculate profit
		for (int i = 0; i <= town.getLength() - 1; i++) {
			for (int j = 0; j <= town.getWidth() - 1; j++) {
				if (town.grid[i][j].who().equals(State.CASUAL)) {
					profit++; //add one if casual
				}
			}
		}
		return profit;
	}

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements
	 * of grid via an input file (option: 1) or wants to generate it randomly
	 * (option: 2).
	 * 
	 * Depending on the user choice, create the Town object using respective
	 * constructor and if user choice is to populate it randomly, then populate the
	 * grid here.
	 * 
	 * Finally: For 12 billing cycle calculate the profit and update town object
	 * (for each cycle). Print the final profit in terms of %. You should print the
	 * profit percentage with two digits after the decimal point: Example if profit
	 * is 35.5600004, your output should be:
	 *
	 * 35.56%
	 * 
	 * Note that this method does not throw any exception, so you need to handle all
	 * the exceptions in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // Create a Scanner object
		System.out.println("1:File");
		System.out.println("2:Random");
		int choose = s.nextInt(); // system.in
		Town town;
		
		// Read from file option
		if (choose == 1) {
			Scanner fileIn = new Scanner(System.in);
			System.out.println("Enter full filepath");
			String filePath = fileIn.nextLine();
			try {
				town = new Town(filePath); // make a new town
			} catch (FileNotFoundException e) {
				fileIn.close(); // if fail please close... no memory leaks here
				return;
			}

		} else if (choose == 2) {
			Scanner t = new Scanner(System.in);
			System.out.println("Length");
			int length = t.nextInt();
			System.out.println("Width");
			int width = t.nextInt();
			System.out.println("Seed");
			int seed = t.nextInt();
			// You can also scan Directly in the call but this is future proofing
			town = new Town(length, width);
			town.randomInit(seed);
			t.close();
		} else {
			System.out.println("Something Went Wrong."+choose+" Is not a valid option. Try again later.");
			return;
		}

		// MAIN LOOP
		int profit = 0;
		for (int i = 1; i <= 12; i++) { // reapeat 12 billing cycles
			// Print current town
			System.out.print(town.toString());
			System.out.print("\n");

			// UPDATE AND PRINT
			profit = getProfit(town); // GET 
			System.out.println("Profit: " + profit); // PRINT
			town = updatePlain(town); // UPDATE
		}
		
		// MATH
		int Theoretical = town.getLength() * town.getWidth();
		double pYield = (profit * 100) / Theoretical;
		System.out.println("Profit %: " + pYield); // Percient Yield
	}

}