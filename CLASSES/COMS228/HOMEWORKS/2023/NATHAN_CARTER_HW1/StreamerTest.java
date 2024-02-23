package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Nathan Carter
 */
//TODO CHANGE ME!
public class StreamerTest {

    private Town town;
    private Reseller reseller;

    @Before
    public void setUp() {
        // Initialize a 3x3 town
        town = new Town(3, 3);
        
        // Place a Reseller at (1, 1)
        town.grid[1][0] = new Empty(town, 1, 0);
        town.grid[1][1] = new Reseller(town, 1, 1);
        town.grid[1][2] = new Empty(town, 1, 2);
    }

    @Test
    public void testWho() {
        assertEquals(State.RESELLER, town.grid[1][1].who());
    }

    @Test
    public void testNext() {
        // Populate the town with some conditions for the Reseller
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Casual(town, 0, 1);
        town.grid[0][2] = new Casual(town, 0, 2);
        town.grid[1][1] = new Reseller(town, 1, 1);
        
        // Expecting the Reseller to remain as a Reseller based on the conditions
        TownCell nextCell = town.grid[1][1].next(town);
        assertEquals(State.RESELLER, nextCell.who());
    }

    @Test
    public void testNextTurnsEmpty() {
        // Populate the town with conditions for the Reseller to turn Empty
        town.grid[0][0] = new Empty(town, 0, 0);
        town.grid[0][1] = new Empty(town, 0, 1);
        town.grid[0][2] = new Empty(town, 0, 2);
        
        // Expecting the Reseller to turn Empty based on the conditions
        TownCell nextCell = reseller.next(town);
        assertEquals(State.EMPTY, nextCell.who());
    }
}
