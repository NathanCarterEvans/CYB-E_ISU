package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Nathan Carter
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
		/*
		 * Psudo Psudo 
		 * for(row){ 
		 * 	for(col){ 
		 * 		tNew[row][col] = tOld[row][col].next();
		 */

		for (int row = 0; row < tOld.getLength(); row++) {
			for (int col = 0; col < tOld.getWidth(); col++) {
				tNew.grid[row][col] = tOld.grid[row][col].next(tNew);
			}
		}

		return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return profit
	 */
	public static int getProfit(Town town) {
		/*
		 * PSUDO PSUDO
		 * 
		 * Local Vars profit =0; Town
		 * 
		 * for(row){ 
		 * 	for(col){ 
		 * 		if(town[row][col] == CASUAL){
		 * 		 profit += 1; 
		 * 		} 
		 * return Profit;
		 */
		// Local Vars
		int profit = 0;

		// spent a good 2ish hours because I had == and no .equals()
		for (int i = 0; i < town.getWidth(); i++) {
			for (int j = 0; j < town.getLength(); j++) {
				if (town.grid[i][j].who().equals(State.CASUAL)) {
					profit++;
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

		/*
		 * Psudo Psudo LOCAL VARS Total_profit; Town;
		 * 
		 * Section ASK 
		 * Ask user to choose 1 or 2 
		 * if(1){ 
		 * read(input.txt); 
		 * }else if(2){
		 * Gen_rand(); 
		 * }else{ '
		 * loop while prompting invalid number; 
		 * }
		 * 
		 * Section Run 
		 * Total_profit = getProfit;//init local Var // RM if builling cycle not syncing
		 * 
		 * for(12){ 
		 * updatePlain(Town); 
		 * Total_profit += getProfit; 
		 * }
		 * 
		 * print(profit inperctenage);
		 */
		Scanner s = new Scanner(System.in);
	    Town town;

	    // Prompt user to choose option
	    System.out.println("Enter 1 to input a file");
	    System.out.println("Enter 2 to Randomly generate a grid");
	    int option = s.nextInt();

	    if (option == 1) {
	        System.out.println("Enter filename");
	        s.nextLine(); // yum the new line
	        String filename = s.nextLine();
	        
	        try {
	            town = new Town(filename);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            s.close();
	            return;
	        }
	    } else if (option == 2) {
	        System.out.println("Provide rows, cols, and seed integer separated by spaces:");
	        int length = s.nextInt();
	        int width = s.nextInt();
	        int seed = s.nextInt();
	        
	        town = new Town(length, width);
	        town.randomInit(seed);
	    } else {
	        System.out.println("Invalid option selected. Exiting now.");
	        s.close();
	        return;
	    }

	    // Compute and print profit over 12 iterations
	    int profit = 0;
	    for (int i = 0; i < 12; i++) {
	        System.out.print(town.toString() + "\n");
	        profit = getProfit(town);
	        System.out.println("Profit: " + profit);
	        town = updatePlain(town);
	    }

	    // Calculate profit percentage
	    int potential = town.getLength() * town.getWidth();
	    double percent = (double) profit * 100 / potential;
	    System.out.println("Profit %: " + percent);

	    s.close();
	}
}
