package com.nosheep.tools;

import java.io.Serializable;
import java.util.List;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.enemy.Enemy;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class UnknownPortal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046200743445136853L;
	private int counter = 0;
	public boolean active = false;
	private int positionX, positionY, width, height;
	
	private List<Enemy> enemies;
	private Player player;
	
	private transient AnimatedSprite portalAnimation;
	
	public UnknownPortal(List<Enemy> enemies, Player player){
		this.enemies = enemies;
		this.player = player;
		positionX = (int)(Math.random() * 2000);
		positionY = (int)(Math.random() * 2000);
		width = 128;
		height = 128;
		portalAnimation = AssetLoader.unknownPortal;
	}
	public void render(SpriteBatch batch){
		update();
		if(active){
			portalAnimation.setPosition(positionX, positionY);
			portalAnimation.setSize(width, height);
			portalAnimation.draw(batch);
		}
	}
	public void update(){
		if(active){
			counter = 0;
			if(positionX + width/2 >= player.getPositionX()){
				player.setPositionX(player.getPositionX() + 5);
			}
			
			if(positionX <= player.getPositionX()){
				player.setPositionX(player.getPositionX() - 5);
			}
			
			if(positionY + height/2 >= player.getPositionY()){
				player.setPositionY(player.getPositionY() + 5);
			}
			
			if(positionY <= player.getPositionY()){
				player.setPositionY(player.getPositionY() - 5);
			}
			
			if(positionX + width >= player.getPositionX() &&
					positionX <= (player.getPositionX() + player.getWidth()) &&
					positionY + height >= player.getPositionY() &&
					positionY <= (player.getPositionY() + player.getHeight())){
				rpgGame.unknownArea.get(0).enemies.get(0).setAlive(true);
				rpgGame.unknownArea.get(0).enemies.get(0).setCurrentHealth(rpgGame.unknownArea.get(0).enemies.get(0).getCurrentHealth() - 1);
				rpgGame.map = rpgGame.unknownArea;
				active = false;
			}
			
			for(Enemy e: enemies){
				
				if(positionX + width/2 >= e.getPositionX()){
					e.setPositionX(e.getPositionX() + 5);
				}
				
				if(positionX <= e.getPositionX()){
					e.setPositionX(e.getPositionX() - 5);
				}
				
				if(positionY + height/2 >= e.getPositionY()){
					e.setPositionY(e.getPositionY() + 5);
				}
				
				if(positionY <= e.getPositionY()){
					e.setPositionY(e.getPositionY() - 5);
				}
				
				if(positionX + width >= e.getPositionX() &&
						positionX <= (e.getPositionX() + e.getWidth()) &&
						positionY + height >= e.getPositionY() &&
						positionY <= (e.getPositionY() + e.getHeight())){
					e.setAlive(false);
				}
			}
		}
		else{
			if(rpgGame.map == rpgGame.alphaCave){
				//counter = 14900;
				counter++;
				System.out.println(counter);
				if(counter >= 15000){
					positionX = (int)(Math.random() * 2000);
					positionY = (int)(Math.random() * 1000);
					active = true;
				}
			}
			else
				active = false;
		}
	}
	public void setLink(Player player){
		this.player = player;
	}
	
}
