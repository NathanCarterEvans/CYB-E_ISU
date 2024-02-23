package edu.iastate.cs228.hw1;

/**
 * 
 * @author Nathan Carter
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		/* Psudo Psudo
		 * for(row){
		 * for(col){
		 * 
		 * calculate the bounds
		 * if 0 then 0 else row-1
		 * if 0 then 0 else col-1
		 * 
		 * loop through each cell in p.grid[bound][bound]
		 * count each elm using if else or switch statement+
		 *
		 * 
		 */
		int upperLimit = Math.max(0, row - 1);//row
		int lowerLimit = Math.min(plain.grid.length - 1, row + 1);//row
		int leftLimit = Math.max(0, col - 1);//col
		int rightLimit = Math.min(plain.grid.length - 1, col + 1);//col

		for (int i = lowerLimit; i >= upperLimit; i--) {
		    for (int j = rightLimit; j >= leftLimit; j--) {
		        State cellState = plain.grid[i][j].who();
		        
		        switch (cellState) {
		            case RESELLER:
		                nCensus[RESELLER]++;
		                break;
		            case EMPTY:
		                nCensus[EMPTY]++;
		                break;
		            case CASUAL:
		                nCensus[CASUAL]++;
		                break;
		            case OUTAGE:
		                nCensus[OUTAGE]++;
		                break;
		            case STREAMER:
		                nCensus[STREAMER]++;
		                break;
		            default:
		                // Handle unexpected state, if needed
		        }
		    }
		}


	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
