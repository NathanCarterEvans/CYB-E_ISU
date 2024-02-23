package HW1;

public class Empty extends TownCell {

	public Empty (Town p, int r, int c) {
		super(p,r,c);
	}
	
	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		//Conditions for change
		int nCensus[] = new int[NUM_CELL_TYPE]; 
		census(nCensus);
		nCensus[EMPTY]--;
		if (nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
				return new Reseller(tNew, row, col);
		}
		else
		{
			return new Casual(tNew, row, col);
		}
		
	}

}