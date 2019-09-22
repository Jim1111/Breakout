package Breakout;

import java.awt.*;

public class Bat{
	int batY;
	int batX;

	public Bat(int batX, int batY) {
		this.batX = batX;
		this.batY = batY;
	}
	
	///// controls the bat speed
	public void moveBat(boolean right, boolean left) {
		if (right)
			if (batX > 0)
				batX -= 5;
		
		if (left)
			if (batX + 60 < 750)
				batX += 5;
	}
	//////////////////////////////////////

	public void drawBat(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(batX, batY, 200, 15);
	}
	
	public int getbatX() {
	    return batX;
	     }
	public int getbatY() {
	    return batY;
	     }
	public int getWt() {
	    return 200;
	     }
	public int getHt() {
	    return 15;
	     }

	
}
