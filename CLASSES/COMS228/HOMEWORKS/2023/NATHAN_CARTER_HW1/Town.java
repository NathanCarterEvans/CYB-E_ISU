package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nathan Carter
 *
 */
public class Town {

	private int length, width; //Row and col (first and second indices)
	public TownCell[][] grid;

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		
		//inint functions
		File f = new File(inputFileName);
		Scanner s = new Scanner(f);
		
		//set up grid
		this.length = s.nextInt();
		this.width = s.nextInt();
		grid = new TownCell[length][width];
		s.nextLine();//Adding due to buffer line... Delete this if out of range happens
		
		//main loop
		for(int i = 0; i <this.length; i++) {
			String[] row = s.nextLine().split(" ");
			for(int j = 0; j <this.width; j++) {
				switch(row[j].charAt(0)) {//adding char at 0 due to \t being a thing
				case 'C':
					grid[i][j] = new Casual(this, i, j);
					break;
				case 'E':
					grid[i][j] = new Empty(this, i, j);
					break;
				case 'R':
					grid[i][j] = new Reseller(this, i, j);
					break;
				case 'O':
					grid[i][j] = new Outage(this, i, j);
					break;
				case 'S':
					grid[i][j] = new Streamer(this, i, j);
					break;
				default:
					break;
				}
			}
		}
		//This a usefull comment
		s.close();
	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return Length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		for(int i = 0;i <= length-1; i++ ) {
			for(int j = 0;j <= width-1; j++) {
				switch(rand.nextInt()) {
				case TownCell.RESELLER:
					grid[i][j] = new Reseller(this, i, j);
					break;
				case TownCell.EMPTY:
					grid[i][j] = new Empty(this, i, j);
					break;
				case TownCell.CASUAL:
					grid[i][j] = new Casual(this, i, j);
					break;
				case TownCell.OUTAGE:
					grid[i][j] = new Outage(this, i, j);
					break;
				case TownCell.STREAMER:
					grid[i][j] = new Streamer(this, i, j);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < getLength(); i++) {
	        if (i != 0) {
	            sb.append("\n");
	        }

	        for (int j = 0; j < getWidth(); j++) {
	            State cellState = grid[i][j].who();
	            
	            switch (cellState) {
	                case CASUAL:
	                    sb.append("C ");
	                    break;
	                case EMPTY:
	                    sb.append("E ");
	                    break;
	                case RESELLER:
	                    sb.append("R ");
	                    break;
	                case OUTAGE:
	                    sb.append("O ");
	                    break;
	                case STREAMER:
	                    sb.append("S ");
	                    break;
	                default:
	                    // Handle unexpected state, if needed
	                    sb.append("? ");
	            }
	        }
	    }

	    return sb.toString();
	}
}
