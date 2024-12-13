package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import gameMain.Panel;
import gameMain.keyInput;

public class player extends entity{
	Panel gp; 
	keyInput keyH; 
	
	public player(Panel gp, keyInput keyH) {
		
		this.gp = gp; 
		this.keyH = keyH; 
		setDefaultValues();
		getPlayerImage(); 
	}
	
	public void setDefaultValues() {
		x = 100; 
		y = 100; 
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
				y -= speed; 
			}
			else if(keyH.downPressed == true) {
				direction = "down"; 
				y += speed; 
			}
			else if(keyH.leftPressed == true) {
				direction = "left"; 
				x -= speed; 
			}
			else if(keyH.rightPressed == true) {
				direction = "right"; 
				x += speed; 
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
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null); 
	}
}
