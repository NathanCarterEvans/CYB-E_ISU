package edu.iastate.cs228.hw1;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ISPBusinessTest {

    private Town t;

    @BeforeEach
    public void setUp() {
        t = new Town(2, 2);
        t.grid[0][0] = new Empty(t, 0, 0);
        t.grid[0][1] = new Empty(t, 0, 1);
        t.grid[1][0] = new Casual(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);
    }

    @Test
    public void testCensus() {
        assertEquals(2, ISPBusiness.getProfit(t));
    }
}
