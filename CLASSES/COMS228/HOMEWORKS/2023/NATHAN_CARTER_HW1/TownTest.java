package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownTest {

    private Town t;

    @BeforeEach
    public void initialize() throws FileNotFoundException {
        t = new Town(2, 2);
        t.randomInit(5);
    }

    @Test
    void testLength() {
        assertEquals(2, t.getLength());
    }

    @Test
    void testWidth() {
        assertEquals(2, t.getWidth());
    }
}
