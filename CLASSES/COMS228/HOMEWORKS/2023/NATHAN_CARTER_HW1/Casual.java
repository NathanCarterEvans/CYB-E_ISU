package edu.iastate.cs228.hw1;

/**
 * @author Nathan Carter
 */
public class Casual extends TownCell {

	public Casual (Town p, int r, int c) {
		super(p,r,c);
	}
	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
	    int[] nCensus = performCensus();
	    decrementCasualCount(nCensus);

	    if (isEmptyOrOutage(nCensus)) {
	        return new Reseller(tNew, row, col);
	    } else if (hasResellers(nCensus)) {
	        return new Outage(tNew, row, col);
	    } else if (hasStreamers(nCensus) || isCasualAboveThreshold(nCensus)) {
	        return new Streamer(tNew, row, col);
	    } else {
	        return new Casual(tNew, row, col);
	    }
	}

	private int[] performCensus() {
	    int[] censusData = new int[NUM_CELL_TYPE];
	    census(censusData);
	    return censusData;
	}

	private void decrementCasualCount(int[] nCensus) {
	    nCensus[CASUAL]--;
	}

	private boolean isEmptyOrOutage(int[] nCensus) {
	    return nCensus[EMPTY] + nCensus[OUTAGE] <= 1;
	}

	private boolean hasResellers(int[] nCensus) {
	    return nCensus[RESELLER] > 0;
	}

	private boolean hasStreamers(int[] nCensus) {
	    return nCensus[STREAMER] > 0;
	}

	private boolean isCasualAboveThreshold(int[] nCensus) {
	    return nCensus[CASUAL] >= 5;
	}


}