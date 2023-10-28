package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {//Posiciona o Objeto na coordenada desejada OBS: ler o arquivo txt do mapa para saber onde posicionar
		
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 9 * gp.tileSize;
		gp.obj[0].worldY = 6 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Door();
		gp.obj[1].worldX = 14 * gp.tileSize;
		gp.obj[1].worldY = 1 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 10 * gp.tileSize;
		gp.obj[2].worldY = 10 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Key();
		gp.obj[3].worldX = 6 * gp.tileSize;
		gp.obj[3].worldY = 6 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Boots();
		gp.obj[4].worldX = 11 * gp.tileSize;
		gp.obj[4].worldY = 6 * gp.tileSize;
		
	}
}
