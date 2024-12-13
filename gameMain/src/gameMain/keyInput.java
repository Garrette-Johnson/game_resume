package gameMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInput implements KeyListener{
	public boolean upPressed, downPressed, leftPressed, rightPressed; 
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode(); //returns number of key that was pressed 
		
		if (code == KeyEvent.VK_W) { //checks if key equals w 
			upPressed = true; 
		}
		if (code == KeyEvent.VK_S) { //checks if key equals w 
			downPressed = true; 
		}
		if (code == KeyEvent.VK_A) { //checks if key equals w 
			leftPressed = true; 
		}
		if (code == KeyEvent.VK_D) { //checks if key equals w 
			rightPressed = true; 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode(); 
		
		if (code == KeyEvent.VK_W) { //checks if key equals w 
			upPressed = false; 
		}
		if (code == KeyEvent.VK_S) { //checks if key equals w 
			downPressed = false; 
		}
		if (code == KeyEvent.VK_A) { //checks if key equals w 
			leftPressed = false; 
		}
		if (code == KeyEvent.VK_D) { //checks if key equals w 
			rightPressed = false; 
		}
	}
	
}

