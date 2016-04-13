package com.nosheep.tools;

import java.io.Serializable;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.map.Map;
import com.nosheep.player.Player;
import com.nosheep.skills.Skill;

public class Portal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4578326289948180090L;
	private Player player;
	private boolean onPlayer;
	private String text = new String();
	private transient Sprite image = null;
	
	public static enum Type{
		UP, DOWN, LEFT, RIGHT, ZONE;
	}
	private Type type;
	private List<Map> zone;
	private byte mapIndex = 0;
	
	private int positionX, positionY, width, height;
	private boolean visible;
	
	public Portal(Player player, int positionX, int positionY, boolean visible){
		this.player = player;
		this.positionX = positionX;
		this.positionY = positionY;
		this.visible = visible;
		width = 42;
		height = 64;
		text = "Portal";
	}
	
	public Portal(Player player, int positionX, int positionY, int width, int height, boolean visible){
		this.player = player;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.visible = visible;
		width = 42;
		height = 64;
		text = "Portal";
	}
	
	public void render(SpriteBatch batch){
		if(visible)
			if(image == null)
				batch.draw(AssetLoader.portal, positionX, positionY, width, height);
			else
				batch.draw(image, positionX, positionY, width, height);
		
		if(onPlayer){
			batch.draw(AssetLoader.ui, positionX - 20, positionY + 130, 160, 45);
			batch.draw(AssetLoader.blackBorder, positionX - 20, positionY + 130, 160, 45);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, text + "(F)", positionX - 5, positionY + 140);
			
			if(Gdx.input.isKeyJustPressed(Keys.F)){	
				teleport();
			}
		}
	}

	public void teleport(){
		if(type == Type.UP){
			
		}
		if(type == Type.DOWN){
			
		}
		if(type == Type.LEFT){
			
		}
		if(type == Type.RIGHT){
			
		}
		if(type == Type.ZONE){
			for(Skill s : player.activeSkills) 
				s.setActive(false);
			player.activeSkills.clear();
			for(Enemy e : rpgGame.map.get(rpgGame.mapIndex).enemies) {
				e.setTarget(false);
				e.setCombat(false);
			}
			rpgGame.map = zone;
			rpgGame.mapIndex = mapIndex;
			player.zone = rpgGame.map;
			player.mapIndex = rpgGame.mapIndex;
		}
	}
	
	public void setLink(Player player){
		this.player = player;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Map> getZone() {
		return zone;
	}

	public void setZone(List<Map> zone) {
		this.zone = zone;
	}

	public boolean isOnPlayer() {
		return onPlayer;
	}

	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte getMapIndex() {
		return mapIndex;
	}

	public void setMapIndex(byte mapIndex) {
		this.mapIndex = mapIndex;
	}

	public Sprite getImage() {
		return image;
	}

	public void setImage(Sprite image) {
		this.image = image;
	}
	
}
