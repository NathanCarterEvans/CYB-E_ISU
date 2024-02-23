package HW1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpecCheckerProto {
	
	
	
	
	@Test
	void TestTownMake() {
		// Setup
		Town t = new Town(2, 2);
        t.randomInit(5);
       
        //Test Length
        System.out.println("Testing town.getLength()\n");
        assertEquals(2, t.getLength());
        
        //Test Width
        System.out.println("Testing town.get.Width()\n");
        assertEquals(2, t.getWidth());
	}
	
	
	
	
	
	
	
	
	
	@Test
	void ResellerStay() {
		Town town = new Town(3, 3);
        //test Next
        //reset grid
        /*
         * C C C
         * E R C
         * S E S
         */
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Casual(town, 0, 1);
        town.grid[0][2] = new Casual(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1);
        town.grid[1][2] = new Casual(town, 1, 2);
        
        town.grid[2][0] = new Streamer(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Streamer(town, 2, 2);
        
        // Expecting the Reseller to remain as a Reseller based on the conditions
        System.out.println("Testing Reseller.next(), Stay with grid:\n"
        		+ "C C C\n"
        		+ "E R C\n"
        		+ "S E S\n");
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.RESELLER, nextCell.who());
	}
	
	
	
	
	
	
	
	
	@Test
	void ResellerEmpty1() {
		Town town = new Town(3, 3);
        // Test Next move empty1
        /*
         * E E E
         * C R C
         * C C C
         */
        
        System.out.println("Testing Reseller.next(), Empty1 with grid:\n"
        		+ "E E E\n"
        		+ "C R C\n"
        		+ "C C C\n");
        
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Casual(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1);
        town.grid[1][2] = new Casual(town, 1, 2);
        
        town.grid[2][0] = new Casual(town, 2, 0);
        town.grid[2][1] = new Casual(town, 2, 1);
        town.grid[2][2] = new Casual(town, 2, 2);
        
        //Expecting Reseller to turn empty due to 3 or more empty
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.EMPTY, nextCell.who());
	}
	
	
	
	
	
	
	
	
	@Test
	void ResellerEmpty2() {
		Town town = new Town(3, 3);
        // Test Next Move empty2
        /*
         * C S S
         * O R O
         * C C S
         */
        
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Streamer(town, 0, 1);
        town.grid[0][2] = new Streamer(town, 0, 2);
        
        town.grid[1][0] = new Outage(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1);
        town.grid[1][2] = new Outage(town, 1, 2);
        
        town.grid[2][0] = new Casual(town, 2, 0);
        town.grid[2][1] = new Casual(town, 2, 1);
        town.grid[2][2] = new Streamer(town, 2, 2);
        
        System.out.println("Testing Reseller.next(), Empty2 with grid:\n"
        		+ "C S S\n"
        		+ "O R O\n"
        		+ "C C S\n");
        
        //Expecting Reseller to turn empty due to 3 or less Casual
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.EMPTY, nextCell.who());
	}
	
	
	
	
	
	
	
	@Test
	void ResellerEmpty3() {
		Town town = new Town(5, 5);
		// Test Next Move empty2
        /* 0 1 2 3 4
         * C S S E R 0
         * O R O E E 1
         * C C S S S 2
         * S S E C C 3
         * S S C R C 4
         */
        
		System.out.println("Testing Reseller.next(), Empty3 with grid:\n"
        		+ "C S S E R\n"
        		+ "O R O E E\n"
        		+ "C C S S S\n"
        		+ "S S E C C\n"
        		+ "S S C R C\n");
		
		//0
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Streamer(town, 0, 1);
        town.grid[0][2] = new Streamer(town, 0, 2);
        town.grid[0][3] = new Empty(town, 0, 3);
        town.grid[0][4] = new Reseller(town, 0, 4); //RS2
        
        //1
        town.grid[1][0] = new Outage(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1); //RS1
        town.grid[1][2] = new Outage(town, 1, 2);
        town.grid[1][3] = new Empty(town, 1, 3);
        town.grid[1][4] = new Empty(town, 1, 4);
        
        //2
        town.grid[2][0] = new Casual(town, 2, 0);
        town.grid[2][1] = new Casual(town, 2, 1);
        town.grid[2][2] = new Streamer(town, 2, 2);
        town.grid[2][4] = new Streamer(town, 2, 3);
        town.grid[2][3] = new Streamer(town, 2, 4);
        
        //3
        town.grid[3][0] = new Streamer(town, 3, 0);
        town.grid[3][1] = new Streamer(town, 3, 1);
        town.grid[3][2] = new Empty(town, 3, 2);
        town.grid[3][4] = new Casual(town, 3, 3);
        town.grid[3][3] = new Casual(town, 3, 4);
        
        //4
        town.grid[4][0] = new Streamer(town, 4, 0);
        town.grid[4][1] = new Streamer(town, 4, 1);
        town.grid[4][2] = new Casual(town, 4, 2);
        town.grid[4][4] = new Reseller(town, 4, 3); //RS3
        town.grid[4][3] = new Casual(town, 4, 4);
        
        System.out.println("Testing Reseller.next(), Empty2 with grid:\n"
        		+ "C S S\n"
        		+ "O R O\n"
        		+ "C C S\n");
        
        //Should be empty due to Lack of C
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.EMPTY, nextCell.who());
        
        //Should be empty due to too many E
        nextCell = town.grid[0][4].next(town);
        assertEquals(State.EMPTY, nextCell.who());
        
        //Should be Rdue to enough C
        nextCell = town.grid[4][3].next(town);
        assertEquals(State.RESELLER, nextCell.who());
	}
	
	
	
	
	
	
	@Test
	void ResellerBasic() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E R E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Reseller.who()\n");
        assertEquals(State.RESELLER, town.grid[1][1].who());
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void CasualBasic() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E R E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Casual(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Casual.who()\n");
        assertEquals(State.CASUAL, town.grid[1][1].who());
	}
	
	
	
	
	
	
	
	
	@Test
	void CasualStay() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E C E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Casual(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Casual.next(), Stay using grid\n"
        		+ "E E E\n"
        		+ "E C E\n"
        		+ "E E E\n");
        
        assertEquals(State.CASUAL, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	@Test
	void CasualChangeOutage() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E C R
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Casual(town, 1, 1);
        town.grid[1][2] = new Reseller(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Casual.next(), Stay using grid\n"
        		+ "E E E\n"
        		+ "E C R\n"
        		+ "E E E\n");
        
        assertEquals(State.OUTAGE, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	@Test
	void CasualChangeStreamer() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E C S
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Casual(town, 1, 1);
        town.grid[1][2] = new Streamer(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Casual.next(), Stay using grid\n"
        		+ "E E E\n"
        		+ "E C S\n"
        		+ "E E E\n");
        assertEquals(State.STREAMER, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	@Test
	void CasualStay2() {
		Town town = new Town(5, 5);
		// Test Next Move empty2
        /* 0 1 2 3 4
         * E E E E E 0
         * E E E E E 1
         * E E E E E 2
         * E E E E E 3
         * E E C R C 4
         */
        
		System.out.println("Testing Reseller.next(), Empty3 with grid:\n"
        		+ "E E E E E\n"
        		+ "E E E E E\n"
        		+ "E E E E E\n"
        		+ "E E E E E\n"
        		+ "E E E E E\n");
		
		//0
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Streamer(town, 0, 1);
        town.grid[0][2] = new Streamer(town, 0, 2);
        town.grid[0][3] = new Empty(town, 0, 3);
        town.grid[0][4] = new Reseller(town, 0, 4); //RS2
        
        //1
        town.grid[1][0] = new Outage(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1); //RS1
        town.grid[1][2] = new Outage(town, 1, 2);
        town.grid[1][3] = new Empty(town, 1, 3);
        town.grid[1][4] = new Empty(town, 1, 4);
        
        //2
        town.grid[2][0] = new Casual(town, 2, 0);
        town.grid[2][1] = new Casual(town, 2, 1);
        town.grid[2][2] = new Streamer(town, 2, 2);
        town.grid[2][4] = new Streamer(town, 2, 3);
        town.grid[2][3] = new Streamer(town, 2, 4);
        
        //3
        town.grid[3][0] = new Streamer(town, 3, 0);
        town.grid[3][1] = new Streamer(town, 3, 1);
        town.grid[3][2] = new Empty(town, 3, 2);
        town.grid[3][4] = new Casual(town, 3, 3);
        town.grid[3][3] = new Casual(town, 3, 4);
        
        //4
        town.grid[4][0] = new Streamer(town, 4, 0);
        town.grid[4][1] = new Streamer(town, 4, 1);
        town.grid[4][2] = new Casual(town, 4, 2);
        town.grid[4][4] = new Reseller(town, 4, 3); //RS3
        town.grid[4][3] = new Casual(town, 4, 4);
        
        System.out.println("Testing Reseller.next(), Empty2 with grid:\n"
        		+ "C S S\n"
        		+ "O R O\n"
        		+ "C C S\n");
        
        //Should be empty due to Lack of C
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.EMPTY, nextCell.who());
        
        //Should be empty due to too many E
        nextCell = town.grid[0][4].next(town);
        assertEquals(State.EMPTY, nextCell.who());
        
        //Should be R due to enough C
        nextCell = town.grid[4][3].next(town);
        assertEquals(State.RESELLER, nextCell.who());
	}
	
	
	
	
	
	
	
	
	@Test
	void StreamerStay() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E S E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Streamer(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Streamer.next(), Stay using grid\n"
        		+ "E E E\n"
        		+ "E S E\n"
        		+ "E E E\n");
        assertEquals(State.STREAMER, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	void StreamerChangeOutage() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E S E
         * E E R
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Streamer(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Reseller(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Streamer.next(), Outage using grid\n"
        		+ "E E E\n"
        		+ "E S E\n"
        		+ "E E R\n");
        assertEquals(State.OUTAGE, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	@Test
	void StreamerChangeEmpty() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E O
         * E S E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Outage(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Streamer(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Streamer.next(), Change Empty using grid\n"
        		+ "E E O\n"
        		+ "E S E\n"
        		+ "E E E\n");
        assertEquals(State.EMPTY, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	void EmptyChangeReseller() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* C C S
         * O E S
         * C S C
         */
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Casual(town, 0, 1);
        town.grid[0][2] = new Streamer(town, 0, 2);
        
        town.grid[1][0] = new Outage(town, 1, 0);
        town.grid[1][1] = new Empty(town, 1, 1);
        town.grid[1][2] = new Streamer(town, 1, 2);
        
        town.grid[2][0] = new Casual(town, 2, 0);
        town.grid[2][1] = new Streamer(town, 2, 1);
        town.grid[2][2] = new Casual(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Empty.next(), Change Reseller using grid\n"
        		+ "C C S\n"
        		+ "O E S\n"
        		+ "C S C\n");
        assertEquals(State.RESELLER, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void EmptyChangeCasual() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E E E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Empty(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Empty.next(), Change Casual using grid\n"
        		+ "E E O\n"
        		+ "E S E\n"
        		+ "E E E\n");
        assertEquals(State.CASUAL, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void OutageChangeEmpty() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);

        /* E E E
         * E O E
         * E E E
         */
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Outage(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Empty(town, 2, 1);
        town.grid[2][2] = new Empty(town, 2, 2);
        
        //Test Who 
        System.out.println("Testing Outage.next(), Change Empty using grid\n"
        		+ "E E E\n"
        		+ "E O E\n"
        		+ "E E E\n");
        assertEquals(State.EMPTY, town.grid[1][1].next(town).who());
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void ProfitTest() {
		// Initialize a 3x3 town
        Town town = new Town(3, 3);
        
		//
        /* C S E
         * S O R
         * E C R
         */
        town.grid[0][0] = new Casual(town, 0, 0);
        town.grid[0][1] = new Streamer(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        town.grid[1][0] = new Streamer(town, 1, 0);
        town.grid[1][1] = new Outage(town, 1, 1);
        town.grid[1][2] = new Reseller(town, 1, 2);
        
        town.grid[2][0] = new Empty(town, 2, 0);
        town.grid[2][1] = new Casual(town, 2, 1);
        town.grid[2][2] = new Reseller(town, 2, 2);
		
		
		int profit = 0;
		for (int i = 1; i <= 12; i++) {
			profit = ISPBusiness.getProfit(town);
			town = ISPBusiness.updatePlain(town); 
		}
		System.out.println("Testing Profit.");
		assertEquals(5, profit);
		
	}

}
