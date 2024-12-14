package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity { // this will have variables that will be used on player, monster,and NPC
	public int worldX, worldY; 
	public int speed; 
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; 
	
	public String direction; 
	
	public int spriteCounter = 0; 
	public int spriteNum = 1; 
	public Rectangle solidArea; // this will be for the collison
	public boolean collisionOn = false; 
}
