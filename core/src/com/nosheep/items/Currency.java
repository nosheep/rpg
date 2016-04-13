package com.nosheep.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public abstract class Currency implements Item, Serializable{

	private static final long serialVersionUID = -4110617879535460669L;
	
	public int amount;
	protected String name;
	public boolean showInfo = false;
	private int positionX, positionY;
	protected Sprite image;
	public int lootTimer = 0;
	public boolean onPlayer;
	
	public Currency(int positionX, int positionY, int amount){
		this.positionX = positionX;
		this.positionY = positionY;
		this.amount = amount;
	}

	@Override
	public void render(SpriteBatch batch) {
		try{
			batch.draw(image, positionX, positionY, 50, 50);
			if(onPlayer){
				batch.draw(AssetLoader.ui, positionX - 30, positionY - 90, 135, 35);
				batch.draw(AssetLoader.blackBorder, positionX - 30, positionY - 90, 135, 35);
				batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
				batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
				batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
				rpgGame.font.setColor(Color.YELLOW);
				rpgGame.font.draw(batch, name + ": " + amount, positionX - 70, positionY - 45);
				rpgGame.font.draw(batch, "Loot (F)", positionX - 25, positionY - 85);
			}
			if(rpgGame.checkHover(positionX, positionY, 50, 50)){
				batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
				batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
				batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
				rpgGame.font.setColor(Color.YELLOW);
				rpgGame.font.draw(batch, name + ": " + amount, positionX - 70, positionY - 45);
			}
		}
		catch(NullPointerException ex){}
	}

	@Override
	public void update() {
		lootTimer++;
	}

	@Override
	public boolean checkPlayer(Player player) {
		if(player.getPositionX() + player.getWidth() >= positionX-10 &&
				player.getPositionX() <= (positionX-10 + 70) &&
				(player.getPositionX() + player.getWidth()) >= positionX-10 &&
				player.getPositionY() + player.getHeight() >= positionY-10 &&
				player.getPositionY() <= (positionY-10 + 70) &&
				(player.getPositionY() + player.getHeight()) >= positionY-10){
			onPlayer = true;
			return true;
		}
		else{
			onPlayer = false;
			return false;
		}
	}

	@Override
	public int getLootTimer() {
		// TODO Auto-generated method stub
		return lootTimer;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
