package Breakout;

// This is the main method, I have put the main method in its own class for clarity
public class main {
	public static void main(String[] args) {
		Game G = new Game();
		Thread runner = new Thread(G);
		runner.start();
	}
}
