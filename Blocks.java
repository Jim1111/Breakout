package Breakout;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author James Flint
 * 
 */
public class Blocks {

	boolean d = false;

	Ball ball;

	int blockX; // x block position
	int blockY; // y block position

	int width = 100; // block Across
	int height = 20; // block Down

	public Blocks(int blockX, int blockY) { // the constructor
		this.blockX = blockX; // where a block starts
		this.blockY = blockY;
	}

	public void drawBlocks(Graphics g) {
		Color[] ColorArray = { Color.RED, Color.WHITE, Color.BLUE }; // Array to set
		// colours,
		// unimplemented
		if (!d) {
			g.setColor(Color.GREEN); // the Blocks are blue
			g.fillRect(blockX, blockY, width, height);
		}
	}

	// ////////// Getter //////////////////

	public int getX() {
		return blockX;
	}

	public int getY() {
		return blockY;
	}

	public int getBoxWt() {
		return width;
	}

	public int getBoxHt() {
		return height;
	}

	// Getter

	public boolean isD(boolean hit) {
		return d = hit;
	}	

	// Setter

	public void setDestroyed(boolean hit) {
		this.d = hit; // hit
	}
}
