package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import object.OBJ_Eggshot;
import object.OBJ_Key;
import object.OBJ_Lolo;

public class UI {//Classe responsavel por desenhar informacoes na tela
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40, arial_80B, arial_20;
	BufferedImage keyImage;
	BufferedImage loloImage;
	BufferedImage shotImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.0");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		arial_20 = new Font("Arial", Font.PLAIN, 20);
		OBJ_Key key = new OBJ_Key(gp);
		OBJ_Eggshot egg = new OBJ_Eggshot(gp);
		OBJ_Lolo lolo = new OBJ_Lolo(gp);
		keyImage = key.image;
		shotImage = egg.horizontal;
		loloImage = lolo.image;
		
				
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		if(gp.gameState == gp.playState) {
			// Do playState stuff later
		
		
		if(gameFinished == true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Your time is : " + dFormat.format(playTime) + "!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*4);
			g2.drawString(text, x, y);

			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			text = "FIM";
			gp.playSE(3);
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2;
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}
		
		else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(loloImage, 13*gp.tileSize, 3*gp.tileSize, gp.tileSize, gp.tileSize, null);
			g2.drawImage(shotImage, 13*gp.tileSize, 4*gp.tileSize, gp.tileSize, gp.tileSize, null);
			g2.drawString(" " + gp.player.shotCount, 14*gp.tileSize + 5 , 5*gp.tileSize - 5);
			g2.drawString(" " + gp.player.lifeCount, 14*gp.tileSize + 5 , 4*gp.tileSize - 5);
			
			// Tempo
			playTime += (double)1/60;
			g2.setFont(arial_20);
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*13, gp.tileSize*12 -3);
			
			// Mensagem
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
				
				messageCounter++;
				
				if(messageCounter > 120) { // 120 = 60FPS x 2, ou seja , mensagem dura 2 segundos
					messageCounter = 0;
					messageOn = false;
				}
			}
		  }
		}
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawPauseScreen() {//Desenha a tela de Pause
		
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,90F));
		String text = "Paused";
		int x;
		
		x = gp.screenWidth/2;
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}

}
