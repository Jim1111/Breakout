package Breakout;

import java.awt.*;

public class Ball {
	
	Blocks blocks;
	
	int x = 0; // Initial value - x ball
	int y = 0; // Initial value - y ball
	int xa = 1; // Slide x+1
	int ya = 2; // Slide y+1

	public void moveBall(int winWidth, int winHt) { // window Width and Height

		if (x + 30 > winWidth) {
			xa = -xa;
		}

		if (x < 0) {
			xa = -xa;
		}
		x = x + xa;

		if (y + 30 > winHt) {
			ya = -ya;
		}

		if (y < 0) {
			ya = -ya;
		}
		y = y + ya;

	}

	public void drawBall(Graphics g) {
		g.setColor(Color.yellow); // the colour of the ball
		g.fillOval(x, y, 20, 20); // the dimensions of the ball

	}

	public void collBat(int batX, int batY, int batWidth, int batHt) { // the top and bottom sides of the bat
		if ((y + 20 > batY) && (x + 20 > batX) && (x <= batX + batWidth)) {
			ya = -ya; // bounces off in another direction
		}
	}

	public boolean collBlocks(int blockX, int blockY, int blockkWth, int blockHt) { // the top and bottom sides of the blocks
		boolean hit = false;		
		if ((y + 20 > blockY) && (x + 20 > blockX) && (x <= blockX + blockkWth) && (y <= blockY + blockHt)) {
			//blocks.isD(hit);
			ya = -ya; // bounces off in another direction
			hit=true;
		}			
		return hit;
		}
}