package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import gameMain.Panel;
import gameMain.keyInput;

public class player extends entity{
	Panel gp; 
	keyInput keyH; 
	
	public final int screenX; 
	public final int screenY; 
	
	public player(Panel gp, keyInput keyH) {
		
		this.gp = gp; 
		this.keyH = keyH; 
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2); 
		screenY = gp.screenHeight/2 - (gp.tileSize/2); 
		
		solidArea = new Rectangle(8, 17, 10, 16); // you can adjust this to test the collision  the y goes down
								 //x , y, width, height
		setDefaultValues();
		getPlayerImage(); 
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 23; 
		worldY = gp.tileSize * 21; // got 23 and 21 from the txt file where we want character to start 
		speed = 4;
		direction = "down"; 
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_1.png.png")); 
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_2.png.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down_man_1.png")); 
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down_man_2.png.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left_man_1.png")); 
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left_man_2.png.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right_man__1.png")); 
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right_man_2.png.png"));
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) { //
				direction = "up"; 
				
			}
			else if(keyH.downPressed == true) {
				direction = "down"; 
				
			}
			else if(keyH.leftPressed == true) {
				direction = "left"; 
				 
			}
			else if(keyH.rightPressed == true) {
				direction = "right"; 
				
			}  // first we check direction than we check if there is a collision in the next case 
			
			// CHECK TILE COLLISION
			collisionOn = false; 
			gp.cChecker.checkTile(this); 
			
			//If collision is false, player can move
			if(collisionOn == false) {
				switch(direction) {
				case "up": 
					worldY -= speed; 
					break; 
				case "down": 
					worldY += speed; 
					break; 
				case "left": 
					worldX -= speed;
					break; 
				case "right": 
					worldX += speed; 
					break; 
				}
			}
			spriteCounter++; 
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2; 
				}
				else if(spriteNum == 2) {
					spriteNum = 1; 
				}
				spriteCounter = 0; 
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white); //set to white
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);//player charcter 
		BufferedImage image = null; 
		switch(direction) {
		case "up":
			if (spriteNum == 1){
				image = up1; 
			}
			if (spriteNum == 2) {
				image = up2; 
			}
			break; 
		case "down": 
			if (spriteNum == 1) {
				image = down1; 
			}
			if (spriteNum == 2) {
				image = down2; 
			}
			break; 
		case "left": 
			if (spriteNum == 1) {
				image = left1; 
			}
			if (spriteNum == 2) {
				image = left2; 
			}
			 
			break; 
		case "right": 
			if (spriteNum == 1) {
				image = right1; 
			}
			if (spriteNum == 2) {
				image = right2; 
			} 
			break; 
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); 
	}
}
