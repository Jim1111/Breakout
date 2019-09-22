package Breakout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Game extends JFrame implements Runnable, KeyListener {

	// // classes ////
	Ball ball; // from the Ball class
	Bat bat; // from the Bat class

	boolean hit = false;
	
	Blocks[][] blocks = new Blocks[3][5]; // this multi-dimensional add the blue blocks

	int i;// goes down the block
	int j; // goes across the block

	// //// bat direction //////////
	boolean leftBat, rightBat;
	// /// background ////////////
	private Image bg;
	// /// background loaded //////////////
	private boolean loaded;

	public Game() {
		setTitle("Breakout");
		setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		setSize(900, 700);
		setVisible(true);
		createBufferStrategy(2);

		/*
		 * The loop does not properly work, but I have included it for reference.
		 * 
		 * 
		 * int a = 100; // goes across int b = 100; int b = 100; // goes across
		 * int b = 100;
		 * 
		 * for (i = 0; i < blocks.length; i++) { for (j = 0; j < blocks.length;
		 * j++) {
		 * 
		 * blocks[i][j] = new Blocks(b, a); String s; String o;
		 * System.out.print(s = Integer.toString(i) + " "); System.out.println(o
		 * = Integer.toString(j) + " " + b + " " + a); System.out.println("");
		 * 
		 * a=a+50; } b=b+200; }
		 */
		
		// This works
		
		blocks[0][0] = new Blocks(100, 100);
		blocks[0][1] = new Blocks(100, 200);
		blocks[0][2] = new Blocks(100, 300);
		blocks[0][3] = new Blocks(100, 400);
		blocks[0][4] = new Blocks(100, 500);

		blocks[1][0] = new Blocks(250, 100);
		blocks[1][1] = new Blocks(250, 200);
		blocks[1][2] = new Blocks(250, 300);
		blocks[1][3] = new Blocks(250, 400);
		blocks[1][4] = new Blocks(250, 500);

		blocks[2][0] = new Blocks(400, 100);
		blocks[2][1] = new Blocks(400, 200);
		blocks[2][2] = new Blocks(400, 300);
		blocks[2][3] = new Blocks(400, 400);
		blocks[2][4] = new Blocks(400, 500);

		/*
		blocks[3][0] = new Blocks(550, 100);
		blocks[3][1] = new Blocks(550, 150);
		blocks[3][2] = new Blocks(550, 200);
		blocks[3][3] = new Blocks(550, 250);
		blocks[3][4] = new Blocks(550, 300);

		blocks[4][0] = new Blocks(700, 100);
		blocks[4][1] = new Blocks(700, 150);
		blocks[4][2] = new Blocks(700, 200);
		blocks[4][3] = new Blocks(700, 250);
		blocks[4][4] = new Blocks(700, 300);
*/
		bat = new Bat(450, 650); // Dimensions of the bat
		ball = new Ball();
	}

	// ///// Runnable - the game loop ////////////
	public void run() {
		while (true) {
			drawObjects();
			try {
				Thread.sleep(10); // redraw each frame after 1-mS
			} catch (InterruptedException e) {
			}
		}
	}

	// this method is called whenever a key is pressed

	public void keyPressed(KeyEvent key) {

		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
			rightBat = true;
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
			leftBat = true;
	}

	// this method is called whenever a key is released

	public void keyReleased(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
			rightBat = false;
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
			leftBat = false;
	}

	private boolean drawObjects() {
		BufferStrategy bf = getBufferStrategy();
		Graphics g = bf.getDrawGraphics();
		// first clear the screen
		g.clearRect(0, 0, getWidth(), getHeight());

		bat.drawBat(g);
		bat.moveBat(leftBat, rightBat);
		ball.collBat(bat.getbatX(), bat.getbatY(), bat.getWt(), bat.getHt()); // Bat hit

		// /// the ball ///////////////
		ball.drawBall(g);
		ball.moveBall(getWidth(), getHeight());

		// //// the blocks //////////////
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				hit=ball.collBlocks(blocks[i][j].getX(), blocks[i][j].getY(),blocks[i][j].getBoxWt(), blocks[i][j].getBoxHt()); // Blocks hit
				if (hit == true) {
					hit=ball.collBlocks(blocks[i][j].getX(), blocks[i][j].getY(),blocks[i][j].getBoxWt(), blocks[i][j].getBoxHt()); 
					
					hit=blocks[i][j].isD(hit);
					//blocks[i][j].setDestroyed(hit);
					
					}
				blocks[i][j].drawBlocks(g);
			}
		}

		// /////// text ///////////////////////////
		g.setColor(Color.ORANGE);
		g.setFont(new Font("Ariel", Font.PLAIN, 25));
		g.drawString("Level: " + 1, 50, 60);  // Level
		g.drawString("Score: " + 0, 400, 60); // Score
		g.drawString("Lives left: " + 3, 700, 60); // Lives left

		// Show the new image
		g.dispose();
		bf.show();
		Toolkit.getDefaultToolkit().sync();
		return hit;
	}

	// This part of the game was not implemented
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	// /////////////////////////////////////////
	// not used ///////////////////////////////

	public void keyTyped(KeyEvent arg0) {

	}
}
// /////////////////////////////////////////