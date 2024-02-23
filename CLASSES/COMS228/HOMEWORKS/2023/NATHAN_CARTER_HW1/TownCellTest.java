package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownCellTest {
    
    private Town t;

    @BeforeEach
    public void initialize() throws FileNotFoundException {
        t = new Town("ISP4x4.txt");
    }

    @Test
    public void testCensus() {
        String str = t.grid[1][1].next(t).who().toString();
        assertEquals(State.EMPTY.toString(), str);
    }
}
