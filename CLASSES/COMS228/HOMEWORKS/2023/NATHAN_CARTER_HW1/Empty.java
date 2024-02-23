package edu.iastate.cs228.hw1;

/**
 * @author Nathan Carter
 * 
 */

public class Empty extends TownCell {

	public Empty(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		int[] censusData = collectCensus();
		decrementEmptyCount(censusData);

		return shouldCreateReseller(censusData) ? new Reseller(tNew, row, col) : new Casual(tNew, row, col);
	}

	private int[] collectCensus() {
		int[] censusData = new int[NUM_CELL_TYPE];
		census(censusData);
		return censusData;
	}

	private void decrementEmptyCount(int[] censusData) {
		censusData[EMPTY]--;
	}

	private boolean shouldCreateReseller(int[] censusData) {
		return censusData[EMPTY] + censusData[OUTAGE] <= 1;
	}

}