package edu.iastate.cs228.hw1;
/**
 * @author Nathan Carter
 */
public class Streamer extends TownCell {

	public Streamer (Town p, int r, int c) {
		super(p,r,c);
	}

	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		int[] cellCounts = new int[NUM_CELL_TYPE];
		census(cellCounts);

		cellCounts[STREAMER]--;

		if (cellCounts[EMPTY] + cellCounts[OUTAGE] <= 1) {
		    return new Reseller(tNew, row, col);
		} 
		else if (cellCounts[RESELLER] > 0) {
		    return new Outage(tNew, row, col);
		} 
		else if (cellCounts[OUTAGE] > 0) {
		    return new Empty(tNew, row, col);
		} 
		else if (cellCounts[CASUAL] >= 5) {
		    return new Streamer(tNew, row, col);
		} 
		else {
		    return new Streamer(tNew, row, col);
		}

	}

}
