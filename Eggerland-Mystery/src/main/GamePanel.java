package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import entity.Projectile;
import tile.TileManager;

import main.sound.Sound;

public class GamePanel extends JPanel implements Runnable {
//Essa classe eh responsavel pelo controle do fluxo de jogo

	
	//Parametros de Tela
	final int originalTileSize = 16; 
	final int scale = 3;
	
	public final int tileSize = originalTileSize  * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 13;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//MAPAS
	public final int maxMap = 10;
	public int currentMap;
	
	//FPS 
	int FPS = 60;
	
	//Sistema
	public TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public MonsterSetter monsterSetter = new MonsterSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//Entidade e Objetos
	public Player player = new Player(this,keyH);
	public Entity obj[][] = new Entity[maxMap][25]; //SuperObject[] recebe o numero de objetos simultaneos
	//public ArrayList<Entity> monsterList = new ArrayList<>();
	public Entity[][] monsterList = new Entity[maxMap][10];
	public ArrayList<Projectile> projectileList = new ArrayList<>();
	
	//Estado de Jogo
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	// Parametros do Jogador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	// Sons
    public Sound music = new Sound();
    public Sound se = new Sound(); // Sound Effect
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		currentMap = MapFileManager.readCurrentMap();
	}
	
	public void setupGame() {//Coloca os objetos e monstros no nivel
		
		aSetter.setObject();
		monsterSetter.setMonsters();
		
		gameState = playState;
		
	    // playMusic(0); // Start background music
	}

	public void startGameThread() {//Inicia a thread do jogo
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void resetGame() {//Reseta a fase
		playSE(4);
		player.setDefaultValues();
		setupGame();
		
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / (drawInterval);
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				//UPDATE: atualiza informacao
				update();
				//DRAW: desenha tela com informacao atualizada
				repaint();
				delta--;
				drawCount++;
			}

			if(timer >= 1000000000) {
				/* System.out.println("FPS:" + drawCount); */
				drawCount = 0;
				timer = 0;
			}
		}
	}
	public void update() {// Atualiza constantemente o jogo
		                          
		if(gameState == playState) {
			player.update();
		}
		if(gameState == pauseState) {
			// nada, jogo pausado
		}
		
		for (int i = 0; i < monsterList[currentMap].length; i++) {
			if (monsterList[currentMap][i] != null) {
				monsterList[currentMap][i].update(); 
			}
		}
		
		for (int i = 0; i < obj[currentMap].length; i++) {
			if (obj[currentMap][i] != null) {
				obj[currentMap][i].update();
			}
		}
		
		
		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				projectileList.get(i).update();
			}
		}
	}
	
	public void paintComponent(Graphics g) {// Desenha os componentes do jogo na tela
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		// Blocos
		tileM.draw(g2);
		
		//Objetos
		for(int i = 0; i < obj[1].length; i++) {
			if(obj[currentMap][i] != null) {
				obj[currentMap][i].draw(g2);
			}
		}
		
		// Monstros
		for (int i = 0; i < monsterList[1].length; i++) {
			if (monsterList[currentMap][i] != null) {
				monsterList[currentMap][i].draw(g2);
			}
		}
		
		// Projeteis
		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				projectileList.get(i).draw(g2);
			}
		}
		
		// Jogador
		player.draw(g2);
		
		//Interface de Usuario
		ui.draw(g2);
		
		g2.dispose();
	}
	
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }
    
	
}
