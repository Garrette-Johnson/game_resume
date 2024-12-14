package gameMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Entity.player;
import tile.TileManager;

public class Panel extends JPanel implements Runnable{ // inherits panel 
	//screen settings
	final int TileSize = 16; // 16x16 title
	final int scale = 3; 
	public final int tileSize = TileSize * scale; // this will displayed on the screen which is 48 x 48
	public final int maxScreenCol = 16; 
	public final int maxScreenRow = 12; 
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels for the width 
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels for the height
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50; 
	public final int maxWorldRow = 50; 
	public final int worldWidth = tileSize * maxWorldCol; 
	public final int worldheight = tileSize * maxWorldRow; //change
	
	//FPS 
	int FPS = 60; 
	
	TileManager tileM = new TileManager(this); 
	keyInput KeyH = new keyInput(); 
	
	//This part is for the fps to run in real time 
	Thread gameThread; //we can start and stop and keeps the program running till you stop it 
	public CollisionChecker cChecker = new CollisionChecker(this); 
	public player player = new player(this, KeyH); 
	
	public Panel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white); //set to black
		this.setDoubleBuffered(true); //for better rendering performance 
		this.addKeyListener(KeyH); //gets key input from teh class 
		this.setFocusable(true);
	}

	
	public void startGameThread() {
		gameThread = new Thread(this); 
		gameThread.start(); //calls run method 
	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0; 
		long lastTime = System.nanoTime(); 
		long currentTime; 
		long timer = 0; 
		long drawCount = 0; 
		
		while(gameThread != null) {
			currentTime = System.nanoTime(); 
			
			delta += (currentTime - lastTime) /drawInterval; 
			timer += (currentTime - lastTime); 
			lastTime = currentTime; 
			
			if (delta >= 1) {
				update(); 
				repaint(); 
				delta--; 
				drawCount++; 
			}
			if(timer >= 1000000000) {
				System.out.println("FPS: " +drawCount); 
				drawCount = 0; 
				timer = 0; 
			}
		}
	}
	
	public void update() {
		player.update(); 
	}
	
	public void paintComponent(Graphics g) { //used to draw stuff on the Jframe, receive graphs as g 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; 
		tileM.draw(g2); //make sure this is before player
		player.draw(g2); 
		g2.dispose(); 
	}
	
}
